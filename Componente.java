public abstract class Componente {
    private String nome;
    private int quantidade;
    private double potencia;
    private double custo;
    private int QuantidadeDeFiosNecessarios;

    public Componente(String nome, int quantidade, double potencia) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.potencia = potencia;
    }

    public String getNome() { 
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPotencia() {

        return 0.0; // valor padrão, pode ser substituído pelas classes que herdam

    }
    public int getQuantidadeDeFiosNecessarios() {

        return QuantidadeDeFiosNecessarios;

    }


    public double getCusto() {

        return custo;

    }

}
