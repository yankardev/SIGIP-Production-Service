package pe.sigip.production.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ProductionHealthController {
    @GetMapping("/api/production/health")
    public Map<String, String> health() {
        return Map.of("servicio", "SIGIP Production Service", "estado", "activo");
    }
}
