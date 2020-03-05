//Chanuka Goonetilleke, Luca Lotito | March 1st 2020 | A program which randomly selects three cards to display on each runtime, using FXML as a display base
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Q1 extends Application {
    //Sets up the random number generator, in order to select cards
    @Override
    public void start(Stage stage) throws Exception {
	//Sets up the main page and FXML in order to display the panel
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        stage.setTitle("Question 1");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
	
        //Selects the random numbers for the program, between 1 and 54
        Random rand = new Random();
        int[] r = new int[3];
        for(int i=0;i<3;i++) {
          r[i] = rand.nextInt(54)+1; //Selects the random number, and places it in an array
        }
	
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5,5,5,5));
	
        //Sets up the image views with every card
        Image image1 = new Image("Cards/"+r[0]+".png");
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        Image image2 = new Image("Cards/"+r[1]+".png");
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        Image image3 = new Image("Cards/"+r[2]+".png");
        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);

        pane.getChildren().addAll(imageView1,imageView2,imageView3);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


}
