package pe.sigip.production.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes_produccion")
public class OrdenProduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long pedidoId;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String etapa;

    @NotBlank
    @Column(nullable = false, length = 30)
    private String estado = "PENDIENTE";

    @NotNull
    @Column(nullable = false)
    private LocalDateTime actualizadoEn = LocalDateTime.now();

    public Long getId() { return id; }
    public Long getPedidoId() { return pedidoId; }
    public String getEtapa() { return etapa; }
    public String getEstado() { return estado; }
    public LocalDateTime getActualizadoEn() { return actualizadoEn; }

    public void setId(Long id) { this.id = id; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }
    public void setEtapa(String etapa) { this.etapa = etapa; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
