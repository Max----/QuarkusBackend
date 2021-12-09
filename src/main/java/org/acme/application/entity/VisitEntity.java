package org.acme.application.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Cacheable
@RegisterForReflection
public class VisitEntity extends PanacheEntity {

    public long customerId;
    public long businessId;
    public LocalDateTime dateTime;

    public VisitEntity(){}

    public VisitEntity(long customerId, long businessId){
        this.customerId = customerId;
        this.businessId = businessId;
        this.dateTime = LocalDateTime.now();
    }

}
