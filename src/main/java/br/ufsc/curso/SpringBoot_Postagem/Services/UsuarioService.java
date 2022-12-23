
package br.ufsc.curso.SpringBoot_Postagem.Services;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author RC_Ventura
 */
public interface UsuarioService {
    
      //Get
    public List <Usuario> findAll();
    
   
    //GET{id}
    public Usuario findById (Long Id);
     
     //GET{nome} - SQL
    
    public List<Usuario> findByName(String nome);
      
    
    //GET{login} - SQL
    
    public List<Usuario> findByLogin(String login);
       
    
    //POST
    public Usuario save (Usuario usuario);
      
    //DELETE
    public void delete (Long id);
     
    
    //PUT
    public Usuario update (Long id, Usuario usuario);
      
   /* 
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
*/
    
}
