package com.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DadosUsuario {
    private SimpleStringProperty nome;
    private SimpleIntegerProperty idade;
    private SimpleStringProperty cidade;

    public DadosUsuario(String nome, int idade, String cidade) {
        this.nome = new SimpleStringProperty(nome);
        this.idade = new SimpleIntegerProperty(idade);
        this.cidade = new SimpleStringProperty(cidade);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public int getIdade() {
        return idade.get();
    }

    public SimpleIntegerProperty idadeProperty() {
        return idade;
    }

    public String getCidade() {
        return cidade.get();
    }

    public SimpleStringProperty cidadeProperty() {
        return cidade;
    }
}
