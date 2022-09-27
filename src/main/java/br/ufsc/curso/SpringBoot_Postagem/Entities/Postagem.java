
package br.ufsc.curso.SpringBoot_Postagem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author RC_Ventura   
 * 
 */
@Entity
public class Postagem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //atributos
    
    @Id  // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //autogerador de id
    private Long id; 
    
    
    private Instant data;
    private String titulo;
    private String texto;
    
    //relacionamento
    
    @ManyToMany
    @JoinTable(name = "postagem_assunto", joinColumns = @JoinColumn(name = "id_postagem"), 
            inverseJoinColumns  = @JoinColumn(name = "id_assunto"))
      
    private Set<Assunto> assuntos = new HashSet<>();
    
    // Tabela intermediaria  postagem_assunto 
   // ( uma postagem tem varios assuntos)
    // ( Um assunto tem varias postagens)
    
    @OneToMany(mappedBy = "postagem")
    private Set<Comentario> comentarios = new HashSet<>();    // uma postagem tem varios comentarios

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "id_editor")
   private Editor editor;
    
    
    //construtores

    
    public Postagem (){}
    
    
    public Postagem(Long id, Instant data, String titulo, String texto) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.texto = texto;
        this.editor = editor;
    }

    
    
    //metodos padroes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Set<Assunto> getAssuntos() {
        return assuntos;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }
    
  // funcoes especificas
    
    public Double getTotalPalavras(){
        String texto = this.texto;
        String[] words = texto.split("\\s+");   //funcao split - quebra a string pelos espaços em brancos
        double num = words.length;             // armazena em um array e faz a contagem pelo tamanh odo array
        return num;
    }
        
    
    // hash e equals

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Postagem other = (Postagem) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    // funcoes
    
    //public Double getTotalPalavras()
    
    
}
