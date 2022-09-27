
package br.ufsc.curso.SpringBoot_Postagem.Services;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Assunto;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Comentario;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.AssuntoRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.ComentarioRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.PostagemRepository;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class PostagemService {
    
    
    @Autowired
    private PostagemRepository postagemRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Autowired
    private AssuntoRepository assuntoRepository;
    
    
    
    //CRUD - Service
    
    //Get
    public List <Postagem> findAll(){
        return postagemRepository.findAll();
    }
   
    //GET{id}
    public Postagem findById (Long  id){
      try {
           return postagemRepository.findById(id).get();  
       }catch (NoSuchElementException ex){
           
           throw new EntityNotFoundException ("Objeto não encontrado Postagem id: " + id );
       }
    }
    
    //POST
    public Postagem save (Postagem postagem){
        return postagemRepository.save(postagem);
        
    }
    //DELETE
    public void delete (Long id){
       postagemRepository.deleteById(id);
    }
    
    //PUT
    public Postagem update (Long id, Postagem postagem){
        Postagem postagemEntity = postagemRepository.getReferenceById(id);
        postagemEntity.setData(postagem.getData());
        postagemEntity.setTitulo(postagem.getTitulo());
        postagemEntity.setTitulo(postagem.getTitulo());
        postagemEntity.setEditor(postagem.getEditor());
        return postagemRepository.save(postagemEntity);
    }
    
    //ADD RELACIONAMENTOS
    
        //Postagem [+ comentario]
    public Postagem addComentario ( Long id_postagem, Long id_comentario){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setPostagem(postagem);
        comentarioRepository.save(comentario);
        return postagem;
        
    }
       //Postagem [+ assunto]
    public Postagem addAssunto(Long id_postagem, Long id_assunto){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        postagem.getAssuntos().add(assunto);
        postagemRepository.save(postagem);
        return postagem;
    }
    
    //REMOVE RELACIONAMENTOS

        //Postagem [- comentario]
    public Postagem removeComentario(Long id_postagem, Long id_comentario){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setPostagem(null);
        comentarioRepository.save(comentario);
        return postagem;
        
    }
          //Postagem [- assunto]
    public Postagem removeAssunto(Long id_postagem, Long id_assunto){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        postagem.getAssuntos().remove(assunto);
        postagemRepository.save(postagem);
        return postagem;
    
}

}