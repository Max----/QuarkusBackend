package ch.test.application.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Cacheable
@RegisterForReflection
public class Business extends PanacheEntity {

    @Column(unique = true)
    public int id;

    public String name;
    public String email;

    // return name as uppercase in the model
    public String getName(){ return this.name;}
    public String getEmail(){ return this.email;}

    public void setFirstName(String newName){ this.name = newName;}
    public void setEmail(String newMail){ this.email = newMail;}
}
