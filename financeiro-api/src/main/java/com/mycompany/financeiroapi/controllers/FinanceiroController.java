/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financeiroapi.controllers;

import com.mycompany.financeiroapi.DTO.Response;
import com.mycompany.financeiroapi.DTO.Status;
import com.mycompany.financeiroapi.DTO.Financeiro;
import com.mycompany.financeiroapi.service.FinanceiroService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author douglasgass
 */
@RestController
@RequestMapping(path = "/api/v1/financeiro")
public class FinanceiroController {

    @Autowired
    FinanceiroService service;

    @RequestMapping(method = RequestMethod.POST, path = "solicitar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response criarSolicitacao(
            @Valid @RequestBody Financeiro dto
    ) {
        return service.criarSolicitacao(dto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "risco", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response risco() {
        return service.buscarDominioDeRiscos();
    }

}
