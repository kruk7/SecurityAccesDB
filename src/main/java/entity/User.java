package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User
{
    @Id
    private String username;
    private String password;
    @ElementCollection
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    public User() { }

    public User(String username, String password, String role)
    {
        this.username = username;
        this.password = password;
        this.roles.add(role);
    }

    //Getters & Setters
    public String getUsername()
    { return username; }

    public void setUsername(String username)
    { this.username = username; }

    public String getPassword()
    { return password; }

    public void setPassword(String password)
    { this.password = password; }

    public Set<String> getRoles()
    { return roles; }

    public void setRoles(Set<String> roles)
    { this.roles = roles; }
}
