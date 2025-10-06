package ma.chu.CHU_emergency.mapper;

import ma.chu.CHU_emergency.dto.MessageDTO;
import ma.chu.CHU_emergency.entity.Message;
import ma.chu.CHU_emergency.entity.Medecin;
import ma.chu.CHU_emergency.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    @Autowired
    private MedecinRepository medecinRepository;

    public MessageDTO toDTO(Message message) {
        String nomMedecin = "Inconnu";

        if (message.getCodeMedecin() != null) {
            Medecin medecin = medecinRepository.findById(message.getCodeMedecin()).orElse(null);
            if (medecin != null) {
                nomMedecin = medecin.getNom();
            }
        }

        return new MessageDTO(
                nomMedecin,
                message.getMessage(),
                message.getDateMessage()
        );
    }
}
