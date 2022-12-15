package com.ministry.fullness.bodyChrist.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String coverPicture ;
    private String email;
    private int code;
    private String pays;
    private String position="premiun";
    private Boolean access=true ;
    private int telephone;
    private String password="1234567890";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCoverPicture() {
        return coverPicture;
    }
    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public Boolean getAccess() {
        return access;
    }
    public void setAccess(Boolean access) {
        this.access = access;
    }

}
