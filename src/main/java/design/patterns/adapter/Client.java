package design.patterns.adapter;

public class Client {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer printer = new PrinterAdapter(legacyPrinter);

        printer.print();
    }
}