package ma.chu.CHU_emergency.service;

import ma.chu.CHU_emergency.dto.MedecinDTO;
import ma.chu.CHU_emergency.entity.Medecin;
import ma.chu.CHU_emergency.repository.MedecinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedecinService {

    private final MedecinRepository medecinRepository;

    public MedecinService(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    public List<MedecinDTO> getAllMedecins() {
        return medecinRepository.findAll()
                .stream()
                .map(m -> new MedecinDTO(m.getCodeMedecin(), m.getNom(),
                        m.getServiceDemandeur() != null ? m.getServiceDemandeur().getNomService() : null))
                .collect(Collectors.toList());
    }
}
