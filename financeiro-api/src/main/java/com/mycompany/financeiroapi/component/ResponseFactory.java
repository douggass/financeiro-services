/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financeiroapi.component;

import org.springframework.stereotype.Component;
import com.mycompany.financeiroapi.DTO.Response;
import com.mycompany.financeiroapi.DTO.Status;

/**
 *
 * @author douglasgass
 */
@Component
public class ResponseFactory {

    private final String MENSAGEM_SUCESSO = "Requisição efetuada com sucesso.";
    private final String MENSAGEM_ERRO = "Erro ao realizar requisição.";

    public Response create(Object obj, String erro) {
        Response response = new Response();
        Status status = new Status();
        if (erro == null) {
            response.setData(obj);
            status.setCodigo(0);
            status.setMensagem(MENSAGEM_SUCESSO);
        } else {
            //usar padrão para diferentes tipos de código
            status.setCodigo(-1);
            status.setMensagem(erro);
//            status.setMensagem(MENSAGEM_ERRO);
        }
        response.setStatus(status);
        return response;
    }

}
