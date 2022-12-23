
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
    
    //PUT
    
    @PutMapping(value = "/assuntos/{id}")
    public ResponseEntity <Assunto> update (@PathVariable Long id, @RequestBody Assunto assunto){
        assunto = assuntoService.update(id, assunto);
        return ResponseEntity.ok().body(assunto);
    }
   

}