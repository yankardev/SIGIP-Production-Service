package pe.edu.cibertec.sigip.productionservice.client;

/** Datos mínimos del diseño requeridos antes de iniciar producción. */
public record DisenoResumen(Integer iddiseno, Integer idpedido, String estado) {
}
