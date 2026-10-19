package pe.sigip.production.model;
import jakarta.persistence.*; import jakarta.validation.constraints.NotBlank; import java.time.LocalDateTime;
@Entity @Table(name="ordenes_produccion")
public class OrdenProduccion {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private Long pedidoId;
 @NotBlank @Column(nullable=false,length=80) private String etapa;
 @Column(nullable=false,length=30) private String estado="PENDIENTE";
 @Column(nullable=false) private LocalDateTime actualizadoEn=LocalDateTime.now();
 public Long getId(){return id;} public Long getPedidoId(){return pedidoId;} public String getEtapa(){return etapa;} public String getEstado(){return estado;} public LocalDateTime getActualizadoEn(){return actualizadoEn;}
 public void setId(Long v){id=v;} public void setPedidoId(Long v){pedidoId=v;} public void setEtapa(String v){etapa=v;} public void setEstado(String v){estado=v;} public void setActualizadoEn(LocalDateTime v){actualizadoEn=v;}
}