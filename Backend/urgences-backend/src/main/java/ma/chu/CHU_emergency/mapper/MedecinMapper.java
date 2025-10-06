package ma.chu.CHU_emergency.mapper;

import ma.chu.CHU_emergency.dto.MedecinDTO;
import ma.chu.CHU_emergency.entity.Medecin;

public class MedecinMapper {
    public static MedecinDTO toDTO(Medecin medecin) {
        if (medecin == null) return null;
        return new MedecinDTO(
                medecin.getCodeMedecin(),
                medecin.getNom(),
                medecin.getServiceDemandeur() != null ? medecin.getServiceDemandeur().getNomService() : null
        );
    }
}
