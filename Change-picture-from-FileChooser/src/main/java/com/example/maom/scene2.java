package com.example.maom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class scene2 implements Initializable {

    public ImageView img;
    public Button button;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        img.setImage(new Image((readFile())));
    }

    public String readFile() {
        String st;
        String str = null;

        try {
            File file = new File("directory\\file2.txt");
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null)  return (st);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (str.toString());
    }

    @FXML
    public void change(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("scene-1");
        stage.setScene(scene);
        stage.show();
    }

}
