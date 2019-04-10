/*
In order to help learn course concpets, I worked on the homework with
Stephen Mock, Mai Vo, and Bryan Zhao, and consulted related material
that can be found at stackOverflow and programcreek.com.
 */

/*
THINGS TO FIX:
AFTER MAKING CIRCLES, DRAW NO LONGER WORKS.
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *INTRODUCING CS PAINT. A much worse version of MSPaint that still retains some of the classic
 * features, including:
 * - A terrible select tool(so bad it doesn't even exist!)
 * - Rectangles that don't snap to edges!
 * - A paintbrush that, for some god awful reason, has square corners!
 * - Layers? What the hell are layers?
 * - 650x450 fixed canvas (that's like, 0.6HD!!!!!)
 * @author William Chen
 * @version 1.0
 */
public class CSPaint extends Application {
    private static Color brushColor = Color.BLACK;
    private static boolean drawb = false;
    private static boolean eraseb = false;
    private static boolean circleb = false;
    private static boolean rectangleb = false;
    private static boolean circleBrush = false;
    private static boolean squareBrush = true;
    private static int originx;
    private static int originy;
    private static int numShapes = 0;
    private static double circRadius = 10;
    private static double brushRadius = 2;
    private static double eraseRadius = 10;
    private static String numShapesText = "Number of shapes: ";
    private static double redVal = 255;
    private static double greenVal = 255;
    private static double blueVal = 255;

    /**
     * a method used to set all booleans related to the radio buttons
     * in the menu to false, utilized in the next four methods.
     */
    public void allfalse() {
        drawb = false;
        eraseb = false;
        circleb = false;
        rectangleb = false;
    }

    /**
     * A method to set brushTypes to false so that one may be assigned true
     */
    public void brushFalse() {
        circleBrush = false;
        squareBrush = false;
    }

    /**
     * @param pxw A pixelwriter object from the GraphicsContext of the canvas
     * @param x x-location of the center of the square - radius (origin of rect is top left)
     * @param y y-location of the center of the square - radius (origin of rect is top left)
     * @param color Color enum to draw (Color.WHITE)
     * @param radius radius (1/2 of side length) of rectangle.
     */
    public void drawSquare(PixelWriter pxw, int x, int y, Color color, double radius) {
        //drawing with squares
        radius = (int) radius;
        for (int i = 0; i <= 2 * radius; i++) {
            for (int j = 0; j <= 2 * radius; j++) {
                pxw.setColor(x + i, y + j, color);
            }
        }
    }

    /**
     * This tool utilizes drawSquare and the fillOval method in graphicsContext to choose
     * between the circle and square brush types to draw with.
     * @param pxw A pixelWriter object from the GraphicsContext of the canvas
     * @param gc A GraphicsContext from the Canvas
     * @param relativeX the x-position
     * @param relativeY the y-position (x and y get complex but i'm too lazy to document atm)
     */
    public void drawFromBrush(PixelWriter pxw, GraphicsContext gc, int relativeX, int relativeY) {
        if (false) {
            drawSquare(pxw, relativeX, relativeY, brushColor, brushRadius);
        } else if (true) {
            gc.setFill(brushColor);
            gc.fillOval(relativeX, relativeY, brushRadius * 2, brushRadius * 2);
        }
    }

    /**
     * Updates the number of shapes to display in info
     * @param text the Text object we modify to show numbers. The only reason it's here is a scope issue
     */
    public void updateShapes(Text text) {
        numShapes++;
        text.setText(numShapesText + numShapes);
    }

