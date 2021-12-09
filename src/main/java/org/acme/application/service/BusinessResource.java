package org.acme.application.service;



import org.acme.application.entity.BusinessEntity;
import org.acme.application.mapper.BusinessMapper;
import org.openapitools.api.BusinessApi;
import org.openapitools.model.Business;


import javax.inject.Inject;
import javax.ws.rs.*;


@Path("business/{id}")
public class BusinessResource implements BusinessApi {

    @Inject
    BusinessMapper businessMapper;

    @Override
    public Business getBusinessMetadatas(Integer id) {
        return businessMapper.toApi(BusinessEntity.findById(id));
    }

    @Override
    public Business createBusiness() {
        BusinessEntity business = new BusinessEntity();
        business.persist();
        return businessMapper.toApi(business);
    }

    @Override
    public Business updateBusinessMetadatas(Integer id, Business business) {
        BusinessEntity entity = BusinessEntity.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        entity.setName(business.getName());
        entity.setEmail(business.getEmail());

        return businessMapper.toApi(entity);
    }

    @Override
    public void deleteBusiness(Integer id) {
        BusinessEntity entity = BusinessEntity.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }


    /*
    @Override
    Uni<Business> getBusinessMetadatas(@javax.ws.rs.PathParam("id") Integer id){
        return null ;
        //Business.findById(id);
    }

    @Override
    public void updateBusinessMetadatas(Integer id, org.openapitools.model.Business business) {
        // Panache.<Business>withTransaction(business::persist).onItem().transform(inserted -> Response.created(URI.create("/business/" + inserted.id)).build());
    }

    @DELETE
    void deleteBusiness(@javax.ws.rs.PathParam("id") Integer id){
        //Business.deleteById(id);
    }*/
}
