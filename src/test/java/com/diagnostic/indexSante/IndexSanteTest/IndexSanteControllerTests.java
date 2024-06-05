package com.diagnostic.indexSante.IndexSanteTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.diagnostic.indexSante.common.constant.EnumSalleWithIndexSante;

@SpringBootTest
@AutoConfigureMockMvc
public class IndexSanteControllerTests {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void the_consumer_get_cardiology() throws Exception {
                mockMvc.perform(get("/api/index-sante/3"))
                                .andExpect(status().isOk()).andExpect(jsonPath("$.data",
                                                is(EnumSalleWithIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3
                                                                .getSalle())));
        }

        @Test
        public void the_consumer_get_traumatology() throws Exception {
                mockMvc.perform(get("/api/index-sante/5"))
                                .andExpect(status().isOk()).andExpect(jsonPath("$.data",
                                                is(EnumSalleWithIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5
                                                                .getSalle())));
        }

        @Test
        public void the_consumer_get_cardiology_and_traumatology() throws Exception {
                mockMvc.perform(get("/api/index-sante/15"))
                                .andExpect(status().isOk()).andExpect(jsonPath("$.data",
                                                is(EnumSalleWithIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3
                                                                .getSalle()
                                                                + ","
                                                                + EnumSalleWithIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5
                                                                                .getSalle())));
        }

        @Test
        public void the_consumer_get_error() throws Exception {
                mockMvc.perform(get("/api/index-sante/test"))
                                .andExpect(status().isBadRequest());
        }
}
