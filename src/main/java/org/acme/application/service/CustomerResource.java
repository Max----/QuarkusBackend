package org.acme.application.service;

import org.acme.application.entity.CustomerEntity;
import org.acme.application.entity.LoyaltyEntity;
import org.acme.application.entity.VisitEntity;
import org.acme.application.mapper.CustomerMapper;
import org.acme.application.mapper.LoyaltyMapper;
import org.acme.application.mapper.VisitMapper;
import org.openapitools.api.CustomerApi;
import org.openapitools.model.Business;
import org.openapitools.model.Customer;
import org.openapitools.model.Loyalty;
import org.openapitools.model.Visit;


import javax.inject.Inject;
import javax.ws.rs.*;

@Path("customer/{id}")
public class CustomerResource implements CustomerApi {

    @Inject
    CustomerMapper customerMapper;
    @Inject
    VisitMapper visitMapper;
    @Inject
    LoyaltyMapper loyaltyMapper;

    @Override
    public Customer createCustomer() {
        CustomerEntity customer = new CustomerEntity();
        customer.persist();
        return customerMapper.toApi(customer);
    }

    @Override
    public Customer updateCustomerMetadatas(Integer id, Customer customer) {
        CustomerEntity entity = CustomerEntity.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setEmail(customer.getEmail());

        return customerMapper.toApi(entity);
    }

    @Override
    public Customer getCustomerMetadatas(Integer id) {
        return customerMapper.toApi(CustomerEntity.findById(id));
    }

    @Override
    public void deleteCustomer(Integer id) {
        CustomerEntity entity = CustomerEntity.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @Override
    public Loyalty getCustomerloyalty(Integer id, Business business) {
        return loyaltyMapper.toApi(LoyaltyEntity.findLoyalty(id, business.getBusinessId()));
    }

    @Override
    public Visit addVisit(Integer id, Business business) {
        CustomerEntity customer = CustomerEntity.findById(id);
        if(customer == null) {
            throw new NotFoundException();
        }
        VisitEntity newVisit = new VisitEntity(id, business.getBusinessId());
        newVisit.persist();
        return visitMapper.toApi(newVisit);
    }
}




