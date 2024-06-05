package com.diagnostic.capteur.IndexSanteTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.diagnostic.capteur.common.constant.SalleByIndexSante;

@SpringBootTest
@AutoConfigureMockMvc
public class IndexSanteControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUniteMedicaleByIndexSanteIsOkAndServiceIsCardiologie() throws Exception {
        mockMvc.perform(get("/api/index-sante?indexSante=3"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data",
                        is(SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3.getSalle())));
    }

    @Test
    public void testGetUniteMedicaleByIndexSanteIsOkAndServiceIsTraumatologie() throws Exception {
        mockMvc.perform(get("/api/index-sante?indexSante=5"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data",
                        is(SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5.getSalle())));
    }

    @Test
    public void testGetUniteMedicaleByIndexSanteIsOkAndServiceIsCardiologieAndTraumatologie() throws Exception {
        mockMvc.perform(get("/api/index-sante?indexSante=15"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data",
                        is(SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3.getSalle() + ","
                                + SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5.getSalle())));
    }

    @Test
    public void testGetUniteMedicaleByIndexSanteIsNotOkParamsMissing() throws Exception {
        mockMvc.perform(get("/api/index-sante"))
                .andExpect(status().isBadRequest());
    }
}
