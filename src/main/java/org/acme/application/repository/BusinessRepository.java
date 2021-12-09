package org.acme.application.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.application.entity.BusinessEntity;

public class BusinessRepository implements PanacheRepository<BusinessEntity> {
}
