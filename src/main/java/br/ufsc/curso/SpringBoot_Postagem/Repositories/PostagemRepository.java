
package br.ufsc.curso.SpringBoot_Postagem.Repositories;

import br.ufsc.curso.SpringBoot_Postagem.Entities.Postagem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RC_Ventura
 */

@Repository
public interface PostagemRepository  extends JpaRepository <Postagem, Long> {
    
// Consulta SQL - Por Titulo da Postagem
        
        @Query(value = "SELECT * FROM Postagem  WHERE upper(trim(postagem.titulo)) LIKE %?1%", nativeQuery = true)
        List<Postagem> findByTitle(String titulo);   // () trim retira os espaços da consulta 
                                                       // converte tudo para maiúsculas
    
        
//Consulta SQL por Data da postagem (intervalo de datas)
    
    

//Consulta SQL por Editor da Postagem

    
}

    //nome do método deve conter o atributo da classe

   // public Usuario findByLogin(String login);

    

//palavra-chave da consulta: Between

   // public List<Usuario> findByIdadeBetween(int startAge, int endAge);

   

    //consulta por namedQuery

   // public List<Usuario> findByDtCadastro(Date dtCadastro);



    //consulta por named parameters

   // @Query("from Usuario where login = :login and senha = :senha")
  //  public Usuario findByLoginAndSenha(@Param("login")String login,
  //  @Param("senha") String senha);



    //consulta com ordinal parameters
    
   // @Query("from Usuario where login = ?3 and senha = ?2 and idade = ?1")
   // public Usuario findByLoginAndSenhaAndIdade
  //  (int idade, String senha, String login);
