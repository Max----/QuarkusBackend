package org.acme.application.mapper;

import org.acme.application.entity.VisitEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.Visit;

@Mapper(componentModel = "cdi")
public interface VisitMapper {
    Visit toApi(VisitEntity customer);
    VisitEntity toEntity(Visit customer);
}

