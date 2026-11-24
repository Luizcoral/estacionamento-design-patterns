# Sistema de Estacionamento - Design Patterns

Aplicação Java desenvolvida para simular a gestão de vagas e cobrança de permanência em um estacionamento, aplicando os padrões de projeto comportamental **State** e estrutural **Decorator**.

Projeto desenvolvido como entrega da **Parte 1** da disciplina de Padrões de Projeto / Arquitetura de Software.

---

## 📋 Descrição do Sistema

O sistema gerencia o fluxo de entrada e saída de veículos em vagas de estacionamento sem o uso de banco de dados (persistência em memória). As principais funcionalidades compreendem:
- Controle do ciclo de vida das vagas de estacionamento utilizando o padrão **State** (ex.: vaga livre ou ocupada).
- Cálculo dinâmico do valor total da permanência utilizando o padrão **Decorator**, permitindo agregar serviços adicionais (como lavagem e seguro) à tarifa base de horas de permanência.

---

## 🛠️ Tecnologias e Pré-requisitos

- **Linguagem:** Java 17 (ou superior)
- **Gerenciador de Dependências e Build:** Apache Maven 3.8+
- **Paradigma:** Orientação a Objetos e Design Patterns (GoF)

---

## 🚀 Instruções de Execução

### Opção 1: Via Maven (Recomendado)

Na raiz do projeto, execute:
```bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn exec:java
```

### Opção 2: Via linha de comando (Java puro)

```bash
# Compilar
javac -d bin src/main/java/com/estacionamento/**/*.java

# Executar
java -cp bin com.estacionamento.Main
```

---

## 💡 Exemplos de Uso

Ao executar a aplicação:
1. Uma lista de vagas é inicializada (todas no estado `Livre`).
2. Um veículo dá entrada em uma vaga específica. A vaga transiciona seu estado para `Ocupada`.
3. Durante ou ao término da permanência, serviços opcionais (como `Lavagem` e `Seguro`) são decorados sobre a tarifa base.
4. Na saída do veículo, o sistema calcula o valor total, exibe o comprovante detalhado e a vaga transiciona de volta para o estado `Livre`.

---

## 🏗️ Patterns Utilizados

### 1. State (Comportamental)
- **Problema Resolvido:** Elimina estruturas condicionais extensas (`if/else` ou `switch`) para verificar e alterar o estado de uma vaga (ex.: impedir que uma vaga ocupada receba outro carro ou seja liberada duas vezes).
- **Classes Envolvidas:**
  - `EstadoVaga` (Interface): Contrato com as operações de transição (`ocupar`, `liberar`, `getNome`).
  - `VagaLivreState`: Permite a ocupação e transiciona a vaga para ocupada.
  - `VagaOcupadaState`: Rejeita nova ocupação e permite a liberação da vaga.
  - `Vaga`: Contexto que mantém a referência ao estado atual e delega o comportamento.

### 2. Decorator (Estrutural)
- **Problema Resolvido:** Permite compor dinamicamente funcionalidades e custos adicionais sobre a tarifa base de permanência em tempo de execução, evitando a explosão de subclasses combinatórias (ex.: `TarifaComLavagem`, `TarifaComSeguroELavagem`, etc.).
- **Classes Envolvidas:**
  - `ServicoPermanencia` (Component Interface): Define as operações `calcularValor()` e `getDescricao()`.
  - `TarifaBase` (Concrete Component): Implementação básica que calcula o valor com base nas horas de permanência.
  - `ServicoDecorator` (Decorator Base): Mantém a referência para outro `ServicoPermanencia`.
  - `LavagemDecorator`, `SeguroDecorator` (Concrete Decorators): Agregam valor e descrição ao serviço encapsulado.

---

## 🤖 Declaração de Uso de Inteligência Artificial

Em conformidade com as regras da Parte 1 da atividade:
- **Modelo utilizado:** Gemini (DeepMind) / ChatGPT.
- **Partes em que foi utilizada:** Auxílio na idealização arquitetural dos padrões, estruturação inicial do `pom.xml`, organização de boas práticas de documentação no `README.md` e validação do modelo conceitual de domínio.

---

## 👥 Contribuição dos Integrantes (Equipe Dona)

| Integrante | GitHub | Contribuição Principal |
|---|---|---|
| **Arthur Locks** | [@arthurlockss](https://github.com/arthurlockss) | Configuração do repositório, Maven (`pom.xml`), `.gitignore`, modelagem inicial das entidades de domínio (`Veiculo`, `Vaga`, `Permanencia`) e base do `README.md`. |
| *Integrante 2* | @usuario | Implementação do padrão **State** (`EstadoVaga`, `VagaLivreState`, `VagaOcupadaState`) e transições na classe `Vaga`. |
| *Integrante 3* | @usuario | Implementação do padrão **Decorator** (`ServicoPermanencia`, `TarifaBase`, `ServicoDecorator`, adicionais de serviço). |
| *Integrante 4* | @usuario | Implementação da classe executável `Main`, orquestração do fluxo ponta a ponta e testes de console. |
