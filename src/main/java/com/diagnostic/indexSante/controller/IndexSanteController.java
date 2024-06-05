package com.diagnostic.indexSante.controller;

import org.springframework.web.bind.annotation.RestController;

import com.diagnostic.indexSante.dto.ApiResponse;
import com.diagnostic.indexSante.service.IndexSanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class IndexSanteController {

    @Autowired
    private IndexSanteService indexSanteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/index-sante/{indexSante}")
    public ResponseEntity<ApiResponse<String>> getUniteMedicaleByIndexSante(
            @PathVariable("indexSante") Integer indexSante) {

        String result = indexSanteService.getUniteMedicaleByIndexSante(indexSante);
        ApiResponse<String> response = new ApiResponse<>(result);

        return ResponseEntity.ok(response);
    }

}
