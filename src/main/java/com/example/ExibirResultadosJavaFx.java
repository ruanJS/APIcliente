package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExibirResultadosJavaFX extends Application {
    private TableView<DadosUsuario> tableView = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exibir Resultados JSON em JavaFX");

        TableColumn<DadosUsuario, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<DadosUsuario, String> idadeColumn = new TableColumn<>("Idade");
        idadeColumn.setCellValueFactory(cellData -> cellData.getValue().idadeProperty().asString());

        TableColumn<DadosUsuario, String> cidadeColumn = new TableColumn<>("Cidade");
        cidadeColumn.setCellValueFactory(cellData -> cellData.getValue().cidadeProperty());

        tableView.getColumns().addAll(nomeColumn, idadeColumn, cidadeColumn);

        Scene scene = new Scene(tableView);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Suponha que você tenha uma resposta JSON em uma string chamada jsonResponse
        String jsonResponse = "[{\"nome\":\"João\",\"idade\":30,\"cidade\":\"São Paulo\"}," +
                              "{\"nome\":\"Maria\",\"idade\":25,\"cidade\":\"Rio de Janeiro\"}]";

        // Criar um array JSON a partir da string de resposta
        JSONArray jsonArray = new JSONArray(jsonResponse);

        ObservableList<DadosUsuario> dadosUsuarios = FXCollections.observableArrayList();

        // Iterar sobre os objetos no array JSON e adicionar à lista de dados
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            String nomeItem = item.getString("nome");
            int idadeItem = item.getInt("idade");
            String cidadeItem = item.getString("cidade");

            dadosUsuarios.add(new DadosUsuario(nomeItem, idadeItem, cidadeItem));
        }

        // Definir os dados da tabela
        tableView.setItems(dadosUsuarios);
    }
}
