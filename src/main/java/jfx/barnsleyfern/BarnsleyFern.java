package jfx.barnsleyfern;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class BarnsleyFern extends Application {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private GraphicsContext g;

    private Scene scene = new Scene(createContent());

    private int testX = 0;
    private int testY = 0;

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
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.fillRect(testX, testY, 10, 10);
        testX++;
        testY++;

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
