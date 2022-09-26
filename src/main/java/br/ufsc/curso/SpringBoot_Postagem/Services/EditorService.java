
package br.ufsc.curso.SpringBoot_Postagem.Services;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Editor;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.EditorRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.PostagemRepository;
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
    private PostagemRepository postagemRepository;
    
    
    
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
    
    //ADD RELACIONAMENTOS
    
        //Editor [+ postagem]
    public Editor addPostagem( Long id_editor, Long id_postagem){
        Editor editor = editorRepository.findById(id_editor).get();
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        
       
        postagem.setEditor(editor);
        postagemRepository.save(postagem);
        return editor;
        
    }
       
    
    //REMOVE RELACIONAMENTOS

        //Editor [- postagem]
    public Editor removePostagem(Long id_editor, Long id_postagem){
        Editor editor = editorRepository.findById(id_editor).get();
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        
        postagem.setEditor(null);
        postagemRepository.save(postagem);
        return editor;
        
    }

}