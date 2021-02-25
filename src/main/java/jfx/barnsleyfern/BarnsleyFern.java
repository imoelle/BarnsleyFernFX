package jfx.barnsleyfern;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class BarnsleyFern extends Application {

    private final int WIDTH = 1024;
    private final int HEIGHT = 768;

    private GraphicsContext g;

    private Scene scene = new Scene(createContent());

    double x = 0;
    double y = 0;

    AnimationTimer t = new AnimationTimer() {
        @Override
        public void handle(long now) {
            onUpdate();
        }
    };

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        g = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        return root;
    }

    private void onUpdate() {
        double xn, yn;
        for(int i = 0; i < 150; i++) {
            double rnd = ThreadLocalRandom.current().nextDouble();

            if (rnd <= 0.01) {
                xn = 0;
                yn = 0.16 * y;
                g.setFill(Color.rgb(134, 218, 118));
            } else if (rnd <= 0.08) {
                xn = 0.2 * x - 0.26 * y;
                yn = 0.23 * x + 0.22 * y + 1.6;
                g.setFill(Color.rgb(39, 81, 31));
            } else if (rnd <= 0.15) {
                xn = -0.15 * x + 0.28 * y;
                yn = 0.26 * x + 0.24 * y + 0.44;
                g.setFill(Color.rgb(42, 255, 0));
            } else {
                xn = 0.85 * x + 0.04 * y;
                yn = -0.04 * x + 0.85 * y + 1.6;
                g.setFill(Color.rgb(24, 143, 0));
            }

            x = xn;
            y = yn;

            drawPoint(x, y);
        }
    }

    private void drawPoint(double x, double y) {
        double width = scaleSize(x, -2.1820, 2.6558, 0,  WIDTH);
        double height = scaleSize(y, 0,  9.9983, HEIGHT,  0);
        g.fillOval(width, height, 1, 1);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Barnsley Fern FX");
        primaryStage.show();

        t.start();
    }

    private double scaleSize(double value, double iStart, double iStop, double oStart, double oStop) {
        return oStart + (oStop - oStart) * ((value - iStart) / (iStop - iStart));
    }
}
