package ma.chu.CHU_emergency.repository;

import ma.chu.CHU_emergency.entity.Interconsultation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface InterconsultationRepository extends JpaRepository<Interconsultation, Long> {
}
