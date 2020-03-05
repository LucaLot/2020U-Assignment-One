package sample;

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

public class DisplayThreeCards extends Application {
    Random random = new Random();
    int num = random.nextInt(54)+1;
    String str1 = Integer.toString(num);

    Random random2 = new Random();
    int num2 = random.nextInt(54)+1;
    String str2 = Integer.toString(num2);

    Random random3 = new Random();
    int num3 = random3.nextInt(54)+1;
    String str3 = Integer.toString(num3);
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Question 1");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5,5,5,5));

        Image image = new Image("/Cards/"+str1+".png");
        Image image2 = new Image("/Cards/"+str2+".png");
        Image image3 = new Image("/Cards/"+str3+".png");

        ImageView imageView1 = new ImageView(image);

        ImageView imageView2 = new ImageView(image2);

        ImageView imageView3 = new ImageView(image3);

        pane.getChildren().addAll(imageView1,imageView2,imageView3);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


}
