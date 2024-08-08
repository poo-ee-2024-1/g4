import java.util.List;
import java.util.ArrayList;

public class ProjetoDeInstalacaoEletrica {
    private static final double CUSTO_POR_METRO_FIO = 1.5; // Suponha que cada metro de fio custa 1,5 unidades monetáriasprivate List<Comodo> comodos;
    private List<Comodo> comodos;
    private List<Componente> componentes;


    public ProjetoDeInstalacaoEletrica() {
        this.comodos = new ArrayList<>();
        this.componentes = new ArrayList<>();
    }

    public void adicionarComodo(Comodo comodo) {
        this.comodos.add(comodo);
    }

    public void adicionarComponenteEletrico(Componente componenteEletrico) {
        this.componentes.add(componenteEletrico);
    }

    public int calcularQuantidadeDeFiosNecessarios() {
        int quantidadeDeFiosNecessarios = 0;
        for (Componente componenteEletrico : componentes) {
            quantidadeDeFiosNecessarios += componenteEletrico.getQuantidadeDeFiosNecessarios();
        }
        return quantidadeDeFiosNecessarios;
    }
     public List<Comodo> getComodos() {
        return comodos;
    }

    public double calcularCustoTotalDoProjeto() {
        double custoTotalDoProjeto = 0;

        // Calcular o custo dos componentes elétricos
        for (Componente componenteEletrico : componentes) {
            custoTotalDoProjeto += componenteEletrico.getCusto();
        }

        // Calcular o custo dos fios necessários
        int quantidadeDeFiosNecessarios = calcularQuantidadeDeFiosNecessarios();
        double custoDosFios = quantidadeDeFiosNecessarios * CUSTO_POR_METRO_FIO;

        // Somar o custo dos fios ao custo total do projeto
        custoTotalDoProjeto += custoDosFios;

        return custoTotalDoProjeto;
    }
}
erá necessário " + quantidadeDePontos + " pontos de iluminação na área desejada.");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado do Cálculo");
            alert.setHeaderText(null);
            alert.setContentText(resultadoLabel.getText());
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, insira valores válidos.");
            alert.showAndWait();
        }
    }
}
