package application.mapper;

import application.entity.BusinessEntity;
import application.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Business;
import org.openapitools.model.Customer;

import javax.enterprise.context.ApplicationScoped;

/*@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    @Mapping(source = "id", target = "customerId")
    Customer toApi(CustomerEntity customer);
    @Mapping(source = "customerId", target = "id")
    CustomerEntity toEntity(Customer customer);
}*/

public class CustomerMapper{
    public static Customer toApi(CustomerEntity customer){
        Customer cus = new Customer();
        cus.setCustomerId((int)customer.getId());
        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setEmail(customer.getEmail());
        return cus;
    }
    public static CustomerEntity toEntity(Customer customer){
        CustomerEntity cus = new CustomerEntity();
        cus.setId((int)customer.getCustomerId());
        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setEmail(customer.getEmail());
        return cus;
    }
}
