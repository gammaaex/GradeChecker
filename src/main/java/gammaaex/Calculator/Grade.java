package gammaaex.Calculator;

public enum Grade {
    A("秀"),
    B("優"),
    C("良"),
    D("可"),
    E("不可"),
    K("K");

    private final String text;

    Grade(String text) {
        this.text = text;
    }

    /**
     * @return get text.
     */
    public String getText() {
        return this.text;
    }
}
