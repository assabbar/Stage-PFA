package ma.chu.CHU_emergency.mapper;

import ma.chu.CHU_emergency.dto.HopitalServiceDTO;
import ma.chu.CHU_emergency.entity.HopitalService;
import org.springframework.stereotype.Component;

@Component
public class HopitalServiceMapper {

    public HopitalServiceDTO toDTO(HopitalService service) {
        if (service == null) {
            return null;
        }

        return new HopitalServiceDTO(
                service.getCodeService(),
                service.getNomService()
        );
    }

    public HopitalService toEntity(HopitalServiceDTO dto) {
        if (dto == null) {
            return null;
        }

        HopitalService service = new HopitalService();
        service.setCodeService(dto.getCodeService());
        service.setNomService(dto.getNomService());

        return service;
    }
}
