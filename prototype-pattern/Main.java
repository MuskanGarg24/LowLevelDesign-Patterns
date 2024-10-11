public class Main {
    public static void main(String[] args) {
        Document reportPrototype = new Report();
        Document letterPrototype = new Letter();
        Document invoicePrototype = new Invoice();

        Document clonedReport = reportPrototype.clone();
        Document clonedLetter = letterPrototype.clone();
        Document clonedInvoice = invoicePrototype.clone();

        clonedReport.display();
        clonedLetter.display();
        clonedInvoice.display();
    }
}