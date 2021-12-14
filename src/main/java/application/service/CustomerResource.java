package application.service;

import application.entity.BusinessEntity;
import application.entity.CustomerEntity;
import application.entity.LoyaltyEntity;
import application.entity.VisitEntity;
import application.mapper.CustomerMapper;
import application.mapper.LoyaltyMapper;
import application.mapper.VisitMapper;
import org.openapitools.api.CustomerApi;
import org.openapitools.model.Business;
import org.openapitools.model.Customer;
import org.openapitools.model.Loyalty;
import org.openapitools.model.Visit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("customer")
@ApplicationScoped
public class CustomerResource implements CustomerApi {

    @GET
    @Path("/all")
    @Produces({ "application/json" })
    public List<Customer> allCustomer(){
        List<Customer> customers = new ArrayList<>();
        customers = CustomerEntity.findAll().stream().map(cus -> CustomerMapper.toApi((CustomerEntity) cus)).collect(Collectors.toList());
        return customers;
    }

    @Transactional
    @Override
    public Customer createCustomer() {
        CustomerEntity customer = new CustomerEntity();
        customer.persist();
        return CustomerMapper.toApi(customer);
    }

    @Override
    public Customer getCustomerMetadatas(Integer id) {
        CustomerEntity c = CustomerEntity.findById((long)id);
        if (c == null) {
            throw new NotFoundException();
        }
        return CustomerMapper.toApi(c);
    }

    @Transactional
    @Override
    public Customer updateCustomerMetadatas(Integer id, Customer customer) {
        CustomerEntity entity = CustomerEntity.findById((long)id);
        if (entity == null) {
            throw new NotFoundException();
        }

        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setEmail(customer.getEmail());
        return CustomerMapper.toApi(entity);
    }

    @Override
    public void deleteCustomer(Integer id) {
        CustomerEntity entity = CustomerEntity.findById((long)id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @Override
    public Loyalty getCustomerloyalty(Integer id, Integer businessId) {
        LoyaltyEntity loyaltyEntity = LoyaltyEntity.findLoyalty(id, businessId);
        if (loyaltyEntity == null) {
            throw new NotFoundException();
        }

        return LoyaltyMapper.toApi(loyaltyEntity);
    }

    @Transactional
    @Override
    public Visit addVisit(Integer id, Integer businessId) {
        CustomerEntity customerEntity = CustomerEntity.findById((long)id);
        if (customerEntity == null) {
            throw new NotFoundException();
        }
        BusinessEntity businessEntity = BusinessEntity.findById((long)businessId);
        if (businessEntity == null) {
            throw new NotFoundException();
        }
        VisitEntity newVisit = new VisitEntity(id, businessId);
        newVisit.persist();

        LoyaltyEntity loyaltyEntity = LoyaltyEntity.findLoyalty(id, businessId);
        if (loyaltyEntity == null) {
            LoyaltyEntity newLoyaltyEntity = new LoyaltyEntity(id, businessId);
            newLoyaltyEntity.persist();
        }else{
            loyaltyEntity.incrementLoyalty();
            loyaltyEntity.persist();
        }
        return VisitMapper.toApi(newVisit);
    }

    private void incrementLoyalty(Integer id, Integer businessId){
        LoyaltyEntity loyaltyEntity = LoyaltyEntity.findLoyalty(id, businessId);
        if (loyaltyEntity == null) {
            LoyaltyEntity newLoyaltyEntity = new LoyaltyEntity(id, businessId);
            newLoyaltyEntity.persist();
        }else{
            loyaltyEntity.incrementLoyalty();
            loyaltyEntity.persist();
        }
    }
}




