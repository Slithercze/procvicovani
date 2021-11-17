package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static java.lang.Integer.parseInt;

public class CSVtoDB {
    public static void main(String[] args) {

        // login do databaze
        String jdbcUrl = "jdbc:mysql://localhost:3306/CoreIT";
        String username = "root";
        String password = "";

        // adresáře souborů
        String filePath = "C:\\Users\\Slith\\Desktop\\CSVtoDB\\demo\\src\\main\\java\\com\\example\\data.csv";
        String zpracovana_data = "C:\\Users\\Slith\\Desktop\\CSVtoDB\\demo\\src\\main\\java\\com\\example\\zpracovaná data\\data.csv";
        File sourceFile = new File(filePath);
        File destinationFile = new File(zpracovana_data);

        int batchSize = 20;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password); // připojení do databaze
            connection.setAutoCommit(false);

            // insert do databaze
            String sql = "insert into CoreIT(IČO,nazev_firmy,adresa_firmy,email_zam,jmeno_zam,prijmeni_zam,datum) values(?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath)); // čtení csv souboru

            String lineText = null;
            int count = 0;
            System.out.println("IČO \t Název firmy \t Adresa firmy \t Email \t Jméno \t Příjmení");
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(";"); // čtení z CSV souboru

                String IČO = data[0];
                String nazev_firmy = data[1];
                String adresa_firmy = data[2];
                String email_zam = data[3];
                String jmeno_zam = data[4];
                String prijmeni_zam = data[5];

                // vloženi do relační tabulky
                statement.setInt(1, parseInt(IČO));
                statement.setString(2, nazev_firmy);
                statement.setString(3, adresa_firmy);
                statement.setString(4, email_zam);
                statement.setString(5, jmeno_zam);
                statement.setString(6, prijmeni_zam);
                statement.setDate(7, new java.sql.Date(System.currentTimeMillis())); // aktuální datum poslední
                                                                                     // aktualizace

                for (String index : data) { // zobrazeni vlozenych dat
                    System.out.printf("%-10s", index);
                }
                System.out.println();

                statement.addBatch();
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit(); // ukončení pripojení
            connection.close();
            System.out.println("\n Data úspěšně vložena do databáze");
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING); // přesun
                                                                                                            // souboru
                                                                                                            // do
                                                                                                            // zpracovaných

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
