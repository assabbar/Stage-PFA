package ma.chu.CHU_emergency.controller;

import ma.chu.CHU_emergency.dto.MedecinDTO;
import ma.chu.CHU_emergency.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecins")
public class MedecinController {

    private final MedecinService medecinService;

    @Autowired
    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @GetMapping
    public ResponseEntity<?> getAllMedecins() {
        List<MedecinDTO> medecins = medecinService.getAllMedecins();
        return ApiResponse.success("Liste des médecins récupérée avec succès", medecins);
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
