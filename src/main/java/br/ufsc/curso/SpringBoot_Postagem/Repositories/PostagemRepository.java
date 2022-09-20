
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RC_Ventura
 */

public interface PostagemRepository  extends JpaRepository <Postagem, Long> {
    
}
