/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financeiroapi.db.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author douglasgass
 */
@Entity
@Table(name = "RISCO")
public class Risco implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToOne
    private Taxa taxa;

    @Column(name = "ativo")
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Taxa getTaxa() {
        return taxa;
    }

    public void setTaxa(Taxa taxa) {
        this.taxa = taxa;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
