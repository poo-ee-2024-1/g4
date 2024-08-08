public class CalculadoraDePontosDeTomada {
    public int calcularPontosDeTomada(Comodo comodo) {
        int pontosDeTomada = 0;
        
        // Comodos com área igual ou inferior a 6 metros quadrados temos no mínimo uma tomada
        if (comodo.getArea() <= 6) {
            pontosDeTomada = 1;
        } else {
            // Comodos com mais de 6 metros quadrados temos no mínimo uma tomada para cada 5m ou fração de perímetro
            double perimetro = calcularPerimetro(comodo);
            pontosDeTomada = (int) Math.ceil(perimetro / 5);
        }
        
        // Em cozinhas, copas e copas-cozinhas, temos uma tomada para cada 3,5 ou fração de perímetro, independente da área
        if (comodo.getNome().equals("Cozinha") || comodo.getNome().equals("Copa") || comodo.getNome().equals("Copa-Cozinha")) {
            double perimetro = calcularPerimetro(comodo);
            pontosDeTomada = (int) Math.ceil(perimetro / 3.5);
        }
        
        return pontosDeTomada;
    }
    
    private double calcularPerimetro(Comodo comodo) {
        // Suponho que o comodo tem um método getLargura() e getComprimento() que retorna a largura e comprimento do comodo
        double largura = comodo.getLargura();
        double comprimento = comodo.getComprimento();
        return 2 * (largura + comprimento);
    }
}

    private double calcularPerimetro(Comodo comodo) {
        // Suponho que o comodo tem um método getLargura() e getComprimento() que retorna a largura e comprimento do comodo
        double largura = comodo.getLargura();
        double comprimento = comodo.getComprimento();
        return 2 * (largura + comprimento);
    }
}
