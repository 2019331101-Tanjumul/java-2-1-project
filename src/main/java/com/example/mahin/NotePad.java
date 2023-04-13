package com.example.mahin;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileWriter;


public class NotePad {


    NotePad() {

    }

    void load(){
          MenuBar menubar = new MenuBar();
          Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
          Menu format = new Menu("Format");
        Menu view = new Menu("View");
        Menu Help = new Menu("Help");
           Menu Game = new Menu("Game");
              Menu About = new Menu ("About project");

            MenuItem New= new MenuItem("New");
         MenuItem Open = new MenuItem("Open");
          MenuItem Save = new MenuItem("Save");
        MenuItem Save_as = new MenuItem("Save AS");
         MenuItem New_game = new MenuItem("Start");
        MenuItem Left_View = new MenuItem("Left view");
          MenuItem Right_View = new MenuItem("Right View");
        MenuItem Bottom_view = new MenuItem("Bootom View");
         MenuItem developer = new MenuItem("Developed By Tanjumul Alom_2019331101,Cse_SUST\nand Sourav Kumar_2019331033,Cse_SUST.");
        MenuItem second = new MenuItem("Submitted to,\nSummit Haque\nAssistant Professor of\nDepartment of Computer Science and Engineering,SUST ");

         file.getItems().addAll(New,Open,Save,Save_as);
        Game.getItems().addAll(New_game);
         view.getItems().addAll(Left_View,Right_View,Bottom_view);
           About.getItems().addAll(second,developer);

        menubar.getMenus().addAll(file,edit,format,view,Help,Game,About);


          TextArea textarea = new TextArea();
        textarea.setMaxWidth(1600);
           textarea.setMaxHeight(1400);

               Save.setOnAction(ActionEvent->{

            FileChooser fc = new FileChooser();

               FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("txt files",".txt");
            try {
                FileWriter fw = new FileWriter("ext");
                fw.write(textarea.getText());
                fw.close();
            }catch(Exception ex){
                System.out.println("Error");
            }

        });



          GridPane gp = new GridPane();
        gp.add(menubar,0,0);
            gp.add(textarea,0,1);
         Group gr = new Group();
        gr.getChildren().add(gp);
        Scene sc = new Scene(gr);
          Stage st = new Stage();
        st.setScene(sc);
            st.setMaxWidth(600);
        st.setMaxHeight(500);

        st.show();




    }
}
