import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final ExpenseManager manager = new ExpenseManager("expenses.csv");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=== Controle de Gastos Pessoais ===");


        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1" -> addExpense();
                case "2" -> listExpenses();
                case "3" -> filterByCategory();
                case "4" -> showSummary();
                case "0" -> {
                    running = false;
                    System.out.println("Até mais! 👋");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Adicionar gasto");
        System.out.println("2. Listar todos os gastos");
        System.out.println("3. Filtrar por categoria");
        System.out.println("4. Ver resumo (total e por categoria)");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void addExpense() {
        System.out.print("Descrição: ");
        String description = scanner.nextLine();

        double amount;
        while (true) {
            System.out.print("Valor (R$): ");
            try {
                amount = Double.parseDouble(scanner.nextLine().replace(",", "."));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, tente novamente.");
            }
        }

        System.out.print("Categoria (ex: Alimentação, Transporte, Lazer): ");
        String category = scanner.nextLine();

        manager.addExpense(new Expense(description, amount, category, LocalDate.now()));
        System.out.println("✅ Gasto adicionado!");
    }

    private static void listExpenses() {
        if (manager.getAll().isEmpty()) {
            System.out.println("Nenhum gasto registrado ainda.");
            return;
        }
        manager.getAll().forEach(System.out::println);
    }

    private static void filterByCategory() {
        System.out.print("Digite a categoria: ");
        String category = scanner.nextLine();
        var filtered = manager.filterByCategory(category);

        if (filtered.isEmpty()) {
            System.out.println("Nenhum gasto encontrado nessa categoria.");
        } else {
            filtered.forEach(System.out::println);
        }
    }

    private static void showSummary() {
        System.out.printf("%nTotal gasto: R$ %.2f%n", manager.getTotal());
        System.out.println("Por categoria:");

        Map<String, Double> byCategory = manager.getTotalByCategory();
        byCategory.forEach((cat, total) -> System.out.printf("  - %-15s R$ %.2f%n", cat, total));
    }
}
