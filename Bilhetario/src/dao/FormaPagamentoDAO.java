/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.FormaPagamento;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fabricio.pretto
 */
public class FormaPagamentoDAO {

    public boolean salvar(FormaPagamento fp) {
        try {
            Statement st = bilhetario.Bilhetario.conexao.createStatement();

            String sql = "INSERT INTO forma_pagamento VALUES ("
                    + "DEFAULT,"
                    + "'" + fp.getDescricao() + "',"
                    //                    + "'" + fp.getSituacao() + "'"
                    + "'a'"
                    + ")";

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println("Erro salvar xxx = " + e);
        }
        return false;
    }

    public ArrayList<FormaPagamento> consultar() {
        ArrayList<FormaPagamento> formasPagamento = new ArrayList<>();

        try {
            Statement st = bilhetario.Bilhetario.conexao.createStatement();
            
            String sql = "select * from forma_pagamento";
            
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                FormaPagamento fp = new FormaPagamento();
                fp.setId(resultado.getInt("id"));
                fp.setDescricao(resultado.getString("descricao"));
                fp.setSituacao(resultado.getString("situacao").charAt(0));
                
                formasPagamento.add(fp);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar FPs: " + e);
        }

        return formasPagamento;
    }

}
