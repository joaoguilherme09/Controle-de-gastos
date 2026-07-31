import java.time.LocalDate;

public class Expense {
    private String description;
    private double amount;
    private String category;
    private LocalDate date;

    public Expense(String description, double amount, String category, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }

    // Formato usado para salvar/ler do arquivo CSV
    public String toCsv() {
        return description + ";" + amount + ";" + category + ";" + date;
    }

    public static Expense fromCsv(String line) {
        String[] parts = line.split(";");
        return new Expense(parts[0], Double.parseDouble(parts[1]), parts[2], LocalDate.parse(parts[3]));
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-15s | R$ %8.2f", date, description, category, amount);
    }
}
