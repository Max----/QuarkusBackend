package org.acme.application.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.application.entity.CustomerEntity;

public class CustomerRepository implements PanacheRepository<CustomerEntity> {
}
