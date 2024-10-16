public class DocumentProxy implements Document {

    private RealDocument realDocument;
    private String role;

    public DocumentProxy(RealDocument document, String role) {
        this.realDocument = document;
        this.role = role;
    }

    @Override
    public void getIntro() {
        realDocument.getIntro();
    }

    @Override
    public void getBody() {
        if (!role.equalsIgnoreCase("Regular User")) {
            realDocument.getBody();
        } else {
            System.out.println("Access Denied");
        }
    }

    @Override
    public void getConclusion() {
        if (!role.equalsIgnoreCase("Regular User") && !role.equalsIgnoreCase("Editor")) {
            realDocument.getConclusion();
        } else {
            System.out.println("Access denied");
        }
    }

}
