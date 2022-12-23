
package br.ufsc.curso.SpringBoot_Postagem.Imp;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.UsuarioRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.PostagemRepository;
import br.ufsc.curso.SpringBoot_Postagem.Services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class UsuarioServiceImp implements UserDetailsService, UsuarioService {     //busca por login e retorno do role
    
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PostagemRepository postagemRepository;
    
    
    
    //CRUD - Service
    
    //Get
    public List <Usuario> findAll(){
        return usuarioRepository.findAll();
    }
   
    //GET{id}
    public Usuario findById (Long Id){
        return usuarioRepository.findById(Id).get();  
    // fazer o tratamento de exception
    }
    
     //GET{nome} - SQL
    
    public List<Usuario> findByName(String nome){
        return usuarioRepository.findByName(nome);
        
    } 
    
    //GET{login} - SQL
    
    public List<Usuario> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
        
    } 
    
    //POST
    public Usuario save (Usuario usuario){
        return usuarioRepository.save(usuario);
        
    }
    //DELETE
    public void delete (Long id){
       usuarioRepository.deleteById(id);
    } // fazer um tratamento de exception
    
    //PUT
    public Usuario update (Long id, Usuario usuario){
        Usuario usuarioEntity = usuarioRepository.getReferenceById(id);
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setLogin(usuario.getLogin());
        usuarioEntity.setSenha(usuario.getSenha());
        return usuarioRepository.save(usuarioEntity);
    }
    
    //ADD RELACIONAMENTOS
    
        //Usuario [+ postagem]
    public Usuario addPostagem( Long id_usuario, Long id_postagem){
        Usuario usuario = usuarioRepository.findById(id_usuario).get();
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        
       
        postagem.setUsuario(usuario);
        postagemRepository.save(postagem);
        return usuario;
        
    }
       
    
    //REMOVE RELACIONAMENTOS

        //Usuario [- postagem]
    public Usuario removePostagem(Long id_usuario, Long id_postagem){
        Usuario usuario = usuarioRepository.findById(id_usuario).get();
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        
        postagem.setUsuario(null);
        postagemRepository.save(postagem);
        return usuario;
        
    }

    //implementacao Spring Security
    
    @Override
    public UserDetails loadUserByUsername(String username)  {
        
        Usuario usuario = (Usuario) usuarioRepository.findByLogin(username);
        
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        
        return new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
    }

}