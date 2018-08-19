/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  douglasgass
 * Created: 19/08/2018
 */

select c.nome, r.descricao, t.valor from solicitacao s, cliente c, risco r, taxa t where r.id = s.risco_id and c.id = s.cliente_id and t.id = r.taxa_id;