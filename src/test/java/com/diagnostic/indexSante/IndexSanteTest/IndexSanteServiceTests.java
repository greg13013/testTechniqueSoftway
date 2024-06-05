package com.diagnostic.indexSante.IndexSanteTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diagnostic.indexSante.common.constant.SalleByIndexSante;
import com.diagnostic.indexSante.service.IndexSanteService;

@SpringBootTest
public class IndexSanteServiceTests {

    @Autowired
    private IndexSanteService indexSanteService;

    @Test
    public void testGetUniteMedicaleByIndexSanteCardiologie() {

        String expected = SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3.getSalle();

        String result = indexSanteService.getUniteMedicaleByIndexSante(3);

        assertEquals(expected, result);
    }

    @Test
    public void testGetUniteMedicaleByIndexSanteTraumatologie() {

        String expected = SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5.getSalle();

        String result = indexSanteService.getUniteMedicaleByIndexSante(5);

        assertEquals(expected, result);
    }

    @Test
    public void testGetUniteMedicaleByIndexSanteOther() {

        String expected = SalleByIndexSante.SALLE_WITH_OTHER_INDEX_SANTE.getSalle();

        String result = indexSanteService.getUniteMedicaleByIndexSante(1);

        assertEquals(expected, result);
    }

    @Test
    public void testGetUniteMedicaleByIndexSanteWithTraumaAndCardio() {

        String expected = SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3.getSalle() + ","
                + SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5.getSalle();

        String result = indexSanteService.getUniteMedicaleByIndexSante(15);

        assertEquals(expected, result);
    }

}
