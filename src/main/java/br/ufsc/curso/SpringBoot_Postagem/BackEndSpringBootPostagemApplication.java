package br.ufsc.curso.SpringBoot_Postagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackEndSpringBootPostagemApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BackEndSpringBootPostagemApplication.class, args);
	}
        
        // Criando um bloqueio para método DELETE
        public void addCorsMappings(CorsRegistry registry) {                    //esta classe implementa algumas configurações globais CORS
            
            registry.addMapping("/usuarios/**").    // todos os endpoints que comecem com usuarios (** - Todos)
                    allowedMethods("GET", "POST", "PUT");  //   métodos permitidos
        }

}
