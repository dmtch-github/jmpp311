package jm.spring.boot.crud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name="users311")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email")
    @NotBlank(message = "(обязательный параметр)")
    private String email;   //уникальное значение

    @Column(name="name")
    @NotBlank(message = "(обязательный параметр)")
    @Size(min = 4, message = "(минимум 4 символа)")
    private String name;

    @Column(name="last_name")
    @NotBlank(message = "(обязательный параметр)")
    @Size(min = 4, message = "(минимум 4 символа)")
    private String lastName;

    
    @Column(name="age")
    @Min(value=)
    private byte age;

    @Column(name="password")
    @Size(min = 4, message = "(минимум 4 символа)")
    private String password;

    @Transient
    private String textRoles;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "users311_roles311",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(int id, String email, String name, String lastName, byte age, String password, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    /**
     * Преобразует названия ролей в строку
     * для отображения на сайте
     */
    public void rolesToText() {
        textRoles = roles.stream()
                .map(Role::getName)
                .map(x -> x.replace(Roles.ROLE_PREFIX,""))
                .sorted()
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", textRoles='" + textRoles + '\'' +
                ", roles=" + roles +
                '}';
    }
}
