//Luca Lotito | March 1st 2020 | A program which displays a circle and three points,
//allowing for dynamic movement of the points on the circle
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import java.lang.Math;


public class Q3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Setting up the pane, circles for the points and main one
        Pane pane = new Pane();
        Circle main = new Circle(200,200,100);
        main.setFill(Color.TRANSPARENT);
        main.setStroke(Color.BLACK);
        Circle one = new Circle(200,100,10);
        Circle two = new Circle(200,300,10);
        Circle three = new Circle(300,200,10);

        triangle(one, two, three, pane); //Sends the points and pane to the tringle method, to create it
        pane.getChildren().addAll(main, one, two, three); //Adds the main circle with the three points on the pane
        createAngles(pane, one, two, three); //Calculates the angles

        //Whenever the mouse is triggered on the pane, checks to see if the points can be moved
        pane.setOnMouseDragged(e ->{
          pane.getChildren().clear();
          double radius = main.getRadius();
          //Calculates to see if the mouse pointer is within trigger range of the circle radius
          double test = Math.sqrt(Math.pow(e.getX()-main.getCenterX(),2)+Math.pow(e.getY()-main.getCenterY(),2));
          //If the first point is triggered
          if(one.contains(e.getX(), e.getY())){
            //If the test value is within 5 of the circle's radius, the point can be moved.
            //It's finicky, but works for the required purposes
            if(radius+5>=test&&radius-5<=test){
              //If condition passes, the point is moved to the new location
              one.setCenterX(e.getX());
              one.setCenterY(e.getY());
            }
          }
          //If the second point is triggered, identical to the first
          else if(two.contains(e.getX(), e.getY())){
            if(radius+5>=test&&radius-5<=test){
              two.setCenterX(e.getX());
              two.setCenterY(e.getY());
            }
          }
          //If the third point is triggered, identical to the first
          else if(three.contains(e.getX(), e.getY())){
            if(radius+5>=test&&radius-5<=test){
              three.setCenterX(e.getX());
              three.setCenterY(e.getY());
            }
          }
          triangle(one,two,three,pane); //Reforms the triangle
          pane.getChildren().addAll(main, one, two, three);
          createAngles(pane, one, two, three); //Forms the new angle calculations
        });

        //Creates the stage
        Scene scene = new Scene(pane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Function which calculates the angles inside the triangle
     * @param  a Side length in the triangle. The angle opposite to it is calculated
     * @param  b Side length in the triangle
     * @param  c Side length in the triangle
     * @return   Double, the degree of calculated angle
     */
    public double angle(Double a, Double b, Double c){
      return Math.toDegrees(Math.acos(((a*a) - ((b*b) + (c*c)))/(-2*c*b)));
    }
    /**
     * Forms a Triangle based on the points
     * @param a    Circle representing a point
     * @param b    Circle representing a point
     * @param c    Circle representing a point
     * @param pane Pane where all objects are placed
     */
    public void triangle(Circle a, Circle b, Circle c, Pane pane){
      Polygon triangle = new Polygon();
      triangle.getPoints().addAll(a.getCenterX(),a.getCenterY(),b.getCenterX(),
                                  b.getCenterY(),c.getCenterX(),c.getCenterY());
      triangle.setFill(Color.WHITE);
      triangle.setStroke(Color.BLACK);
      pane.getChildren().add(triangle);
    }
    /**
     * Calculates the side lengths of the triangle, and places the labels of the angle values
     * @param pane Pane where all objects are placed
     * @param a    Circle representing a point
     * @param b    Circle representing a point
     * @param c    Circle representing a point
     */
    public void createAngles(Pane pane, Circle a, Circle b, Circle c){
      //Calculates the andle length based on pythagorean's therom
      double sideA = Math.sqrt(Math.pow(c.getCenterX()-b.getCenterX(),2) + Math.pow(c.getCenterY()-b.getCenterY(),2));
      double sideB = Math.sqrt(Math.pow(a.getCenterX()-c.getCenterX(),2) + Math.pow(a.getCenterY()-c.getCenterY(),2));
      double sideC = Math.sqrt(Math.pow(b.getCenterX()-a.getCenterX(),2) + Math.pow(b.getCenterY()-a.getCenterY(),2));
      //Places the labels of each angle value
      pane.getChildren().add(new Text(a.getCenterX(), a.getCenterY()-7, String.valueOf(angle(sideA, sideB, sideC))));
      pane.getChildren().add(new Text(b.getCenterX(), b.getCenterY()-7, String.valueOf(angle(sideB, sideA, sideC))));
      pane.getChildren().add(new Text(c.getCenterX(), c.getCenterY()-7, String.valueOf(angle(sideC, sideB, sideA))));

    }
}
