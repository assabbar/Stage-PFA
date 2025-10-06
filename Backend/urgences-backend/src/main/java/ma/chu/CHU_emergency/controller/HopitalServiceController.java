package ma.chu.CHU_emergency.controller;

import ma.chu.CHU_emergency.dto.HopitalServiceDTO;
import ma.chu.CHU_emergency.service.HopitalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class HopitalServiceController {

    private final HopitalServiceService hopitalServiceService;

    @Autowired
    public HopitalServiceController(HopitalServiceService hopitalServiceService) {
        this.hopitalServiceService = hopitalServiceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllHopitalServices() {
        List<HopitalServiceDTO> services = hopitalServiceService.getAllHopitalServices();
        return ApiResponse.success("Liste des services hospitaliers récupérée avec succès", services);
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
