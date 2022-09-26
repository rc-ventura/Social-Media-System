
package br.ufsc.curso.SpringBoot_Postagem.Controllers;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Editor;
import br.ufsc.curso.SpringBoot_Postagem.Services.EditorService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author RC_Ventura
 */
@RestController
public class EditorController {
    
   //dependency injection
    
    @Autowired
    private EditorService editorService;
    
    
    //endpoints   - CRUD -
    
    //GET
    @GetMapping(value = "/editores")
    public ResponseEntity < List<Editor> > findAll(){
        List<Editor> editores = editorService.findAll();
        return ResponseEntity.ok().body(editores);
    }
    
    //GET{id}
    @GetMapping(value = "/editores/{id}")
    public ResponseEntity <Editor> findById(@PathVariable Long id){
        Editor editor = editorService.findById(id);
        return ResponseEntity.ok().body(editor);
        
    }
    
    //POST
    @PostMapping(value = "/editores")
    public ResponseEntity <Editor> save (@RequestBody Editor editor){
       Editor savedEditor = editorService.save(editor);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("editores/{id}").buildAndExpand(savedEditor.getId()).toUri();
       return ResponseEntity.created(uri).body(savedEditor);
    }
    
    
    //DELETE
    @DeleteMapping(value = "/editores/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
       editorService.delete(id);
       return ResponseEntity.noContent().build();    // Aqui eu nao poderia fazer uma mensagem personalizada ( DELETE OK) 
        
    }
    
    //UPDATE
    @PutMapping(value = "/editores{id}")
    public ResponseEntity <Editor> update (@PathVariable Long id, @RequestBody Editor editor){
        editor = editorService.update(id, editor);
        return ResponseEntity.ok().body(editor);
    }
    /*
    //ADD
    //Editor [+ comentario]
    @PutMapping(value = "/editores/{id_editor}/addComentario/{id_comentario}")
    public ResponseEntity <Editor> addComentario(@PathVariable Long id_editor, @PathVariable Long id_comentario){
        Editor editor = editorService.addComentario(id_editor, id_comentario);
        return ResponseEntity.ok().body(editor);
    }
    
    //ADD
    //Editor [+ assunto]
    @PutMapping(value = "/editores/{id_editor}/addAssunto/{id_assunto}")
    public ResponseEntity <Editor> addAssunto(@PathVariable Long id_editor, @PathVariable Long id_assunto){
        Editor editor = editorService.addAssunto(id_editor, id_assunto);
        return ResponseEntity.ok().body(editor);
    }
    
    
    //REMOVE
    //Editor [- comentario]
    @DeleteMapping(value = "/editores/{id_editor}/removeComentario/{id_comentario}")
    public ResponseEntity <Editor> removeComentario (@PathVariable Long id_editor, @PathVariable Long id_comentario){
        Editor editor = editorService.removeComentario(id_editor, id_comentario);
        return ResponseEntity.ok().body(editor);
    
    }
    
     //REMOVE
     //Editor [- assunto]
    @DeleteMapping(value = "/editores/{id_editor}/removeAssunto/{id_Assunto}")
    public ResponseEntity <Editor> removeAssunto (@PathVariable Long id_editor, @PathVariable Long id_assunto){
        Editor editor = editorService.removeAssunto(id_editor, id_assunto);
        return ResponseEntity.ok().body(editor);

}
    */

}