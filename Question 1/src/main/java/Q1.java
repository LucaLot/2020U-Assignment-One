//Luca Lotito, Chanuka Goonetilleke | March 1st 2020 | A program which randomly selects three cards to display
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Q1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Sets up the main pane used to display the program
        HBox pane = new HBox(3);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        //Selects the random numbers for the program, between 1 and 54
        Random rand = new Random();
        int[] r = new int[3];
        for(int i=0;i<3;i++) {
          r[i] = rand.nextInt(54)+1; //Selects the random number, and places it in an array
        }

        //Sets up the image views with every card
        Image image1 = new Image("Cards/"+r[0]+".png");
        ImageView v1 = new ImageView();
        v1.setImage(image1);
        Image image2 = new Image("Cards/"+r[1]+".png");
        ImageView v2 = new ImageView();
        v2.setImage(image2);
        Image image3 = new Image("Cards/"+r[2]+".png");
        ImageView v3 = new ImageView();
        v3.setImage(image3);

        pane.getChildren().addAll(v1,v2,v3); //Adds image views to the HBox

        //Sets up the stage to be displayed
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question one");
        primaryStage.show();
      }
    }
