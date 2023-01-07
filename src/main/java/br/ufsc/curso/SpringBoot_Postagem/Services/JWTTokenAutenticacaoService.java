package br.ufsc.curso.SpringBoot_Postagem.Services;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import br.ufsc.curso.SpringBoot_Postagem.Repositories.UsuarioRepository;
import br.ufsc.curso.SpringBoot_Postagem.Util.ApplicationContextLoad;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Component
@Service
public class JWTTokenAutenticacaoService {

    // @Autowired
    // private UsuarioRepository usarioRepository;                                   //Necessitamos de uma injeção desta classe, no entanto podemois criar uma alternativa
    // podemios criar uma classe auxiliar que carrega todos os beans da memória
    //Tempo de validade do tokem em milisegundos = 2 dias
    private static final long EXPIRATION_TIME = 172800000;

    //Uma senha unica para compor a autenticacao
    private static final String SECRET = "mudar1234!";

    //Prefixo padrao de token
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    //Geranado um token de autenticaco e adicionando ao cabeçalho e resposta http
    public void addAutentication(HttpServletResponse response, String login) throws Exception {

        //Montagem do Token
        String JWT = Jwts.builder() //chama o gerador de token
                .setSubject(login) //add o usuário que está tentando a autenticacao
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //tempo de expiracao
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();   //Compactacao e algoritmo de geracao de senhas

        //junta token com o prefixo
        String token = TOKEN_PREFIX + "" + JWT;  // Bearer  (token) 

        //adicionaq no cabeçalho http
        response.addHeader(HEADER_STRING, token);  //Authorization : Bearer (token) + SECRET

        //Escreve token como resposta no corpo
        response.getWriter().write("{\"Authorization\" :  \" " + token + "\"}");
    }

    //Retorna o usuario validado com token ou caso não retorna null (não autorizado)
    public Authentication getAuthentication(HttpServletRequest request) {

        //Pega o token enviado no cabeçalho (HEADER) http
        String token = request.getHeader(HEADER_STRING);  //pega a requisição do cabeçalho

        if (token != null) {

            //faz a validacao do token do usuario na requisicao
            String user = Jwts.parser().setSigningKey(SECRET) //Bearer + token +SECRET  ( Parse -descompactação)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")) // Bearer sai = fica apenas o token (subsitui prefixo por uma string vazia) 
                    .getBody().getSubject();  // retorna no corpo o user  =  ex: Rafael

            if (user != null) {

                Usuario usuario = (Usuario) ApplicationContextLoad.getApplicationContext(). // Essa classe respresenta todas as classes criadas e armazenadas na memória (bean)
                        getBean(UsuarioRepository.class).findByLogin(user);           // aqui carregamos a classe UsuarioRepository e chamamos o método de busca por login.  

                //retorna o usuário logado
                if (usuario != null) {

                    return new UsernamePasswordAuthenticationToken(usuario.getLogin(),
                            usuario.getPassword(),
                            usuario.getAuthorities());

                }

            }
        }
        return null; //nao autorizado

    }

}
