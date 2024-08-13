import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private ProjetoDeInstalacaoEletrica projeto;
    private CalculadoraDePontosDeTomada calculadora;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Criar um novo projeto de instalação elétrica
        projeto = new ProjetoDeInstalacaoEletrica();
        calculadora = new CalculadoraDePontosDeTomada();

        // Criar um painel de grade para organizar os elementos da interface
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Criar os elementos da interface
        Label labelNumComodos = new Label("Quantos cômodos deseja adicionar?");
        TextField textFieldNumComodos = new TextField();
        Button buttonAddComodos = new Button("Adicionar Cômodos");

        // Adicionar os elementos ao painel de grade
        gridPane.add(labelNumComodos, 0, 0);
        gridPane.add(textFieldNumComodos, 1, 0);
        gridPane.add(buttonAddComodos, 2, 0);

        // Definir a ação do botão "Adicionar Cômodos"
        buttonAddComodos.setOnAction(event -> {
            int numComodos = Integer.parseInt(textFieldNumComodos.getText());

            for (int i = 0; i < numComodos; i++) {
                // Criar uma janela de diálogo para obter os detalhes do cômodo
                Dialog<Comodo> dialog = new Dialog<>();
                dialog.setTitle("Adicionar Cômodo");
                dialog.setHeaderText("Digite os detalhes do cômodo:");

                // Criar os campos de entrada para os detalhes do cômodo
                TextField textFieldNomeComodo = new TextField();
                TextField textFieldLarguraComodo = new TextField();
                TextField textFieldComprimentoComodo = new TextField();
                TextField textFieldQuantidadeJanelasComodo = new TextField();
                TextField textFieldQuantidadePortasComodo = new TextField();

                // Adicionar os campos de entrada ao diálogo
                GridPane dialogGridPane = new GridPane();
                dialogGridPane.setHgap(10);
                dialogGridPane.setVgap(10);
                dialogGridPane.setPadding(new Insets(10));
                dialogGridPane.addRow(0, new Label("Nome do Cômodo:"), textFieldNomeComodo);
                dialogGridPane.addRow(1, new Label("Largura do Cômodo:"), textFieldLarguraComodo);
                dialogGridPane.addRow(2, new Label("Comprimento do Cômodo:"), textFieldComprimentoComodo);
                dialogGridPane.addRow(3, new Label("Quantidade de Janelas do Cômodo:"), textFieldQuantidadeJanelasComodo);
                dialogGridPane.addRow(4, new Label("Quantidade de Portas do Cômodo:"), textFieldQuantidadePortasComodo);

                dialog.getDialogPane().setContent(dialogGridPane);

                // Adicionar os botões "OK" e "Cancelar" ao diálogo
                ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
                dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, buttonTypeCancel);

                // Converter os dados do diálogo em um objeto Comodo
                dialog.setResultConverter(dialogButton -> {
                    if (dialogButton == buttonTypeOk) {
                        String nomeComodo = textFieldNomeComodo.getText();
                        double larguraComodo = Double.parseDouble(textFieldLarguraComodo.getText());
                        double comprimentoComodo = Double.parseDouble(textFieldComprimentoComodo.getText());
                        int quantidadeJanelasComodo = Integer.parseInt(textFieldQuantidadeJanelasComodo.getText());
                        int quantidadePortasComodo = Integer.parseInt(textFieldQuantidadePortasComodo.getText());

                        return new Comodo(nomeComodo, larguraComodo, comprimentoComodo, quantidadeJanelasComodo, quantidadePortasComodo);
                    }

                    return null;
                });

                // Exibir o diálogo e adicionar o cômodo ao projeto
                Comodo comodo = dialog.showAndWait().orElse(null);
                if (comodo != null) {
                    projeto.adicionarComodo(comodo);
                }
            }

            // Calcular a quantidade total de tomadas para todos os cômodos
            int totalPontosDeTomada = 0;
            for (Comodo comodo : projeto.getComodos()) {
                totalPontosDeTomada += calculadora.calcularPontosDeTomada(comodo);
            }

            // Calcular a quantidade total de fios necessários
            int quantidadeDeFiosNecessarios = projeto.calcularQuantidadeDeFiosNecessarios();

            // Calcular o custo total do projeto
            double custoTotalDoProjeto = projeto.calcularCustoTotalDoProjeto();

            // Exibir os resultados em uma janela de alerta
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultados");
            alert.setHeaderText(null);
            alert.setContentText("Quantidade total de tomadas: " + totalPontosDeTomada +
                    "\nQuantidade de fios necessários: " + quantidadeDeFiosNecessarios +
                    "\nCusto total do projeto: " + custoTotalDoProjeto);
            alert.showAndWait();
        });

        // Criar a cena e exibir a janela principal
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setTitle("Projeto de Instalação Elétrica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
