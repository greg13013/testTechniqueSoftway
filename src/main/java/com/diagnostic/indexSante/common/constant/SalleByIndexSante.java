package com.diagnostic.indexSante.common.constant;

public enum SalleByIndexSante {

    SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_3("Cardiologie", 3),
    SALLE_WITH_INDEX_SANTE_MULTIPLE_OF_5("Traumatologie", 5),

    SALLE_WITH_OTHER_INDEX_SANTE("Autres", 0);

    private String salle;
    private Integer indexSante;

    private SalleByIndexSante(String salle, Integer indexSante) {
        this.salle = salle;
        this.indexSante = indexSante;
    }

    public String getSalle() {
        return this.salle;
    }

    public Integer getIndexSante() {
        return this.indexSante;
    }
}
