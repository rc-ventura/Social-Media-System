
package br.ufsc.curso.SpringBoot_Postagem.Entities;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author RC_Ventura
 */
@Entity
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private Instant data;
    private String text;
    
    //relacionamentos
    
    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;
            
    //construtores

    public Comentario(){}
    
    public Comentario(Long id, String nome, Instant data, String text, Postagem postagem) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.text = text;
        this.postagem = postagem;
    }
    
    
    

    //metodos padroes

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
    
    
    
    // hash e equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Comentario other = (Comentario) obj;
        return this.id == other.id;
    }
    
    

    
}
