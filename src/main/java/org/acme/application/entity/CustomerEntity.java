package org.acme.application.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Cacheable
@RegisterForReflection
public class CustomerEntity extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String email;

    public CustomerEntity(){}

    public CustomerEntity(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() { return this.id;}
    public String getFirstName(){ return this.firstName;}
    public String getLastName(){ return this.lastName;}
    public String getEmail(){ return this.email;}

    public void setFirstName(String newName){ this.firstName = newName;}
    public void setLastName(String newName){ this.lastName = newName;}
    public void setEmail(String newMail){ this.email = newMail;}

}
