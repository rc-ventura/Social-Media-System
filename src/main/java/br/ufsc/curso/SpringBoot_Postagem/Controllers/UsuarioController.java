
package br.ufsc.curso.SpringBoot_Postagem.Controllers;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import br.ufsc.curso.SpringBoot_Postagem.Services.UsuarioService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author RC_Ventura
 */
@RestController
public class UsuarioController {
    
   //dependency injection
    
    @Autowired
    private UsuarioService usuarioService;
    
    
    //endpoints   - CRUD -
    
    //GET
    @GetMapping(value = "/usuarios")
    public ResponseEntity < List<Usuario> > findAll(){
        List<Usuario> usuarioes = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioes);
    }
    
    //GET{id}
   /* @GetMapping(value = "/usuarios/{id}")
    public ResponseEntity <Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
        
    }
    */
    
    //GET{id}
    
    @GetMapping(value = "findId")
    @ResponseBody
    public ResponseEntity <Usuario> findById(@RequestParam(name= "id") Long id){
        Usuario usuario = usuarioService.findById(id);
        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
        
    }
     //GET {nome}- SQL 
    
     @GetMapping(value = "findName")
     @ResponseBody
    public ResponseEntity <List <Usuario>> findByNome(@RequestParam(name ="name") String nome){
        List <Usuario> usuarios = usuarioService.findByName(nome.trim().toUpperCase());  // retira os espaços e converte tudo em maiúsculas
        return new ResponseEntity <List<Usuario>>(usuarios, HttpStatus.OK );
    }
    
    //GET {login}- SQL
    
     @GetMapping(value = "/usuarios/findLogin/{login}")
    public ResponseEntity <List <Usuario>> findByLogin(@PathVariable String login){
        List <Usuario> usuarios = usuarioService.findByLogin(login.trim().toUpperCase());  // retira os espaços e converte tudo em maiúsculas
        return ResponseEntity.ok().body(usuarios);
    }
    
    
    //POST
    @PostMapping(value = "/usuarios")
    public ResponseEntity <Usuario> save (@RequestBody Usuario usuario){
       Usuario savedUsuario = usuarioService.save(usuario);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("usuarios/{id}").buildAndExpand(savedUsuario.getId()).toUri();
       return ResponseEntity.created(uri).body(savedUsuario);
    }
    
    
    //DELETE
    
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity <String> delete(@RequestParam Long id){
        usuarioService.delete(id);
        return new ResponseEntity <String>("Usuário deletado com sucesso",HttpStatus.OK);
    

   //@DeleteMapping(value = "/usuarios/{id}")
     //public ResponseEntity <Void> delete(@PathVariable Long id){
       // usuarioService.delete(id);
        //return ResponseEntity.noContent().build();    // Aqui eu nao poderia fazer uma mensagem personalizada ( DELETE OK) 
        
    }
    
    //PUT
    @PutMapping(value = "/usuarios/{id}")
    public ResponseEntity <Usuario> update (@PathVariable Long id, @RequestBody Usuario usuario){
        usuario = usuarioService.update(id, usuario);
        return ResponseEntity.ok().body(usuario);
    }
    
    
    //ADD
    //Usuario [+ postagem]
    @PutMapping(value = "/usuarios/{id_usuario}/addPostagem/{id_postagem}")
    public ResponseEntity <Usuario> addPostagem(@PathVariable Long id_usuario, @PathVariable Long id_postagem){
        Usuario usuario = usuarioService.addPostagem(id_usuario, id_postagem);
        return ResponseEntity.ok().body(usuario);
    }
   
    
     //REMOVE
     //Usuario [- postagem]
    @DeleteMapping(value = "/usuarios/{id_usuario}/removePostagem/{id_postagem}")
    public ResponseEntity <Usuario> removePostagem (@PathVariable Long id_usuario, @PathVariable Long id_postagem){
        Usuario usuario = usuarioService.removePostagem(id_usuario, id_postagem);
        return ResponseEntity.ok().body(usuario);

}
   

}