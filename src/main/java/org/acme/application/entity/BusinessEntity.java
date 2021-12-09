package org.acme.application.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Cacheable
@RegisterForReflection
public class BusinessEntity extends PanacheEntity {

    private String name;
    private String email;

    public BusinessEntity(){}

    public BusinessEntity(String name, String email){
        this.name = name;
        this.email = email;
    }

    // return name as uppercase in the model
    public String getName(){ return this.name;}
    public String getEmail(){ return this.email;}

    public void setName(String newName){ this.name = newName;}
    public void setEmail(String newMail){ this.email = newMail;}
}
