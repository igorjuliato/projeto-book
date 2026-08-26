package projeto01_ms.book_user.Application.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "Users")
//essa ultima anotação o implementes faz parte da auditora jpa, responsavel por gerenciar os registros de
//mudança de qualquer dado da aplicação
@EntityListeners(AuditingEntityListener.class)
@Data
public class User implements UserDetails {

    //A class não vai ter o construtor geral, pois vou tentar implementar o maps
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

     private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
     private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "roles", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Set<ROLE> roles = EnumSet.noneOf(ROLE.class);

    //auditora JPA configurações
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
