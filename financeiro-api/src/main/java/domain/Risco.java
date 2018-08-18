/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author douglasgass
 */
public enum Risco {
    A, B, C;

    private int descricao;

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public int getDescricao() {
        return descricao;
    }
}
