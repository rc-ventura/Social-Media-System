
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RC_Ventura
 */
@Repository
public interface UsuarioRepository  extends JpaRepository <Usuario, Long> {
    
   @Query(value = "select u from Usuario u where upper(trim(u.nome)) "
            + "like %?1%")
        List<Usuario> findByName(String nome); 
       
      /*  @Query(value = "SELECT * FROM Usuario  WHERE upper(trim(usuario.nome)) "
            + "LIKE %?1%", nativeQuery = true)
        List<Usuario> findByName(String nome); 
     */
//JQPL
        
    @Query(value = "SELECT * FROM Usuario  WHERE upper(trim(usuario.login)) "
            + "LIKE %?1%", nativeQuery = true)
        List<Usuario> findByLogin(String login);  
    
   
}



    

//Acima declarei duas bucas distintas mas eu poderia reagrupar em apenas uma busca 

/*SELECT * FROM USUARIO WHERE
USUARIO.NOME LIKE '%?1%' OR 
USUARIO.LOGIN LIKE '%?2%'

(String nome, String login)
*/