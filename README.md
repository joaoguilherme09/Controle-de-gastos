# 💰 Controle de Gastos Pessoais (Java CLI)

Aplicação de linha de comando em Java para registrar, listar e analisar gastos pessoais, com persistência em arquivo.

## ✨ Funcionalidades

- Adicionar gastos (descrição, valor, categoria, data automática)
- Listar todos os gastos registrados
- Filtrar gastos por categoria
- Ver resumo: total geral e total por categoria
- Persistência automática em arquivo CSV (`expenses.csv`)

## 🛠️ Tecnologias e conceitos aplicados

- Java puro (sem dependências externas)
- Programação Orientada a Objetos (classes `Expense` e `ExpenseManager`)
- Coleções (`List`, `Map`) e Streams API
- Manipulação de arquivos (leitura/escrita com `java.nio.file`)
- Tratamento de exceções

## 📁 Estrutura do projeto

```
src/
├── Main.java             # Interface de linha de comando (menu)
├── Expense.java          # Modelo de dados de um gasto
└── ExpenseManager.java   # Lógica de negócio e persistência
```

## ▶️ Como executar

Pré-requisito: JDK 17 ou superior instalado.

```bash
# Clone o repositório
git clone <url-do-seu-repo>
cd expense-tracker

# Compile
cd src
javac *.java

# Execute
java Main
```

Os dados ficam salvos automaticamente em `expenses.csv` na pasta onde o programa é executado.

## 📸 Exemplo de uso

```
=== Controle de Gastos Pessoais ===

1. Adicionar gasto
2. Listar todos os gastos
3. Filtrar por categoria
4. Ver resumo (total e por categoria)
0. Sair
Escolha uma opção: 1
Descrição: Almoço
Valor (R$): 32,50
Categoria (ex: Alimentação, Transporte, Lazer): Alimentação
✅ Gasto adicionado!
```

## 🚀 Possíveis melhorias futuras

- Migrar persistência para banco de dados (SQLite/H2)
- Adicionar edição e remoção de gastos
- Exportar relatório em PDF
- Interface gráfica com JavaFX
