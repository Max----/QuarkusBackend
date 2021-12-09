package application.mapper;

import application.entity.VisitEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.Visit;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;

/*@Mapper(componentModel = "cdi")
public interface VisitMapper {
    Visit toApi(VisitEntity customer);
    VisitEntity toEntity(Visit customer);
}*/

public class VisitMapper {
    public static Visit toApi(VisitEntity visitEntity){
        Visit visit = new Visit();
        visit.setBusinessId((int)visitEntity.getBusinessId());
        visit.setCustomerId((int)visitEntity.getCustomerId());
        visit.setDate(visitEntity.getDateTime().toString());
        return visit;
    }
    public static VisitEntity toEntity(Visit visit){
        VisitEntity visitEntity = new VisitEntity(visit.getCustomerId(), visit.getBusinessId());
        visitEntity.setDateTime(LocalDateTime.parse(visit.getDate()));
        return visitEntity;
    }
}

