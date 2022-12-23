
package br.ufsc.curso.SpringBoot_Postagem.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author RC_Ventura
 */
@Entity
@Table (name = "role")   // Coluna 
@SequenceGenerator (name = "seq_role", sequenceName = "seq_role",allocationSize = 1,initialValue = 1)  //Criando uma sequencia que começa com 1 e vai de 1 a 1
public class Role implements GrantedAuthority  {  //classe do spring security
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")  
    private Long id;
    
    private String nomeRole;  //Qual o papel do meu usuario - Controle de acesso - IAM

    
    // metodo static da class
    
    @Override
    public String getAuthority() {
       return this.nomeRole; // retorna o nome do role - autorizacao
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }
    
    
    
}
