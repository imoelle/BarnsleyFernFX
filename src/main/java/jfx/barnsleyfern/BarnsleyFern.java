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

    private final int WIDTH = 640;
    private final int HEIGHT = 480;

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
        for(int i = 0; i < 50; i++) {
            double rnd = ThreadLocalRandom.current().nextDouble();

            if (rnd <= 0.01) {
                xn = 0;
                yn = 0.16 * y;
            } else if (rnd <= 0.85) {
                xn = 0.85 * x + 0.004 * y;
                yn = -0.004 * x + 0.85 * y + 1.6;
            } else if (rnd <= 0.93) {
                xn = 0.2 * x - 0.26 * y;
                yn = 0.23 * x + 0.22 * y + 1.6;
            } else {
                xn = -0.15 * x + 0.28 * y;
                yn = 0.26 * x + 0.24 * y + 0.44;
            }

            x = xn;
            y = yn;

            drawPoint(stolenMap(x, -2.1820, 2.6558, 0,  WIDTH),
                    stolenMap(y, 0,  9.9983, HEIGHT,  0));
//            drawPoint(x, y);

        }

    }

    private void drawPoint(double x, double y) {
//        int width = (int)Math.round(WIDTH/2+x * WIDTH/12);
//        int height = (int)Math.round(HEIGHT-y * HEIGHT/12);
//        g.fillOval(width, height, 1, 1);
        g.fillOval(x, y, 1, 1);
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

//    private double stolenMap(double value, double iStart, double iStop, double oStart, double oStop) {
//        return oStart + (oStop - oStart) * ((value - iStart) / (iStop - iStart));
//    }

    static public final double stolenMap(double value,
                                  double start1, double stop1,
                                  double start2, double stop2) {
        double outgoing =
                start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
//        String badness = null;
//        if (outgoing != outgoing) {
//            badness = "NaN (not a number)";
//
//        } else if (outgoing == Float.NEGATIVE_INFINITY ||
//                outgoing == Float.POSITIVE_INFINITY) {
////            badness = "infinity";
//        }
//        if (badness != null) {
//            final String msg =
//                    String.format("map(%s, %s, %s, %s, %s) called, which returns %s",
//                            nf(value), nf(start1), nf(stop1),
//                            nf(start2), nf(stop2), badness);
//            PGraphics.showWarning(msg);
//        }
        return outgoing;
    }

}
