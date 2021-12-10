package application.repository;

import application.entity.VisitEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisitsRepository implements PanacheRepository<VisitEntity> {
}
