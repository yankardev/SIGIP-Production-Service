package pe.sigip.production.controller;

import jakarta.validation.Valid;
import pe.sigip.production.model.OrdenProduccion;
import pe.sigip.production.repository.OrdenProduccionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/production/ordenes")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenProduccionController {
    private final OrdenProduccionRepository repository;

    public OrdenProduccionController(OrdenProduccionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrdenProduccion> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public OrdenProduccion buscar(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden de producción no encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdenProduccion crear(@Valid @RequestBody OrdenProduccion orden) {
        orden.setId(null);
        if (orden.getEstado() == null || orden.getEstado().isBlank()) {
            orden.setEstado("PENDIENTE");
        }
        orden.setActualizadoEn(LocalDateTime.now());
        return repository.save(orden);
    }

    @PutMapping("/{id}")
    public OrdenProduccion actualizar(@PathVariable Long id, @Valid @RequestBody OrdenProduccion datos) {
        OrdenProduccion orden = buscar(id);
        orden.setPedidoId(datos.getPedidoId());
        orden.setEtapa(datos.getEtapa());
        if (datos.getEstado() != null && !datos.getEstado().isBlank()) {
            orden.setEstado(datos.getEstado());
        }
        orden.setActualizadoEn(LocalDateTime.now());
        return repository.save(orden);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden de producción no encontrada");
        }
        repository.deleteById(id);
    }
}
