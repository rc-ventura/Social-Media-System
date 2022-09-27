
package br.ufsc.curso.SpringBoot_Postagem.Controllers.Exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author RC_Ventura
 */

@ControllerAdvice 
public class ResourceExceptionHandler {
    
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFound(EntityNotFoundException ex ) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( ex.getMessage()); //criando uma classe log posso colocar timestamp
    }
    
    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<String> emptyResultDataAccess(EmptyResultDataAccessException ex ) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "acesso aos dados de resultado vazio\n" + ex.getMessage());
    }

    // excecoes oneToMany
    // remover um editor com postagem associadas
     // remover umas postagem com comentarios associados 
    
     @ExceptionHandler(value = DataIntegrityViolationException.class)
     public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException ex ) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "não fui possível executar a instrução\n\n" + ex.getMessage());
    
}   

}

