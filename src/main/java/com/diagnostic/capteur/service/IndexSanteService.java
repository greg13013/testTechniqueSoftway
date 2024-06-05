package com.diagnostic.capteur.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.diagnostic.capteur.common.constant.SalleByIndexSante;

import lombok.Data;

@Data
@Service
public class IndexSanteService {

    public String getUniteMedicaleByIndexSante(Integer indexSante) {

        boolean isMultipleOf3 = isMultipleOf(indexSante,
                SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3.getIndexSante());
        boolean isMultipleOf5 = isMultipleOf(indexSante,
                SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5.getIndexSante());

        ArrayList<String> listUniteMedicale = new ArrayList<String>();

        if (isMultipleOf3) {
            listUniteMedicale.add(SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3.getSalle());
        }

        if (isMultipleOf5) {
            listUniteMedicale.add(SalleByIndexSante.SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5.getSalle());
        }

        if (listUniteMedicale.isEmpty()) {
            return SalleByIndexSante.SALLE_WITH_OTHER_INDEX_SANTE.getSalle();
        }

        String resultUniteMedical = String.join(",", listUniteMedicale);

        return resultUniteMedical;
    }

    public boolean isMultipleOf(Integer number, Integer multiple) {
        return number % multiple == 0;
    }
}
