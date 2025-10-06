package ma.chu.CHU_emergency.service;

import ma.chu.CHU_emergency.dto.MessageDTO;
import ma.chu.CHU_emergency.entity.Message;
import ma.chu.CHU_emergency.mapper.MessageMapper;
import ma.chu.CHU_emergency.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    /**
     * Récupère tous les messages
     */
    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Récupère un message par ID
     */
    public MessageDTO getMessageById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
        return messageMapper.toDTO(message);
    }

    /**
     * Récupère tous les messages d’une interconsultation donnée
     */
    public List<MessageDTO> getMessagesByInterconsultationId(Long interconsultationId) {
        return messageRepository.findAll()
                .stream()
                .filter(m -> m.getInterconsultation().getIdInterconsultation().equals(interconsultationId))
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }
}
