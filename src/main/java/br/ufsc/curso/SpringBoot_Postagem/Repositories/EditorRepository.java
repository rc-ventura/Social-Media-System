
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RC_Ventura
 */

public interface EditorRepository  extends JpaRepository <Editor, Long> {
    
}
