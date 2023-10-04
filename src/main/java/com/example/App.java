package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.json.JSONArray;
import javafx.json.JSONObject;

public class App {
    public static void main(String[] args) {
        String jsonResponse = "{\"nome\":\"João\",\"idade\":30,\"cidade\":\"São Paulo\"}";

        JSONObject jsonObject = new JSONObject(jsonResponse);

        String nome = jsonObject.getString("nome");
        int idade = jsonObject.getInt("idade");
        String cidade = jsonObject.getString("cidade");

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);

        String jsonArrayResponse = "[{\"nome\":\"Maria\",\"idade\":25,\"cidade\":\"Rio de Janeiro\"}," +
                                   "{\"nome\":\"Pedro\",\"idade\":35,\"cidade\":\"Belo Horizonte\"}]";

        JSONArray jsonArray = new JSONArray(jsonArrayResponse);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            String nomeItem = item.getString("nome");
            int idadeItem = item.getInt("idade");
            String cidadeItem = item.getString("cidade");

            System.out.println("Nome: " + nomeItem);
            System.out.println("Idade: " + idadeItem);
            System.out.println("Cidade: " + cidadeItem);
        }
    }

    public static void setRoot(String string) {
    }
}
