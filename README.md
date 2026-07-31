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

