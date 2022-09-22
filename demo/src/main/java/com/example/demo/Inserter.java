package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Inserter {

    public static void main(String[] args) throws IOException {
        // TODO document why this method is empty
    }

    public void populate(MvcController mvcController) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/java/com/example/demo/data.json")));
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("bets");

        query("DROP TABLE IF EXISTS bets");
        query("CREATE TABLE if not exists `bets` (`id` varchar(255) NOT NULL,`game` longtext,`numbets` varchar(255) DEFAULT NULL,`stake` double DEFAULT NULL,`returns` double DEFAULT NULL,`clientid` varchar(255) DEFAULT NULL,`date` datetime DEFAULT NULL,PRIMARY KEY (`id`),UNIQUE KEY `id_UNIQUE` (`id`))");

        for (int i = 0; i < arr.length(); i++) {
            Bet bet = objectMapper.readValue(arr.getJSONObject(i).toString(), Bet.class);

            Integer id = bet.getId();
            String game = bet.getGame();
            Integer numbets = bet.getNumbets();
            double stake = bet.getStake();
            double returns = bet.getReturns();
            Integer clientid = bet.getClientid();
            Date date = bet.getDate();

            String s = "INSERT INTO bets VALUES (" + id + "," + '"' + game + '"' + "," + numbets + "," + stake + ","
                    + returns + "," + clientid + "," + '"' + date + '"' + ");";

            query(s);

            // Send kafka message to topic: bet_detail
            mvcController.sendMessage(String.valueOf(returns));
        }

    }

    public void query(String statement) {

        try {
            String url = "jdbc:mysql://mysql_db:3306/interview";
            Connection connection = DriverManager.getConnection(url, "root", "passwrd");
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}