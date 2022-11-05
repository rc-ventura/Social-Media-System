
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RC_Ventura
 */
@Repository
public interface UsuarioRepository  extends JpaRepository <Usuario, Long> {
    
}
