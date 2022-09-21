
package br.ufsc.curso.SpringBoot_Postagem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author RC_Ventura
 */
@Entity
public class Assunto implements Serializable {
     private static final long serialVersionUID = 1L;

     //atributos
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String descricao;
     
     //relacionamento
     @JsonIgnore
     @ManyToMany(mappedBy = "assuntos")
     private Set<Postagem> postagens = new HashSet<>();


    //construtores
     
    
    public Assunto(){};
    

    public Assunto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    //metodos padroes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Set<Postagem> getPostagens() {
        return postagens;
    }
    
    
    
    //hash e equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Assunto other = (Assunto) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
    
    
    
     
    
     
    
}