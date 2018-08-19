/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financeiroapi.service;

import com.mycompany.financeiroapi.DTO.Financeiro;
import com.mycompany.financeiroapi.component.ResponseFactory;
import com.mycompany.financeiroapi.db.entity.Cliente;
import com.mycompany.financeiroapi.db.entity.SolicitacaoCredito;
import com.mycompany.financeiroapi.db.entity.Risco;
import com.mycompany.financeiroapi.DTO.Response;
import com.mycompany.financeiroapi.db.repository.ClienteRepository;
import com.mycompany.financeiroapi.db.repository.RiscoRepository;
import com.mycompany.financeiroapi.db.repository.SolicitacaoRepository;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author douglasgass
 */
@Service
public class FinanceiroService {

    @Autowired
    private RiscoRepository riscoRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ResponseFactory factory;

    public Response criarSolicitacao(Financeiro financeiro) {
        String erro = null;
        try {
            SolicitacaoCredito solicitacao = new SolicitacaoCredito();
            solicitacao.setCliente(criarCliente(financeiro));
            Risco risco = riscoRepository.findByDescricao(financeiro.getRisco());
            solicitacao.setRisco(risco);
            solicitacaoRepository.save(solicitacao);
        } catch (Exception e) {
            erro = e.getMessage();
        }
        return factory.create(null, erro);
    }

    public Response buscarDominioDeRiscos() {
        String erro = null;
        List<String> riscos = null;
        try {
            riscos = StreamSupport.stream(riscoRepository.findAll().spliterator(), false).map(temp -> {
                return temp.getDescricao();
            }).collect(Collectors.toList());
        } catch (Exception e) {
            erro = e.getMessage();
        }
        return factory.create(riscos, erro);
    }

    private Cliente criarCliente(Financeiro financeiro) {
        Cliente cliente = new Cliente();
        cliente.setNome(financeiro.getNomeCliente());
        clienteRepository.save(cliente);
        return cliente;
    }

}
