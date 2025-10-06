package ma.chu.CHU_emergency.controller;

import ma.chu.CHU_emergency.dto.PatientDTO;
import ma.chu.CHU_emergency.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPatients() {
        List<PatientDTO> patients = patientService.getAllPatients();
        return ApiResponse.success("Liste des patients récupérée avec succès", patients);
    }

    // Classe interne ApiResponse réutilisable
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
