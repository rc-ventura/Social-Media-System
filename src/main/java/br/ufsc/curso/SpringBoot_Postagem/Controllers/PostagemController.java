/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.SpringBoot_Postagem.Controllers;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Services.PostagemService;
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
public class PostagemController {
    
   //dependency injection
    
    @Autowired
    private PostagemService postagemService;
    
    
    //endpoints   - CRUD -
    
    //GET
    @GetMapping(value = "/postagens")
    public ResponseEntity < List<Postagem> > findAll(){
        List<Postagem> postagens = postagemService.findAll();
        return ResponseEntity.ok().body(postagens);
    }
    
    //GET{id}
    
    @GetMapping(value = "/postagens/{id}")
    public ResponseEntity <Postagem> findById(@PathVariable Long id){
        Postagem postagem = postagemService.findById(id);
        return ResponseEntity.ok().body(postagem);
        
    }
    
    //POST
    
    @PostMapping(value = "/postagens")
    public ResponseEntity <Postagem> save (@RequestBody Postagem postagem){
       Postagem savedPostagem = postagemService.save(postagem);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("postagens/{id}").buildAndExpand(savedPostagem.getId()).toUri();
       return ResponseEntity.created(uri).body(savedPostagem);
    }
    
    
    //DELETE
    
    @DeleteMapping(value = "/postagens/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
       postagemService.delete(id);
       return ResponseEntity.noContent().build();    // Aqui eu nao poderia fazer uma mensagem personalizada ( DELETE OK) 
        
    }
    
    //UPDATE
    @PutMapping(value = "/postagens{id}")
    public ResponseEntity <Postagem> update (@PathVariable Long id, @RequestBody Postagem postagem){
        postagem = postagemService.update(id, postagem);
        return ResponseEntity.ok().body(postagem);
    }
    
    //ADD
    //Postagem [+ comentario]
    @PutMapping(value = "/postagens/{id_postagem}/addComentario/{id_comentario}")
    public ResponseEntity <Postagem> addComentario(@PathVariable Long id_postagem, @PathVariable Long id_comentario){
        Postagem postagem = postagemService.addComentario(id_postagem, id_comentario);
        return ResponseEntity.ok().body(postagem);
    }
    
    //ADD
    //Postagem [+ assunto]
    @PutMapping(value = "/postagens/{id_postagem}/addAssunto/{id_assunto}")
    public ResponseEntity <Postagem> addAssunto(@PathVariable Long id_postagem, @PathVariable Long id_assunto){
        Postagem postagem = postagemService.addAssunto(id_postagem, id_assunto);
        return ResponseEntity.ok().body(postagem);
    }
    
    
    //REMOVE
    //Postagem [- comentario]
    @DeleteMapping(value = "/postagens/{id_postagem}/removeComentario/{id_comentario}")
    public ResponseEntity <Postagem> removeComentario (@PathVariable Long id_postagem, @PathVariable Long id_comentario){
        Postagem postagem = postagemService.removeComentario(id_postagem, id_comentario);
        return ResponseEntity.ok().body(postagem);
    
    }
    
     //REMOVE
     //Postagem [- assunto]
    @DeleteMapping(value = "/postagens/{id_postagem}/removeAssunto/{id_Assunto}")
    public ResponseEntity <Postagem> removeAssunto (@PathVariable Long id_postagem, @PathVariable Long id_assunto){
        Postagem postagem = postagemService.removeAssunto(id_postagem, id_assunto);
        return ResponseEntity.ok().body(postagem);

}
    

}