public class Main {
    public static void main(String[] args) {

        RealDocument document1 = new RealDocument("Intro", "Body", "Conclusion");

        Document documentProxy = new DocumentProxy(document1, "admin");
        documentProxy.getIntro();
        documentProxy.getBody();
        documentProxy.getConclusion();

    }
}