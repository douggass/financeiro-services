/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financeiroapi.db.repository;

import org.springframework.data.repository.CrudRepository;
import com.mycompany.financeiroapi.db.entity.Risco;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author douglasgass
 */
public interface RiscoRepository extends CrudRepository<Risco, Long> {

    @Query("SELECT r FROM Risco r WHERE r.descricao = ?1")
    Risco findByDescricao(String descricao);
}
