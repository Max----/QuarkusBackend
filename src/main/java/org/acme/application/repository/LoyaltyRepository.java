package org.acme.application.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.application.entity.LoyaltyEntity;

public class LoyaltyRepository implements PanacheRepository<LoyaltyEntity> {
}
