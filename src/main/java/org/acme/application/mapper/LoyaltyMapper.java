package org.acme.application.mapper;

import org.acme.application.entity.LoyaltyEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.Loyalty;

@Mapper(componentModel = "cdi")
public interface LoyaltyMapper {
    Loyalty toApi(LoyaltyEntity customer);
    LoyaltyEntity toEntity(Loyalty customer);
}
