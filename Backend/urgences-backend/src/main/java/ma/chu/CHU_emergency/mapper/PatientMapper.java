package ma.chu.CHU_emergency.mapper;

import ma.chu.CHU_emergency.dto.PatientDTO;
import ma.chu.CHU_emergency.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public PatientDTO toDTO(Patient patient) {
        return new PatientDTO(
                String.valueOf(patient.getIdPatient()),
                patient.getNom(),
                patient.getGenre().getLabel(),
                patient.getAge()
        );
    }
}
