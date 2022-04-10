/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.sismos.managebean;

import java.io.Serializable;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;


import com.javarevolutions.sismos.dominio.Cliente;
import com.javarevolutions.sismos.repositorio.ClienteRepositorio;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author JavaRevolutions
 */
@Named(value = "clienteC")
@ViewScoped
public class ClienteControle implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Cliente cliente;
    private DataModel<Cliente> modelClientes;
    private int aba;
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public void pesquisarPorNome(){
        List<Cliente> clientes = clienteRepositorio.findAll();
        modelClientes = new ListDataModel<>(clientes);
    }

    public void salvar(){
        try {
            clienteRepositorio.save(cliente);
            //TODO Mensagem de sucesso
        } catch (Exception e) {
            //TODO Mensagem de erro
        }
    }

//    getters e setters
    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DataModel<Cliente> getModelClientes() {
        return modelClientes;
    }   

    public int getAba() {
        return aba;
    }

    public void setAba(int aba) {
        this.aba = aba;
    }

}
