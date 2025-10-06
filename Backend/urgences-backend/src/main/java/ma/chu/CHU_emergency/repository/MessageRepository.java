package ma.chu.CHU_emergency.repository;

import ma.chu.CHU_emergency.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface MessageRepository extends JpaRepository<Message, Long> {
}
