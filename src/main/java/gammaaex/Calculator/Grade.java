package gammaaex.Calculator;

/**
 * 成績を表現するEnum
 */
public enum Grade {

    /**
     * 成績：秀
     */
    A("秀"),

    /**
     * 成績：優
     */
    B("優"),

    /**
     * 成績：良
     */
    C("良"),

    /**
     * 成績：可
     */
    D("可"),

    /**
     * 成績：不可
     */
    E("不可"),

    /**
     * 成績：K
     */
    K("K");

    /**
     * Gradeの文字列表現
     */
    private final String text;

    /**
     * コンストラクタ
     * @param text Gradeのテキスト
     */
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
