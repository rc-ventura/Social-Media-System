
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RC_Ventura
 */

public interface AssuntoRepository  extends JpaRepository <Assunto, Long> {
    
}
