
package br.ufsc.curso.SpringBoot_Postagem.Services;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Editor;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.AssuntoRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.ComentarioRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.EditorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class EditorService {
    
    
    @Autowired
    private EditorRepository editorRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Autowired
    private AssuntoRepository assuntoRepository;
    
    
    
    //CRUD - Service
    
    //Get
    public List <Editor> findAll(){
        return editorRepository.findAll();
    }
   
    //GET{id}
    public Editor findById (Long Id){
        return editorRepository.findById(Id).get();  
    // fazer o tratamento de exception
    }
    
    //POST
    public Editor save (Editor editor){
        return editorRepository.save(editor);
        
    }
    //DELETE
    public void delete (Long id){
       editorRepository.deleteById(id);
    } // fazer um tratamento de exception
    
    //PUT
    public Editor update (Long id, Editor editor){
        Editor editorEntity = editorRepository.getReferenceById(id);
        editorEntity.setNome(editor.getNome());
        editorEntity.setSenha(editor.getSenha());
        return editorRepository.save(editorEntity);
    }
    /*
    //ADD RELACIONAMENTOS
    
        //Editor [+ comentario]
    public Editor addComentario ( Long id_editor, Long id_comentario){
        Editor editor = editorRepository.findById(id_editor).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setEditor(editor);
        comentarioRepository.save(comentario);
        return editor;
        
    }
       //Editor [+ assunto]
    public Editor addAssunto(Long id_editor, Long id_assunto){
        Editor editor = editorRepository.findById(id_editor).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        editor.getAssuntos().add(assunto);
        editorRepository.save(editor);
        return editor;
    }
    
    //REMOVE RELACIONAMENTOS

        //Editor [- comentario]
    public Editor removeComentario(Long id_editor, Long id_comentario){
        Editor editor = editorRepository.findById(id_editor).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        
        comentario.setEditor(null);
        comentarioRepository.save(comentario);
        return editor;
        
    }
          //Editor [- assunto]
    public Editor removeAssunto(Long id_editor, Long id_assunto){
        Editor editor = editorRepository.findById(id_editor).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        
        editor.getAssuntos().remove(assunto);
        editorRepository.save(editor);
        return editor;
    
}*/

}