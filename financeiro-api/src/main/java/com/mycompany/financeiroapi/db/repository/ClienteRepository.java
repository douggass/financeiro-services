/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financeiroapi.db.repository;

import com.mycompany.financeiroapi.db.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author douglasgass
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
