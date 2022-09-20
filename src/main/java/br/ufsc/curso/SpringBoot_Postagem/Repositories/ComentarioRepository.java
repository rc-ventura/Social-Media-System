
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RC_Ventura
 */

public interface ComentarioRepository  extends JpaRepository <Comentario, Long> {
    
}
