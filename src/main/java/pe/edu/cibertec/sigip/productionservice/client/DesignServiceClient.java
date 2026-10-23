package pe.edu.cibertec.sigip.productionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "design-service")
public interface DesignServiceClient {
    @GetMapping("/api/v1/disenos")
    List<DisenoResumen> listar(@RequestParam("idpedido") Integer idpedido);

    record DisenoResumen(Integer iddiseno, Integer idpedido, Integer version, String estado) {}
}