    /**
     * The actual application method (start) that is overridden from javaFX
     * @param primaryStage main window to display
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CSPaint");

        VBox allBoxes = new VBox();
        HBox mainBox = new HBox();
        VBox toolBar = new VBox(10);
        toolBar.setPrefWidth(200);
        HBox info = new HBox(5);
        originx = (int) toolBar.getWidth();
        originy = 0;

        Color backgroundColor = Color.WHITE;
        //CURRENTLY JUST WHITE, CAN CHANGE LATER.
//        Scene canvasScene = new Scene(mainBox);
        final Canvas canvas = new Canvas(650, 450);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(backgroundColor);
        gc.fillRect(0, 0, 650, 450);
        PixelWriter pxw = gc.getPixelWriter();
        //DOES THIS WORK FOR SETTING NEW OBJECTS IN THE CANVAS

        //Toolbar fields
        ToggleGroup buttons = new ToggleGroup();
        RadioButton draw = new RadioButton("Draw");
        RadioButton erase = new RadioButton("Erase");
        RadioButton circle = new RadioButton("Circle");
        draw.setToggleGroup(buttons);
        erase.setToggleGroup(buttons);
        circle.setToggleGroup(buttons);
        TextField colorText = new TextField("Enter color");
        Button colorPicker = new Button("Color Picker");

        //Info fields
        Text position = new Text("(0,0)");
        Text shapesNumber = new Text("Number of shapes: ");

        //=============================Extra Features
        //Color picker:
        Slider red = new Slider(0, 255, 255);
        HBox redbox = new HBox(10);
        redbox.getChildren().addAll((new Label("Red: ")), red);
        Slider green = new Slider(0, 255, 255);
        HBox greenbox = new HBox(10);
        greenbox.getChildren().addAll((new Label("Green: ")), green);
        Slider blue = new Slider(0, 255, 255);
        HBox bluebox = new HBox(10);
        bluebox.getChildren().addAll((new Label("Blue: ")), blue);

            //text:
        Label redLabel = new Label("r: 255");
        Label greenLabel = new Label("g: 255");
        Label blueLabel = new Label("b: 255");
        VBox valLabels = new VBox(5, redLabel, greenLabel, blueLabel);

        HBox mainCPBox = new HBox(20);
        Rectangle sampleColor = new Rectangle(200, 200);
        sampleColor.setFill(Color.WHITE);
        VBox sliderBox = new VBox(15, redbox, greenbox, bluebox, valLabels);
        greenbox.setAlignment(Pos.CENTER);
        bluebox.setAlignment(Pos.BOTTOM_CENTER);
        mainCPBox.getChildren().addAll(sliderBox, sampleColor);

        Stage colorWindow = new Stage();
        colorWindow.setScene(new Scene(mainCPBox));
        colorWindow.setTitle("Pick a color");

        //Brush size setter:
        Slider brushSize = new Slider(1, 40, 2);
        brushSize.setBlockIncrement(1);
        brushSize.setShowTickMarks(true);

        Slider eraseSize = new Slider(1, 60, 10);
        eraseSize.setBlockIncrement(1);
        eraseSize.setShowTickMarks(true);

        //In progress
        Button clearCanvas = new Button("Clear Canvas");
        RadioButton rectangle = new RadioButton("Rectangle");
        rectangle.setToggleGroup(buttons);
        //Something that saves the canvas as an image. (can the TAs even check this?)
        // this shape will be a drag and release shape.
        /*
        For the brush:
         */

        info.getChildren().addAll(position, shapesNumber);
        VBox brushSetter = new VBox(5);
        HBox brushSliderStuff = new HBox(new Label("1 "), brushSize, new Label("40"));
        brushSetter.getChildren().addAll(new Label("Brush Radius: "), brushSliderStuff);

        VBox eraseSetter = new VBox(5);
        HBox eraseSliderStuff = new HBox(new Label("1 "), eraseSize, new Label("60"));
        eraseSetter.getChildren().addAll(new Label("Eraser Radius: "), eraseSliderStuff);

