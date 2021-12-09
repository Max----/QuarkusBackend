package application.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import application.entity.BusinessEntity;

public class BusinessRepository implements PanacheRepository<BusinessEntity> {
}
