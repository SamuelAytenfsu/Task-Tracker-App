package com.example.demo;

import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="users_db") public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "username", nullable = false, length = 45)
    @NotEmpty
    private String username;

    @Column (name = "email", nullable = false, unique = true, length = 45)
    @NotEmpty
    private String email;

    @Column (name = "password", nullable = false, length = 60)
    @NotEmpty
    private String password;

    @Column (name = "first_name", nullable = false, length = 20)
    @NotEmpty
    private String firstName;

    @Column (name = "last_name", nullable = false, length = 20)
    @NotEmpty
    private String lastName;

    @Column (name = "enabled")
    private boolean enabled;

    @Column (name = "groupId")
    private int groupId;

    public User() {
    }
    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); this.password = passwordEncoder.encode(password);
    }
    public void clearPassword() {
         this.password = "";
    }

    public User(String username, String email, String password, String firstName, String lastName, boolean enabled, int groupId) {
        this.username = username;
        this.email = email;
        this.setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.groupId = groupId;
    }

    public int getGroupId(){
        return groupId;
    }

    public void setGroupId(int newId){
        groupId = newId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
