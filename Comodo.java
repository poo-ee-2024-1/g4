import java.util.ArrayList;
import java.util.List;

public class Comodo {
    private String nome;
    private double largura;
    private double comprimento;
    private int quantidadeJanelas;
    private int quantidadePortas;
    private List<Componente> componentes;
    private double area;

    public Comodo(String nome, double largura, double comprimento, int quantidadeJanelas, int quantidadePortas) {
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
        this.quantidadeJanelas = quantidadeJanelas;
        this.quantidadePortas = quantidadePortas;
        this.componentes = new ArrayList<>();
        this.area = largura * comprimento;
    }

    public String getNome() {
        return nome;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public int getQuantidadeJanelas() {
        return quantidadeJanelas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public List<Componente> getComponente() {
        return componentes;
    }

    public void addComponente(Componente componente) {
        this.componentes.add(componente);
    }
    public double getArea(){
        return area;
    }
    
}
