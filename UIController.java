import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class UIController {
    private ProjetoDeInstalacaoEletrica projeto;
    private CalculadoraDePontosDeTomada calculadora;

    public UIController() {
        projeto = new ProjetoDeInstalacaoEletrica();
        calculadora = new CalculadoraDePontosDeTomada();
    }

    public void handleAddComodos(int numComodos) {
        for (int i = 0; i < numComodos; i++) {
            Comodo comodo = showComodoDialog();
            if (comodo != null) {
                projeto.adicionarComodo(comodo);
            }
        }

        int totalPontosDeTomada = 0;
        for (Comodo comodo : projeto.getComodos()) {
            totalPontosDeTomada += calculadora.calcularPontosDeTomada(comodo);
        }

        int quantidadeDeFiosNecessarios = projeto.calcularQuantidadeDeFiosNecessarios();
        double custoTotalDoProjeto = projeto.calcularCustoTotalDoProjeto();

        showResults(totalPontosDeTomada, quantidadeDeFiosNecessarios, custoTotalDoProjeto);
    }

    private Comodo showComodoDialog() {
        Dialog<Comodo> dialog = new Dialog<>();
        dialog.setTitle("Adicionar Cômodo");
        dialog.setHeaderText("Digite os detalhes do cômodo:");

        TextField textFieldNomeComodo = new TextField();
        TextField textFieldLarguraComodo = new TextField();
        TextField textFieldComprimentoComodo = new TextField();
        TextField textFieldQuantidadeJanelasComodo = new TextField();
        TextField textFieldQuantidadePortasComodo = new TextField();

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

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, buttonTypeCancel);

        return dialog.showAndWait().orElse(null);
    }

    private void showResults(int totalPontosDeTomada, int quantidadeDeFiosNecessarios, double custoTotalDoProjeto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultados");
        alert.setHeaderText(null);
        alert.setContentText("Quantidade total de tomadas: " + totalPontosDeTomada +
                "\nQuantidade de fios necessários: " + quantidadeDeFiosNecessarios +
                "\nCusto total do projeto: " + custoTotalDoProjeto);
        alert.showAndWait();
    }
}
