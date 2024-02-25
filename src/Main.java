public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Ryu", 19, 120, 95, 45);
        Fighter f2 = new Fighter("Ken", 16, 140, 90, 80);

        Match match = new Match(f1, f2, 90, 100);
        match.run();
    }
}