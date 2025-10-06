package ma.chu.CHU_emergency.mapper;

import ma.chu.CHU_emergency.dto.InterconsultationDTO;
import ma.chu.CHU_emergency.dto.MessageDTO;
import ma.chu.CHU_emergency.entity.Interconsultation;
import ma.chu.CHU_emergency.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InterconsultationMapper {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private DemandeMapper demandeMapper;

    public InterconsultationDTO toDTO(Interconsultation entity) {
        List<MessageDTO> messageDTOs = null;
        if (entity.getMessages() != null) {
            messageDTOs = entity.getMessages().stream()
                    .map(messageMapper::toDTO)
                    .collect(Collectors.toList());
        }

        return new InterconsultationDTO(
                String.valueOf(entity.getPatient().getIdPatient()),
                entity.getPatient().getNom(),
                entity.getPatient().getGenre().getLabel(),
                entity.getPatient().getAge(),
                entity.getMedecinDemandeur().getNom(),
                entity.getDateDemande(),
                entity.getStatut().getLabel(),
                entity.getMedecinDemandeur().getServiceDemandeur().getNomService(),
                entity.getServiceDestinataire().getNomService(),
                entity.isUrgent() ? 1 : 0,
                demandeMapper.toDTO(entity),
                messageDTOs
        );
    }
}
