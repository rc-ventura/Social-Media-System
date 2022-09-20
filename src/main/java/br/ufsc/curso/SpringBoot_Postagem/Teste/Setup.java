
package br.ufsc.curso.SpringBoot_Postagem.Teste;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Assunto;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Comentario;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Editor;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.AssuntoRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.ComentarioRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.EditorRepository;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.PostagemRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author RC_Ventura
 */

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner{

    //dependency injection
    
    @Autowired
    private PostagemRepository postagemRepository;
    
    @Autowired
    private AssuntoRepository assuntoRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Autowired
    private EditorRepository editorRepository;

   
    @Override
    public void run(String...args) throws Exception{
       
    //adicionando postagem
    
       Postagem post1 = new Postagem(null,Instant.parse("2022-06-20T19:53:07Z"), "Minhas Ferias", "Texto1"); 
       Postagem post2 = new Postagem(null, Instant.parse("2022-07-20T19:53:07Z"), "Minhas Roupas", "Texto2"); 
       Postagem post3 = new Postagem(null, Instant.parse("2022-08-20T19:53:07Z"), "Minha Viagem", "Texto3"); 
       Postagem post4 = new Postagem(null, Instant.parse("2022-02-20T19:53:07Z"), "Take On Time", "Texto4"); 
       Postagem post5 = new Postagem(null, Instant.parse("2022-01-20T19:53:07Z"), "Peace", "Texto5"); 

        
       postagemRepository.saveAll(Arrays.asList(post1,post2,post3,post4,post5)); //salvando tudo
  
    //adicionando ceditor
    
       Editor ed1 = new Editor(null, "Rafael Ventura", "123mudar"); 
       Editor ed2 = new Editor(null, "Daniel Ventura", "123mudar"); 
       Editor ed3 = new Editor(null, "Laura Bender", "123mudar"); 
       
       
      editorRepository.saveAll(Arrays.asList(ed1,ed2,ed3)); //salvando tudo

    //associando editores com postagens
    
        post1.setEditor(ed1);
        post2.setEditor(ed1);
        post3.setEditor(ed3);
        post4.setEditor(ed3);
        post5.setEditor(ed2);
        
     postagemRepository.saveAll(Arrays.asList(post1,post2,post3,post4,post5)); //salvando tudo

      
        
    //adicionando assunto
    
       Assunto ass1 = new Assunto(null,"#trip"); 
       Assunto ass2 = new Assunto(null,"#vacation"); 
       Assunto ass3 = new Assunto(null,"#freedom"); 
       Assunto ass4 = new Assunto(null,"#healthy"); 
       Assunto ass5 = new Assunto(null,"#lifestyle"); 
       
       assuntoRepository.saveAll(Arrays.asList(ass1,ass2,ass3,ass4,ass5)); //salvando tudo

    
       
       //adicionando comentario
    
       Comentario com1 = new Comentario(null, "@rafael37", Instant.parse("2022-05-18T20:30:00Z"), "Top", post1); 
       Comentario com2 = new Comentario(null, "@laura24", Instant.parse("2022-05-19T20:30:00Z"), "Great", post2); 
       Comentario com3 = new Comentario(null, "@carlos12", Instant.parse("2022-05-21T20:30:00Z"), "Que legal", post1); 
       Comentario com4 = new Comentario(null, "@daniel35", Instant.parse("2022-05-25T20:30:00Z"), "Amazing", post3); 
       Comentario com5 = new Comentario(null, "@gui38", Instant.parse("2022-05-22T20:30:00Z"), "Parabens", post1); 
       
       
        comentarioRepository.saveAll(Arrays.asList(com1,com2,com3,com4,com5)); //salvando tudo

  
        
        //associando postagem com assunto
        
        
        post1.getAssuntos().add(ass1);
        post1.getAssuntos().add(ass2);
        post2.getAssuntos().add(ass5);
        post3.getAssuntos().add(ass1);
        post3.getAssuntos().add(ass2);
        post3.getAssuntos().add(ass3);
        post3.getAssuntos().add(ass2);
        post4.getAssuntos().add(ass3);
        post4.getAssuntos().add(ass4);
        post5.getAssuntos().add(ass3);
        post5.getAssuntos().add(ass4);
        post5.getAssuntos().add(ass5);


        postagemRepository.saveAll(Arrays.asList(post1,post2,post3,post4,post5)); //salvando tudo

        
    }
    
}
