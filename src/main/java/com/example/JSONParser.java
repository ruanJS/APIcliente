package com.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {
    public static <JSONArray> void main(String[] args) {
        // Suponha que você tenha uma resposta JSON em uma string chamada jsonResponse
        String jsonResponse = "[{\"nome\":\"João\",\"idade\":30,\"cidade\":\"São Paulo\"}]";

        // Criar um array JSON a partir da string de resposta
        JSONArray jsonArray = new JSONArray(jsonResponse);

        // Iterar sobre os objetos no array
        for (int i = 0; i < ((String) jsonArray).length(); i++) {
            JSONObject item = ((Object) jsonArray).getJSONObject(i);
            String nomeItem = item.getString("nome");
            int idadeItem = item.getInt("idade");
            String cidadeItem = item.getString("cidade");

            System.out.println("Nome: " + nomeItem);
            System.out.println("Idade: " + idadeItem);
            System.out.println("Cidade: " + cidadeItem);
        }
    }
}
