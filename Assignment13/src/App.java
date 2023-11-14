import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverterGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label inputLabel = new Label("Input:");
        GridPane.setConstraints(inputLabel, 0, 0);

        TextField inputField = new TextField();
        GridPane.setConstraints(inputField, 1, 0);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 2, 0);

        Label resultLabel = new Label("Result:");
        GridPane.setConstraints(resultLabel, 0, 1);

        Label resultField = new Label();
        GridPane.setConstraints(resultField, 1, 1);

        grid.getChildren().addAll(inputLabel, inputField, convertButton, resultLabel, resultField);

        convertButton.setOnAction(e -> {
            String input = inputField.getText();
            if (input.equalsIgnoreCase("exit") || input.equals("-1")) {
                primaryStage.close();
            } else {
                String result = convertInput(input);
                resultField.setText(result);
            }
        });

        Scene scene = new Scene(grid, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String convertInput(String input) {
        if (input.contains("km = m")) {
            String[] parts = input.split(" ");
            double value = Double.parseDouble(parts[0]);
            double meters = value * 1000;
            return value + " km = " + meters + " m";
        } else if (input.contains("kg = lb")) {
            String[] parts = input.split(" ");
            double value = Double.parseDouble(parts[0]);
            double pounds = value * 2.20462;
            return value + " kg = " + pounds + " lb";
        } else if (input.contains("hour = day")) {
            String[] parts = input.split(" ");
            double value = Double.parseDouble(parts[0]);
            double days = value / 24;
            return value + " hours = " + days + " days";
        } else {
            return "Invalid input. Please try again.";
        }
    }
}
