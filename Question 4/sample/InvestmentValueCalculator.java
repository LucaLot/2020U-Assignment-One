package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestmentValueCalculator extends Application {

    TextField investmentAmountField = new TextField();
    TextField yearsField = new TextField();
    TextField annualInterestRateField = new TextField();
    TextField futureValueField = new TextField();
    Button calculate = new Button("Calculate");

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Question 2");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

        GridPane gridpane = new GridPane();
        gridpane.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        gridpane.setVgap(10); //vertical gap in pixels
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.add(investmentAmountField, 2, 0); // column=1 row=0
        gridpane.add(new Label("Investment Amount"), 1, 0);  // column=2 row=0
        gridpane.add(yearsField, 2, 1);
        gridpane.add(new Label("Years"), 1, 1);
        gridpane.add(annualInterestRateField, 2, 2);
        gridpane.add(new Label("Annual Interest Rate"), 1, 2);
        gridpane.add(futureValueField, 2, 3);
        gridpane.add(new Label("Future Value"), 1, 3);
        gridpane.add(calculate,2,4);

        Scene scene = new Scene(gridpane);
        stage.setScene(scene);
        stage.show();

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                float investmentAmount = Float.valueOf(investmentAmountField.getText());
                float years = Float.valueOf(yearsField.getText());
                float annualInterestRate = Float.valueOf(annualInterestRateField.getText());
                float monthlyInterestRate = annualInterestRate/12f;

                float futureValue = investmentAmount * ((float)Math.pow((1f +(monthlyInterestRate/100)),(years*12)));

                futureValueField.setText(Float.toString(futureValue));
            }
        });
    }


}
