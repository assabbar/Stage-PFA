package ma.chu.CHU_emergency.controller;

import ma.chu.CHU_emergency.dto.MessageDTO;
import ma.chu.CHU_emergency.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<?> getAllMessages() {
        List<MessageDTO> messages = messageService.getAllMessages();
        return ApiResponse.success("Liste des messages récupérée avec succès", messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable Long id) {
        try {
            MessageDTO dto = messageService.getMessageById(id);
            return ApiResponse.success("Message trouvé", dto);
        } catch (RuntimeException e) {
            return ApiResponse.notFound("Message introuvable avec id = " + id);
        }
    }

    @GetMapping("/interconsultation/{interId}")
    public ResponseEntity<?> getMessagesByInterconsultation(@PathVariable("interId") Long interId) {
        List<MessageDTO> messages = messageService.getMessagesByInterconsultationId(interId);
        return ApiResponse.success("Messages récupérés pour l’interconsultation " + interId, messages);
    }

    static class ApiResponse {
        private final String message;
        private final Object data;

        private ApiResponse(String message, Object data) {
            this.message = message;
            this.data = data;
        }

        public static ResponseEntity<ApiResponse> success(String message, Object data) {
            return ResponseEntity.ok(new ApiResponse(message, data));
        }

        public static ResponseEntity<ApiResponse> notFound(String message) {
            return ResponseEntity.status(404).body(new ApiResponse(message, null));
        }

        public String getMessage() { return message; }
        public Object getData() { return data; }
    }
}
