package pe.sigip.production.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import pe.sigip.production.repository.OrdenProduccionRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductionHealthController.class)
class ProductionHealthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthReturnsActiveStatus() throws Exception {
        mockMvc.perform(get("/api/production/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("activo"));
    }
}
