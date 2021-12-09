package org.acme.application.mapper;

import org.acme.application.entity.BusinessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Business;

@Mapper(componentModel = "cdi")
public interface BusinessMapper {
    @Mapping(source = "id", target = "customerId")
    Business toApi(BusinessEntity customer);
    @Mapping(source = "customerId", target = "id")
    BusinessEntity toEntity(Business customer);
}
