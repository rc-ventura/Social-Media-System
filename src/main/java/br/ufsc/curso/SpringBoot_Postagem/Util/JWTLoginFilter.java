
package br.ufsc.curso.SpringBoot_Postagem.Util;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import br.ufsc.curso.SpringBoot_Postagem.Services.JWTTokenAutenticacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author RC_Ventura
 */

//establece um gerenciador de token
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    
    //configurando o gerenciador de autenticação
    protected JWTLoginFilter(String url, AuthenticationManager authenticationManager){
           
            //obriga a autenticar a url chamando o construtor da classe
            super (new AntPathRequestMatcher(url));
            
            //Gerenciador de autenticação
            setAuthenticationManager(authenticationManager);
            
    }
    // retorna o usuário ao processar a autenticação
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
            throws AuthenticationException, IOException, ServletException {
        
        //Pega o token para validar - Processamento de dados
        Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
        
        //Retona o usuario, login, senha e roles
        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, 
            HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult); 
        
        try {
            new JWTTokenAutenticacaoService().addAutentication(response, authResult.getName());
        } catch (Exception ex) {
            Logger.getLogger(JWTLoginFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}

}