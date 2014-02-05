package fr.plil.sio.jpa;

import javax.persistence.*;

@Entity
@Table(name = "USER_T")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ANIMAL_ID")
    private long id;
    
    @Column(name = "NAME_C", unique = true, nullable = false)
    private String username;
    
    @Column(name = "PWD_C", unique = true, nullable = false)
    private String password;
    
    @Column(name = "TYPE_C", unique = true, nullable = false)
    private Enum type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return !((this.username == null) ? (other.username != null) : !this.username.equals(other.username));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }
}
