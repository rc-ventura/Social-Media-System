
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RC_Ventura
 */

@Repository
public interface ComentarioRepository  extends JpaRepository <Comentario, Long> {
    
}
