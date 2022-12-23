
package br.ufsc.curso.SpringBoot_Postagem.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author RC_Ventura
 */
@Entity
public class Usuario implements UserDetails {                                    // implementacao para usar metodos do Spring Security - Também implementa serializable
        private static final long serialVersionUID = 1L;

        //atributos 
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;
        private String login;
        private String senha;
        
        //relacionamentos 
        
        @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Postagem> postagens = new HashSet<>();    //remove em cascata tudo e  remove os relacionamentos sem associações
    
      
        @OneToMany (fetch = FetchType.EAGER)
        @JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(name = "unique_role_user", columnNames =  {"usuario_id", "role_id"} ), //Criando uma tabela usuarios_role com FK usuario_id
            joinColumns = @JoinColumn(name = "usuario_id", unique = false),                                 // + FK role_id  = Composite Key
            inverseJoinColumns = @JoinColumn(name = "role_id", unique = false, updatable = false ) )          // UniqueConstraint garate que cada linha será única  ( add constraint on the table or on the column (unique = true)
         private Set<Role> roles;                                                                            //lista de papeis para acessos
                                                                                                               // unique = false -> Podemos repetir o usuário mas com roles diferentes
        
                                                                                                               // updatetable -> não atualiza o table. Os acessos não podem ser atualizados.
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
    
  // Spring Security
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}
