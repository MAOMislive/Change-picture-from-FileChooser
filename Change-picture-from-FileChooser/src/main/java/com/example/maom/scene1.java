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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class scene1 implements Initializable {

    public Button button1;
    public Button button2;
    public ImageView img;
    @FXML
    private Button button;

    String pic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        img.setImage(new Image((readFile())));
    }

    public void change_in_1(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);
        String filelocation = null;
        try{
            if(selectedFiles != null) {
                filelocation = selectedFiles.get(0).getAbsolutePath();
            }
            FileWriter fWriter = new FileWriter("directory/file1.txt");
            fWriter.write(filelocation);
            fWriter.close();
            img.setImage(new Image(filelocation));

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public String readFile() {
        String st;
        String str = null;

        try {
            File file = new File("directory\\file1.txt");
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null)  return (st);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (str.toString());
    }

    public void change_in_2(ActionEvent actionEvent) {FileChooser fc = new FileChooser();
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);
        String filelocation = null;
        try{
            if(selectedFiles != null) {
                filelocation = selectedFiles.get(0).getAbsolutePath();
            }
            FileWriter fWriter = new FileWriter("directory/file2.txt");
            fWriter.write(filelocation);
            fWriter.close();


        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("scene-2");
        stage.setScene(scene);
        stage.show();
    }
}


