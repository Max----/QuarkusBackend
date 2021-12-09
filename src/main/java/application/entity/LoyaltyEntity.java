package application.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="Loyalty")
public class LoyaltyEntity extends PanacheMongoEntity {

    public long customerId;
    public long businessId;
    public int loyaltyCounter;

    public LoyaltyEntity(){}

    public LoyaltyEntity(long customerId, long businessId){
        this.customerId = customerId;
        this.businessId = businessId;
        this.loyaltyCounter = 1;
    }

    public static LoyaltyEntity findLoyalty(int customerId, int businessId){
        return find("customerId='?1'AND businessId='?2'",customerId, businessId).firstResult();
    }

    public void incrementLoyalty(){
        this.loyaltyCounter++;
    }
    public void setLoyaltyCounter(int loyaltyCounter) {
        this.loyaltyCounter = loyaltyCounter;
    }
    public int getLoyaltyCounter(){
        return this.loyaltyCounter;
    }

    public long getCustomerId(){ return this.customerId; }
    public long getBusinessId(){ return this.businessId; }
    public void setCustomerId(long customerId){ this.customerId = customerId; }
    public void setBusinessId(long businessId){ this.businessId = businessId; }
}
