package ch.test.application.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Column;

public class Customer extends PanacheEntity {

    @Column(unique = true)
    public int id;

    public String firstName;
    public String lastName;
    public String email;

    // return name as uppercase in the model
    public String getFirstName(){ return this.firstName;}
    public String getLastName(){ return this.lastName;}
    public String getEmail(){ return this.email;}

    public void setFirstName(String newName){ this.firstName = newName;}
    public void setLastName(String newName){ this.lastName = newName;}
    public void setEmail(String newMail){ this.email = newMail;}

}
