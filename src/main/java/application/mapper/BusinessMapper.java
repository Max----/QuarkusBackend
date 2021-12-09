package application.mapper;

import application.entity.BusinessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Business;

import javax.enterprise.context.ApplicationScoped;

/*@Mapper(componentModel = "cdi")
public interface BusinessMapper {
    @Mapping(source = "id", target = "customerId")
    Business toApi(BusinessEntity business);
    @Mapping(source = "customerId", target = "id")
    BusinessEntity toEntity(Business business);
}*/

public class BusinessMapper{
    public static Business toApi(BusinessEntity business){
        Business bus = new Business();
        bus.setBusinessId((int)business.getId());
        bus.setName(business.getName());
        bus.setEmail(business.getEmail());
        return bus;
    }
    public static BusinessEntity toEntity(Business business){
        BusinessEntity bus = new BusinessEntity();
        bus.setId((int)business.getBusinessId());
        bus.setName(business.getName());
        bus.setEmail(business.getEmail());
        return bus;
    }
}
