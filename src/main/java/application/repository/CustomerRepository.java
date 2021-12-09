package application.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import application.entity.CustomerEntity;

public class CustomerRepository implements PanacheRepository<CustomerEntity> {
}
