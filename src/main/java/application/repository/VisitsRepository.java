package application.repository;

import application.entity.VisitEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisitsRepository implements PanacheMongoRepository<VisitEntity> {
}
