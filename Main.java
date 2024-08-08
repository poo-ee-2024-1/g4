import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private UIController uiController;

    @Override
    public void start(Stage primaryStage) {
        uiController = new UIController();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Label labelNumComodos = new Label("Quantos cômodos deseja adicionar?");
        TextField textFieldNumComodos = new TextField();
        Button buttonAddComodos = new Button("Adicionar Cômodos");

        gridPane.add(labelNumComodos, 0, 0);
        gridPane.add(textFieldNumComodos, 1, 0);
        gridPane.add(buttonAddComodos, 2, 0);

        buttonAddComodos.setOnAction(event -> {
            int numComodos = Integer.parseInt(textFieldNumComodos.getText());
            uiController.handleAddComodos(numComodos);
        });

        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setTitle("Projeto de Instalação Elétrica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