        toolBar.getChildren().addAll(draw, erase, circle, rectangle, colorText, brushSetter,
                eraseSetter, colorPicker, clearCanvas);
        clearCanvas.setAlignment(Pos.BOTTOM_LEFT);
        mainBox.getChildren().addAll(toolBar, canvas);
        allBoxes.getChildren().addAll(mainBox, info);

//============================ Handling: ================================
        //All the buttons:
        draw.setOnAction(e -> {
                allfalse();
                drawb = true;
            }
        );
        erase.setOnAction(e -> {
                allfalse();
                eraseb = true;
            }
        );
        circle.setOnAction(e -> {
                allfalse();
                circleb = true;
            }
        );
        rectangle.setOnAction(e -> {
                allfalse();
                rectangleb = true;
            }
        );
        //==================== BRUSH/ERASER SIZE SLIDER =========================
        brushSize.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    brushRadius = brushSize.getValue();
                }
            }
        );

        eraseSize.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    eraseRadius = eraseSize.getValue();
                }
            }
        );

        //=================== COLOR PICKER WINDOW =========================
        colorPicker.setOnAction(e -> {
                colorWindow.show();
                red.valueProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observableValue,
                                            Number number, Number t1) {
                            redVal = red.getValue();
                            brushColor = Color.rgb((int) redVal, (int) greenVal, (int) blueVal);
                            sampleColor.setFill(brushColor);
                            redLabel.setText(String.format("r: %.2f", redVal));
                        }
                    }
                );
                green.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                            greenVal = green.getValue();
                            brushColor = Color.rgb((int) redVal, (int) greenVal, (int) blueVal);
                            sampleColor.setFill(brushColor);
                            greenLabel.setText(String.format("g: %.2f", greenVal));
                        }
                    }
                );
                blue.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                            blueVal = blue.getValue();
                            brushColor = Color.rgb((int) redVal, (int) greenVal, (int) blueVal);
                            sampleColor.setFill(brushColor);
                            blueLabel.setText(String.format("b: %.2f", blueVal));
                        }
                    }
                );
            }
        );
        //=============Setting brushColor from the text box.===============
        colorText.setOnAction(e -> {
                String text = colorText.getText();
                try {
                    brushColor = Color.valueOf(text);
                } catch (IllegalArgumentException iae) {
                    Alert badColor = new Alert(Alert.AlertType.ERROR,
                            "Invalid color! Valid colors look like this: \n"
                                    + "'White', 'White Smoke', '6A5ACD'(any hex key)\n"
                                    + "A list of valid colors can be found at:\n"
                                    + "https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html");
                    badColor.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                colorText.setText("Enter another color");
                                badColor.close();
                            }
                        }
                    );
                    System.out.println(iae.getMessage());
                }
            }
        );

        //========================= CLEAR CANVAS ===========================
        clearCanvas.setOnAction(e -> {
                gc.setFill(backgroundColor);
                gc.fillRect(0, 0, 650, 450);
                numShapes = -1;
                updateShapes(shapesNumber);
            }
        );
        //======================== MOUSE TRACKER ===========================
        canvas.setOnMouseMoved(e -> {
                double relativeX = e.getX() - originx;
                double relativeY = e.getY() - originy;
                String pos = String.format("( %.1f, %.1f )", relativeX, relativeY);
                position.setText(pos);
            }
        );
        //==================== SUPER COMPLEX SHIT ==========================
        //Action events for the canvas: What actually allows painting
        //INITIAL ON PRESS
        canvas.setOnMousePressed(e -> {
                if (rectangleb) {
                    //NOTE THAT RECTANGLE WILL BE ADDED AS NODE TO MAINBOX, DO NOT NEED RELATIVE COORDS.
                    double xInit = e.getX();
                    double yInit = e.getY();
                    Rectangle newRectangle = new Rectangle(xInit, yInit, 1, 1);
                    mainBox.getChildren().addAll(newRectangle);
                    //CAN I DO THAT? EVENTS IN EVENTS?
                    canvas.setOnMouseDragged(d -> {
                            double xMid = e.getX();
                            double yMid = e.getY();
                            newRectangle.setWidth(xMid - xInit);
                            newRectangle.setHeight(yMid - yInit);
                        }
                    );
                    canvas.setOnMouseReleased(f -> {
                            double xFinal = e.getX();
                            double yFinal = e.getY();
                            newRectangle.setWidth(xFinal - xInit);
                            newRectangle.setWidth(yFinal - yInit);
                            updateShapes(shapesNumber);
                            //HOW DO I ADD THIS RECTANGLE TO THE SCENE
                        }
                    );
                } else if (drawb) {
                    //PixelReader pr = canvas.getPixelReader();
                    int relativeX = (int) (e.getX() - originx - brushRadius);
                    int relativeY = (int) (e.getY() - originy - brushRadius);
                    gc.setFill(brushColor);
                    drawFromBrush(pxw, gc, relativeX, relativeY);
                } else if (circleb) {
                    int relativeX = (int) (e.getX() - originx - circRadius);
                    int relativeY = (int) (e.getY() - originy - circRadius);
                    //oval function to add circles
                    gc.setFill(brushColor);
                    gc.fillOval(relativeX, relativeY, 2 * circRadius, 2 * circRadius);
                    updateShapes(shapesNumber);
                } else if (eraseb) {
                    int relativeX = (int) (e.getX() - originx - eraseRadius);
                    int relativeY = (int) (e.getY() - originy - eraseRadius);
                    gc.setFill(backgroundColor);
                    gc.fillOval(relativeX, relativeY, 2 * eraseRadius, 2 * eraseRadius);
                }
            }
        );
        //THEN ON DRAG, but exclude rectangle, it was all handled following an onpressed.
        canvas.setOnMouseDragged(e -> {
                //use methods defined above for drawing each shape, and size
                int radius = 2;
                if (drawb) {
                    int relativeX = (int) (e.getX() - originx - brushRadius);
                    int relativeY = (int) (e.getY() - originy - brushRadius);
        //                drawSquare(pxw, relative_x, relative_y, brushColor, brushRadius);
                    gc.setFill(brushColor);
                    drawFromBrush(pxw, gc, relativeX, relativeY);
                    //USE PIXELWRITER?
                    //CAN I USE A BLANK WHITE IMAGE TO START ON THIS HW?
                    //IS IT A BAD IDEA TO JUST MAKE A MILLION CIRCLES? WOULDNT IT BE SUPER SLOW?
                    //HOW WOULD I COLOR PIXEL BY PIXEL IN A RADIUS, INSTEAD OF USING CIRCLES?
                } else if (eraseb) {
                    radius = 10;
                    int relativeX = (int) (e.getX() - originx - eraseRadius);
                    int relativeY = (int) (e.getY() - originy - eraseRadius);
                    gc.setFill(backgroundColor);
                    gc.fillOval(relativeX, relativeY, 2 * eraseRadius, 2 * eraseRadius);
                }
            }
        );
        //========================= FINAL SHIT =========================
        primaryStage.setScene(new Scene(allBoxes));
        primaryStage.show();
    }

    /**
     * main, all it's used for is launching javaFX
     * @param args any args from terminal to be used in the app.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
