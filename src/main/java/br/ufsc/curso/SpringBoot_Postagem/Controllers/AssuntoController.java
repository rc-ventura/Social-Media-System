
package br.ufsc.curso.SpringBoot_Postagem.Controllers;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Assunto;
import br.ufsc.curso.SpringBoot_Postagem.Services.AssuntoService;
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
public class AssuntoController {
    
   //dependency injection
    
    @Autowired
    private AssuntoService assuntoService;
    
    
    //endpoints   - CRUD -
    
    //GET
    @GetMapping(value = "/assuntos")
    public ResponseEntity < List<Assunto> > findAll(){
        List<Assunto> assuntos = assuntoService.findAll();
        return ResponseEntity.ok().body(assuntos);
    }
    
    //GET{id}
    
    @GetMapping(value = "/assuntos/{id}")
    public ResponseEntity <Assunto> findById(@PathVariable Long id){
        Assunto assunto = assuntoService.findById(id);
        return ResponseEntity.ok().body(assunto);
        
    }
    
    //POST
    
    @PostMapping(value = "/assuntos")
    public ResponseEntity <Assunto> save (@RequestBody Assunto assunto){
       Assunto savedAssunto = assuntoService.save(assunto);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("assuntos/{id}").buildAndExpand(savedAssunto.getId()).toUri();
       return ResponseEntity.created(uri).body(savedAssunto);
    }
    
    
    //DELETE
    
    @DeleteMapping(value = "/assuntos/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
       assuntoService.delete(id);
       return ResponseEntity.noContent().build();    // Aqui eu nao poderia fazer uma mensagem personalizada ( DELETE OK) 
        
    }
    
    //UPDATE
    
    @PutMapping(value = "/assuntos{id}")
    public ResponseEntity <Assunto> update (@PathVariable Long id, @RequestBody Assunto assunto){
        assunto = assuntoService.update(id, assunto);
        return ResponseEntity.ok().body(assunto);
    }
    /*
    //ADD
    //Assunto [+ comentario]
    @PutMapping(value = "/assuntos/{id_assunto}/addComentario/{id_comentario}")
    public ResponseEntity <Assunto> addComentario(@PathVariable Long id_assunto, @PathVariable Long id_comentario){
        Assunto assunto = assuntoService.addComentario(id_assunto, id_comentario);
        return ResponseEntity.ok().body(assunto);
    }
    
    //ADD
    //Assunto [+ assunto]
    @PutMapping(value = "/assuntos/{id_assunto}/addAssunto/{id_assunto}")
    public ResponseEntity <Assunto> addAssunto(@PathVariable Long id_assunto, @PathVariable Long id_assunto){
        Assunto assunto = assuntoService.addAssunto(id_assunto, id_assunto);
        return ResponseEntity.ok().body(assunto);
    }
    
    
    //REMOVE
    //Assunto [- comentario]
    @DeleteMapping(value = "/assuntos/{id_assunto}/removeComentario/{id_comentario}")
    public ResponseEntity <Assunto> removeComentario (@PathVariable Long id_assunto, @PathVariable Long id_comentario){
        Assunto assunto = assuntoService.removeComentario(id_assunto, id_comentario);
        return ResponseEntity.ok().body(assunto);
    
    }
    
     //REMOVE
     //Assunto [- assunto]
    @DeleteMapping(value = "/assuntos/{id_assunto}/removeAssunto/{id_Assunto}")
    public ResponseEntity <Assunto> removeAssunto (@PathVariable Long id_assunto, @PathVariable Long id_assunto){
        Assunto assunto = assuntoService.removeAssunto(id_assunto, id_assunto);
        return ResponseEntity.ok().body(assunto);

}
    */

}