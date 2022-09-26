
package br.ufsc.curso.SpringBoot_Postagem.Services;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Assunto;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.AssuntoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class AssuntoService {
    
    
    @Autowired
    private AssuntoRepository assuntoRepository;
    
    
    
    
    //CRUD - Service
    
    //Get
    public List <Assunto> findAll(){
        return assuntoRepository.findAll();
    }
   
    //GET{id}
    public Assunto findById (Long Id){
        return assuntoRepository.findById(Id).get();  
    // fazer o tratamento de exception
    }
    
    //POST
    public Assunto save (Assunto assunto){
        return assuntoRepository.save(assunto);
        
    }
    //DELETE
    public void delete (Long id){
       assuntoRepository.deleteById(id);
    } // fazer um tratamento de exception
    
    //PUT
    public Assunto update (Long id, Assunto assunto){
        Assunto assuntoEntity = assuntoRepository.getReferenceById(id);
        assuntoEntity.setDescricao(assunto.getDescricao());
        return assuntoRepository.save(assuntoEntity);
    }
    
    //ADD RELACIONAMENTOS
    /**
        //Assunto [+ comentario]
    public Assunto addComentario ( Long id_assunto, Long id_comentario){
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setAssunto(assunto);
        comentarioRepository.save(comentario);
        return assunto;
        
    }
       //Assunto [+ assunto]
    public Assunto addAssunto(Long id_assunto, Long id_assunto){
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        assunto.getAssuntos().add(assunto);
        assuntoRepository.save(assunto);
        return assunto;
    }
    
    //REMOVE RELACIONAMENTOS

        //Assunto [- comentario]
    public Assunto removeComentario(Long id_assunto, Long id_comentario){
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setAssunto(null);
        comentarioRepository.save(comentario);
        return assunto;
        
    }
          //Assunto [- assunto]
    public Assunto removeAssunto(Long id_assunto, Long id_assunto){
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        assunto.getAssuntos().remove(assunto);
        assuntoRepository.save(assunto);
        return assunto;
    
}*/

}