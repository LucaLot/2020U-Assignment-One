//Luca Lotito, Chanuka Goonetilleke | March 1st 2020 | A program which through values inserted
//into text boxes, calculates the future value of an investment
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.lang.Math;
import java.lang.NumberFormatException;


public class Q2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Sets up the pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.BASELINE_LEFT);
        pane.setPadding(new Insets(10,10,10,10));

        //Sets up the Label and TextField information
        pane.add(new Label("Investment Amount") ,0,0);
        TextField invest = new TextField();
        pane.add(invest, 1,0);
        pane.add(new Label("Years"), 0 , 1);
        TextField years = new TextField();
        pane.add(years, 1 ,1);
        pane.add(new Label("Annual Interest Rate"), 0 , 2);
        TextField rate = new TextField();
        pane.add(rate, 1 ,2);
        pane.add(new Label("Future Value"), 0 , 4);
        TextField result = new TextField();
        //So only the system can make a change, to future value, not the user
        result.setDisable(true);
        pane.add(result, 1 ,4);
        Button btAdd = new Button("Calculate");
        pane.add(btAdd, 1,5);

        GridPane.setHalignment(btAdd, HPos.RIGHT);

        //Sets up the stage to display the GUI
        Scene scene = new Scene(pane, 335,160);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question 2");
        primaryStage.show();
        //When the button is pressed, info is taken from all user editable fields
        //in order to calculate the future value
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
              try{
              double in = Double.parseDouble(invest.getText());
              double ye = Double.parseDouble(years.getText());
              double ra = Double.parseDouble(rate.getText())/100;
              result.setText(String.valueOf(in*Math.pow((1+ra/12),(ye*12))));
              }
              catch(NumberFormatException q){
                invest.clear();
                years.clear();
                rate.clear();
                result.setText("Try entering numbers");
              }
            }
        });
    }
}
