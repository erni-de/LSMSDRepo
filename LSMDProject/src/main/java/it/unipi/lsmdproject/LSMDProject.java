/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.unipi.lsmdproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author erni
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LSMDProject extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Inizializzazione del pulsante
        Button btn = new Button();
        btn.setText("Cliccami!");

        // Stampa del testo del pulsante - ora funziona correttamente all'interno del thread JavaFX
        System.out.println("Testo del pulsante: " + btn.getText());

        // Configurazione del layout
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Creazione della scena
        Scene scene = new Scene(root, 300, 250);

        // Imposta la finestra principale
        primaryStage.setTitle("Verifica JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Avvio dell'applicazione JavaFX
    }
}
