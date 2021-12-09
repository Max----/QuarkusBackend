package org.acme.application.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.application.entity.VisitEntity;

public class VisitsRepository implements PanacheRepository<VisitEntity> {
}
