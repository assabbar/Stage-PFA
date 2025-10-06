package ma.chu.CHU_emergency.controller;

import ma.chu.CHU_emergency.dto.InterconsultationDTO;
import ma.chu.CHU_emergency.service.InterconsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interconsultations")

public class InterconsultationController {

    private final InterconsultationService interconsultationService;

    @Autowired
    public InterconsultationController(InterconsultationService interconsultationService) {
        this.interconsultationService = interconsultationService;
    }

    /**
     * Récupérer toutes les interconsultations
     */
    @GetMapping
    public ResponseEntity<?> getAllInterconsultations() {
        List<InterconsultationDTO> interconsultations = interconsultationService.getAllInterconsultations();
        return ApiResponse.success("Liste des interconsultations récupérée avec succès", interconsultations);
    }

    /**
     * Récupérer une interconsultation par son ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getInterconsultationById(@PathVariable Long id) {
        try {
            InterconsultationDTO dto = interconsultationService.getInterconsultationById(id);
            return ApiResponse.success("Interconsultation trouvée", dto);
        } catch (RuntimeException e) {
            return ApiResponse.notFound("Interconsultation introuvable avec id = " + id);
        }
    }

    /**
     * Classe interne ApiResponse pour unifier les réponses
     */
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

        // Getters nécessaires pour sérialisation JSON
        public String getMessage() { return message; }
        public Object getData() { return data; }
    }
}
