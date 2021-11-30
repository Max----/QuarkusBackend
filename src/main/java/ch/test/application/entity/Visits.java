package ch.test.application.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import java.time.LocalDateTime;

public class Visits extends PanacheEntity {

    public int customerId;
    public int businessId;
    public LocalDateTime visit;

}
