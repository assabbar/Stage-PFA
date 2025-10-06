package ma.chu.CHU_emergency.service;

import ma.chu.CHU_emergency.dto.HopitalServiceDTO;
import ma.chu.CHU_emergency.mapper.HopitalServiceMapper;
import ma.chu.CHU_emergency.repository.HopitalServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HopitalServiceService {

    private final HopitalServiceRepository hopitalServiceRepository;
    private final HopitalServiceMapper hopitalServiceMapper;

    public HopitalServiceService(HopitalServiceRepository hopitalServiceRepository,
                                 HopitalServiceMapper hopitalServiceMapper) {
        this.hopitalServiceRepository = hopitalServiceRepository;
        this.hopitalServiceMapper = hopitalServiceMapper;
    }

    public List<HopitalServiceDTO> getAllHopitalServices() {
        return hopitalServiceRepository.findAll()
                .stream()
                .map(hopitalServiceMapper::toDTO)
                .collect(Collectors.toList());
    }
}
