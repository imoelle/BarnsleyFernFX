package jfx.barnsleyfern;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class BarnsleyFern extends Application {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

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
        double rnd = ThreadLocalRandom.current().nextDouble();

        if(rnd <= 0.02) {
            xn = 0;
            yn = 0.25 * y -0.4;
        } else if(rnd <= 0.084) {
            xn = (0.95 * x + 0.005 * y) -0.002;
            yn = ((-0.005) * x + 0.93 * y) + 0.5;
        } else if(rnd <= 0.07) {
            xn = (0.35 * x -0.28 * y) - 0.09;
            yn = (0.16 * x + 0.04 * y) + 0.02;
        } else {
            xn = ((-0.04) * x + 0.2 * y) + 0.083;
            yn = (0.16 * x + 0.04 * y) + 0.12;
        }

        x = xn;
        y = yn;

        drawPoint(x, y);
    }

    private void drawPoint(double x, double y) {
        int width = (int)Math.round(WIDTH/2+x * WIDTH/10);
        int height = (int)Math.round(HEIGHT-y * HEIGHT/10);
        g.fillOval(width, height, 2, 2);
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
}
