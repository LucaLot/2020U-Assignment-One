package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //create text field
        TextField textField = new TextField();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Question 4");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

        StackPane pane = new StackPane();

        BorderPane borderPane = new BorderPane();

        //create label and put the label and the text feild in the bottom of the screen
        BorderPane bottom = new BorderPane();
        bottom.setLeft(new Label("Filename:   "));
        bottom.setCenter(textField);
        borderPane.setBottom(bottom);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();

        //when enter button is clicked
        textField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER))
                {
                    //close the previous stage
                    stage.close();

                    //create file
                    java.io.File file = new java.io.File(textField.getText());
                    String str = "";

                    //try and catch statement to create a Scanner object
                    Scanner input = null;
                    try {
                        input = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    //take input from scanner and store it in 'str'
                    while (input.hasNext()){
                        str += input.next();
                    }

                    input.close();


                    /*
                    line 87 to 103 creates a counter array and stores the number of currences of
                    each char in the string.
                     */
                    int counter[] = new int[256];

                    int len = str.length();

                    for (int i = 0; i < len; i++)
                        counter[str.charAt(i)]++;

                    char array[] = new char[str.length()];
                    for (int i = 0; i < len; i++) {
                        array[i] = str.charAt(i);
                        int flag = 0;
                        for (int j = 0; j <= i; j++) {

                            if (str.charAt(i) == array[j])
                                flag++;
                        }
                    }

                    //create histogram
                    final CategoryAxis xAxis = new CategoryAxis();
                    final NumberAxis yAxis = new NumberAxis();
                    final BarChart<String,Number> barChart =
                            new BarChart<>(xAxis,yAxis);
                    barChart.setCategoryGap(0);
                    barChart.setBarGap(0);

                    XYChart.Series series1 = new XYChart.Series();

                    series1.getData().add(new XYChart.Data("A", counter['a'] + counter['A']));
                    series1.getData().add(new XYChart.Data("B", counter['b'] + counter['B']));
                    series1.getData().add(new XYChart.Data("C", counter['c'] + counter['C']));
                    series1.getData().add(new XYChart.Data("D", counter['d'] + counter['D']));
                    series1.getData().add(new XYChart.Data("E",counter['e'] + counter['E']));
                    series1.getData().add(new XYChart.Data("F",counter['f'] + counter['F']));
                    series1.getData().add(new XYChart.Data("G",counter['g'] + counter['G']));
                    series1.getData().add(new XYChart.Data("H",counter['h'] + counter['H']));
                    series1.getData().add(new XYChart.Data("I",counter['i'] + counter['I']));
                    series1.getData().add(new XYChart.Data("J",counter['j'] + counter['J']));
                    series1.getData().add(new XYChart.Data("K",counter['k'] + counter['K']));
                    series1.getData().add(new XYChart.Data("L",counter['l'] + counter['L']));
                    series1.getData().add(new XYChart.Data("M",counter['m'] + counter['M']));
                    series1.getData().add(new XYChart.Data("N",counter['n'] + counter['N']));
                    series1.getData().add(new XYChart.Data("O",counter['o'] + counter['O']));
                    series1.getData().add(new XYChart.Data("P",counter['p'] + counter['P']));
                    series1.getData().add(new XYChart.Data("Q",counter['q'] + counter['Q']));
                    series1.getData().add(new XYChart.Data("R",counter['r'] + counter['R']));
                    series1.getData().add(new XYChart.Data("S",counter['s'] + counter['S']));
                    series1.getData().add(new XYChart.Data("T",counter['t'] + counter['T']));
                    series1.getData().add(new XYChart.Data("U",counter['u'] + counter['U']));
                    series1.getData().add(new XYChart.Data("V",counter['v'] + counter['V']));
                    series1.getData().add(new XYChart.Data("W",counter['w'] + counter['W']));
                    series1.getData().add(new XYChart.Data("X",counter['x'] + counter['X']));
                    series1.getData().add(new XYChart.Data("Y",counter['y'] + counter['Y']));
                    series1.getData().add(new XYChart.Data("Z",counter['z'] + counter['Z']));

                    barChart.setLegendVisible(false);
                    barChart.getYAxis().setTickLabelsVisible(false);

                    barChart.getData().addAll(series1);

                    pane.getChildren().addAll(barChart);

                    Scene scene = new Scene(pane,500,500);

                    stage.setScene(scene);
                    stage.show();
                }
            }
        });


    }
}
