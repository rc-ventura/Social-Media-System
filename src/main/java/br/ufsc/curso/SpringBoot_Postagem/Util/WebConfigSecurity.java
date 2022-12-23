
package br.ufsc.curso.SpringBoot_Postagem.Util;

import br.ufsc.curso.SpringBoot_Postagem.Imp.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author RC_Ventura
 */
@Configuration 
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{            //Atualizar a implementacao com a classe nova WebSecurityConfiguration
    
    @Autowired
    private UsuarioServiceImp usuarioServiceImp;

    
    //configura as solicitações de acesso Http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        //Ativando a proteção contra usuários não validados por token
        
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        
        //Ativando a permissão para aceso a página inicial do sistema
        
        .disable().authorizeRequests().antMatchers("/").permitAll().and()
        .authorizeRequests().antMatchers("/index").permitAll()
                
        //URL de logout - Redoreciona após o usuário deslogar do sistema
                
         .anyRequest().authenticated().and().logout().logoutSuccessUrl("/index")
                
         //Mapeia a URL de logout e invalida o usuário
                
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                
         
        // Filtra requisições de login para autenticação
        
        
        // Filtra demais requisições ára verificar a presença do TOKEN JWT no HEAD HTTP
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth); 
        
        //Service que irá consultar usuário no banco de dados
        auth.userDetailsService(usuarioServiceImp).passwordEncoder(new BCryptPasswordEncoder());  //padrao de codificação de senha
        
    }

    
    
    
}
