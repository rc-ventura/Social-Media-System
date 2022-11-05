
package br.ufsc.curso.SpringBoot_Postagem.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author RC_Ventura
 */
@Entity
public class Usuario implements Serializable {
        private static final long serialVersionUID = 1L;

        //atributos 
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;
        private String login;
        private String senha;
        
        //relacionamentos 
        
        @OneToMany(mappedBy = "usuario")
        private Set<Postagem> postagens = new HashSet<>();
    
      
        //construtores

    public Usuario(){}    
        
    public Usuario(Long id, String nome, String login, String senha) {
        this.id = id;      
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
        
      //metodos padroes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

  
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    
    public Set<Postagem> getPostagens() {
        return postagens;
    }
    
    // funcoes especificas
    
    public Double getTotalPostagens(){
        double num = postagens.size();
        return num;
    }
    
    
    //hash e equals 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }
     
    // funcoes 
    
  //  public Double getTotalPostagens(){}
    
    
}
