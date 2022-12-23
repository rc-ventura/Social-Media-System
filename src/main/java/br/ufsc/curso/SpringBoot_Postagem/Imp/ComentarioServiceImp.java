
package br.ufsc.curso.SpringBoot_Postagem.Imp;

import br.ufsc.curso.SpringBoot_Postagem.Services.*;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Comentario;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.ComentarioRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.PostagemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class ComentarioServiceImp {
    
    
    @Autowired
    private PostagemRepository postagemRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
   
    
    
    //CRUD - Service
    
    //Get
    public List <Comentario> findAll(){
        return comentarioRepository.findAll();
    }
   
    //GET{id}
    public Comentario findById (Long Id){
        return comentarioRepository.findById(Id).get();  
    // fazer o tratamento de exception
    }
    
    //POST
    public Comentario save (Comentario comentario){
        return comentarioRepository.save(comentario);
        
    }
    //DELETE
    public void delete (Long id){
       comentarioRepository.deleteById(id);
    } // fazer um tratamento de exception
    
    //PUT
    public Comentario update (Long id, Comentario comentario){
        Comentario comentarioEntity = comentarioRepository.getReferenceById(id);
        comentarioEntity.setNome(comentario.getNome());
        comentarioEntity.setData(comentario.getData());
        comentarioEntity.setText(comentario.getText());
        return comentarioRepository.save(comentarioEntity);
    }
    
    //ADD RELACIONAMENTOS 
    /**
    
        //Comentario [+ comentario]
    public Comentario addComentario ( Long id_comentario, Long id_comentario){
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setComentario(comentario);
        comentarioRepository.save(comentario);
        return comentario;  
        
    }
       //Comentario [+ assunto]
    public Comentario addAssunto(Long id_comentario, Long id_assunto){
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        comentario.getAssuntos().add(assunto);
        comentarioRepository.save(comentario);
        return comentario;
    }
    
    //REMOVE RELACIONAMENTOS

        //Comentario [- comentario]
    public Comentario removeComentario(Long id_comentario, Long id_comentario){
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setComentario(null);
        comentarioRepository.save(comentario);
        return comentario;
        
    }
          //Comentario [- assunto]
    public Comentario removeAssunto(Long id_comentario, Long id_assunto){
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        comentario.getAssuntos().remove(assunto);
        comentarioRepository.save(comentario);
        return comentario;
    
}*/

}