package ma.chu.CHU_emergency.mapper;

import ma.chu.CHU_emergency.dto.DemandeDTO;
import ma.chu.CHU_emergency.entity.Interconsultation;
import org.springframework.stereotype.Component;

@Component
public class DemandeMapper {

    public DemandeDTO toDTO(Interconsultation entity) {
        return new DemandeDTO(
                entity.getDemande(),
                entity.getDateDemande()
        );
    }
}
