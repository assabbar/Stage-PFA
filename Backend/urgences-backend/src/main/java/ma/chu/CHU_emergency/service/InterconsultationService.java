package ma.chu.CHU_emergency.service;

import ma.chu.CHU_emergency.dto.InterconsultationDTO;
import ma.chu.CHU_emergency.entity.Interconsultation;
import ma.chu.CHU_emergency.mapper.InterconsultationMapper;
import ma.chu.CHU_emergency.repository.InterconsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterconsultationService {

    private final InterconsultationRepository interconsultationRepository;
    private final InterconsultationMapper interconsultationMapper;

    public InterconsultationService(InterconsultationRepository interconsultationRepository,
                                    InterconsultationMapper interconsultationMapper) {
        this.interconsultationRepository = interconsultationRepository;
        this.interconsultationMapper = interconsultationMapper;
    }

    public List<InterconsultationDTO> getAllInterconsultations() {
        return interconsultationRepository.findAll()
                .stream()
                .map(interconsultationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public InterconsultationDTO getInterconsultationById(Long id) {
        Interconsultation inter = interconsultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interconsultation not found"));
        return interconsultationMapper.toDTO(inter);
    }
}
