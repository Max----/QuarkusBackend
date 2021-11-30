package org.acme.hibernate.orm.panache;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

@Entity
@Cacheable
@RegisterForReflection
public class Fruit extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String name;

}