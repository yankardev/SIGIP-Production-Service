package pe.edu.cibertec.sigip.productionservice.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.sigip.common.error.ServicioNoDisponibleException;

import java.util.List;

/** Consulta a design-service para impedir que producción avance sin arte aprobado. */
@FeignClient(name = "design-service", fallbackFactory = DesignServiceClient.Fallback.class)
public interface DesignServiceClient {

    @GetMapping("/api/v1/disenos")
    List<DisenoResumen> listar(@RequestParam("idpedido") Integer idpedido);

    @Component
    class Fallback implements FallbackFactory<DesignServiceClient> {
        @Override
        public DesignServiceClient create(Throwable causa) {
            return idpedido -> {
                throw new ServicioNoDisponibleException("El servicio de diseño no está disponible en este momento");
            };
        }
    }
}
