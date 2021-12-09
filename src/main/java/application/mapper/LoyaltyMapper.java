package application.mapper;

import application.entity.LoyaltyEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.Loyalty;

import javax.enterprise.context.ApplicationScoped;

/*@Mapper(componentModel = "cdi")
public interface LoyaltyMapper {
    Loyalty toApi(LoyaltyEntity loyalty);
    LoyaltyEntity toEntity(Loyalty loyalty);
}*/

public class LoyaltyMapper {
    public static Loyalty toApi(LoyaltyEntity loyalty){
        Loyalty loyaltyRet = new Loyalty();
        loyaltyRet.setCustomerId((int)loyalty.getCustomerId());
        loyaltyRet.setBusinessId((int)loyalty.getBusinessId());
        loyaltyRet.setLoyaltyCount(loyalty.getLoyaltyCounter());
        return loyaltyRet;
    }
    public static LoyaltyEntity toEntity(Loyalty loyalty){
        LoyaltyEntity loyaltyEntity = new LoyaltyEntity(loyalty.getCustomerId(), loyalty.getBusinessId());
        loyaltyEntity.setLoyaltyCounter(loyalty.getLoyaltyCount());
        return loyaltyEntity;
    }
}
