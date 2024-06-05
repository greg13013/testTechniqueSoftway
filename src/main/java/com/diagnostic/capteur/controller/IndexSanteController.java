package com.diagnostic.capteur.controller;

import org.springframework.web.bind.annotation.RestController;

import com.diagnostic.capteur.exception.ErrorHandler;
import com.diagnostic.capteur.model.ApiResponse;
import com.diagnostic.capteur.service.IndexSanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class IndexSanteController {

    @Autowired
    private IndexSanteService indexSanteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/index-sante")
    public ResponseEntity<?> getUniteMedicaleByIndexSante(
            @RequestParam(required = false) Integer indexSante) {

        if (indexSante == null) {
            throw new ErrorHandler("Le paramètre 'indexSante' est obligatoire");
        }

        String result = indexSanteService.getUniteMedicaleByIndexSante(indexSante);
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK, result);

        return ResponseEntity.ok(response);
    }

}
