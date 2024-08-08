# g4
Projeto do Grupo 4
# Instalações Elétricas Residenciais

## Seção 1 - Introdução

### 1.1 Justificativa
As instalações elétricas residenciais são fundamentais para garantir a segurança, funcionalidade e conforto em uma edificação. A realização de um projeto elétrico adequado é crucial para evitar problemas como curtos-circuitos, sobrecargas e falhas no fornecimento de energia.

### 1.2 Descrição do Problema
Muitos problemas nas instalações elétricas residenciais surgem devido à falta de um planejamento adequado, o que pode levar a riscos para os moradores e danos aos equipamentos elétricos.

### 1.3 Motivação
A motivação deste trabalho é promover um entendimento profundo sobre as normas e práticas recomendadas para instalações elétricas residenciais, visando a segurança e eficiência energética.

## Seção 2 - Plano

### 2.1 Objetivo Geral
Desenvolver um projeto detalhado de instalações elétricas residenciais que atenda às normas técnicas e proporcione segurança e eficiência.

### 2.2 Objetivos Específicos
- Estudar as normas NBR 5410 e NTC 04.
- Implementar cálculos para dimensionamento de pontos de iluminação e tomadas.
- Criar um aplicativo em JavaFX para auxiliar no dimensionamento de instalações elétricas.

## Seção 3 - Divisão de Tarefas

### 3.1 Tarefas (Issues)
1. **Pesquisa e Estudo de Normas**
    - Estudar a NBR 5410 e NTC 04.
    - Documentar os principais pontos dessas normas.
2. **Desenvolvimento do Aplicativo de Cálculo de Iluminação**
    - Implementar lógica para cálculo de iluminação em Java.
    - Desenvolver interface gráfica em JavaFX.
3. **Desenvolvimento do Aplicativo de Cálculo de Tomadas**
    - Implementar lógica para cálculo de tomadas em Java.
    - Desenvolver interface gráfica em JavaFX.
4. **Criação dos Diagramas**
    - Criar diagramas de classes e de sequência.
    - Elaborar casos de uso.

### 3.2 Atribuição de Tarefas
- **Estudo de Normas**: Saulo
- **Aplicativo de Cálculo de Iluminação**: Sofia
- **Aplicativo de Cálculo de Tomadas**: Sofia
- **Criação dos Diagramas**: Saulo


### 3.3 Prazos
- **Estudo de Normas**: 04/07/2024
- **Aplicativo de Cálculo de Iluminação**: 04/07/2024
- **Aplicativo de Cálculo de Tomadas**: 04/07/2024
- **Criação dos Diagramas**: 04/07/2024

## Seção 4 - Modelagem Inicial

### 4.1 Diagrama de Classes
```
+------------------------+
|      CalculoIluminacao |
+------------------------+
| + calcularTotalVA()    |
| + calcularQuantidade() |
+------------------------+

+------------------------+
|      CalculoTomadas    |
+------------------------+
| + calcularNumero()     |
+------------------------+

+------------------------+
|  CalcularIluminacaoApp |
+------------------------+
| + start()              |
+------------------------+

+------------------------+
| CalculadoraTomadasApp  |
+------------------------+
| + start()              |
+------------------------+
```
### 4.2 Diagrama de sequência

**Usuario** -> Aplicativo: Inserir dados (área, perímetro)

**Aplicativo** -> CalculoIluminacao: Calcular total VA e quantidade

**Aplicativo** -> CalculoTomadas: Calcular número de tomadas

**Aplicativo** -> Usuario: Mostrar resultado

### 4.3 Casos de Uso
- **Calcular Iluminação:** O usuário insere a área em metros quadrados e o sistema calcula a necessidade de iluminação em VA e a quantidade de pontos de iluminação.
- **Calcular Tomadas:** O usuário insere a área e o perímetro, e o sistema calcula o número de tomadas necessárias.
