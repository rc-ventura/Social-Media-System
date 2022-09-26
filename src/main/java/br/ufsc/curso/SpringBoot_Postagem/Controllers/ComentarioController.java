
package br.ufsc.curso.SpringBoot_Postagem.Controllers;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Comentario;
import br.ufsc.curso.SpringBoot_Postagem.Services.ComentarioService;
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
public class ComentarioController {
    
   //dependency injection
    
    @Autowired
    private ComentarioService comentarioService;
    
    
    //endpoints   - CRUD -
    
    //GET
    @GetMapping(value = "/comentarios")
    public ResponseEntity < List<Comentario> > findAll(){
        List<Comentario> comentarios = comentarioService.findAll();
        return ResponseEntity.ok().body(comentarios);
    }
    
    //GET{id}
    
    @GetMapping(value = "/comentarios/{id}")
    public ResponseEntity <Comentario> findById(@PathVariable Long id){
        Comentario comentario = comentarioService.findById(id);
        return ResponseEntity.ok().body(comentario);
        
    }
    
    //POST
    
    @PostMapping(value = "/comentarios")
    public ResponseEntity <Comentario> save (@RequestBody Comentario comentario){
       Comentario savedComentario = comentarioService.save(comentario);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("comentarios/{id}").buildAndExpand(savedComentario.getId()).toUri();
       return ResponseEntity.created(uri).body(savedComentario);
    }
    
    
    //DELETE
    
    @DeleteMapping(value = "/comentarios/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
       comentarioService.delete(id);
       return ResponseEntity.noContent().build();    // Aqui eu nao poderia fazer uma mensagem personalizada ( DELETE OK) 
        
    }
    
    //PUT
    @PutMapping(value = "/comentarios/{id}")
    public ResponseEntity <Comentario> update (@PathVariable Long id, @RequestBody Comentario comentario){
        comentario = comentarioService.update(id, comentario);
        return ResponseEntity.ok().body(comentario);
    }
   
    
 
}
 
