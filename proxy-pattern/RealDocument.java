public class RealDocument implements Document {

    private String introduction;
    private String body;
    private String conclusion;

    public RealDocument(String introduction, String body,
            String conclusion) {
        this.introduction = introduction;
        this.body = body;
        this.conclusion = conclusion;
    }

    @Override
    public void getIntro() {
        System.out.println(introduction);
    }

    @Override
    public void getBody() {
        System.out.println(body);
    }

    @Override
    public void getConclusion() {
        System.out.println(conclusion);
    }

}