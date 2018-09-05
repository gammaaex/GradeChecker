package gammaaex;

public enum Option {

    /**
     * 成績のオプション
     */
    EXAM("exam"),

    /**
     * 課題のオプション
     */
    ASSIGNMENTS("assignments"),

    /**
     * 小テストのオプション
     */
    MINIEXAM("miniexam");


    /**
     * Optionの文字列表現
     */
    private final String text;

    /**
     * オプション接頭辞
     */
    public static final String prefix = "-";

    /**
     * コンストラクタ
     *
     * @param text Gradeのテキスト
     */
    Option(String text) {
        this.text = text;
    }

    /**
     * @return get text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * @return オプションをオプション接頭辞付きで取得する。
     */
    public String getTextWithPrefix() {
        return prefix + this.text;
    }

    /**
     * オプションかどうかを判定する。
     *
     * @param name 判定したい文字列
     * @return 判定値
     */
    public static Boolean isOption(String name) {
        Boolean isOption = false;

        for (Option option : Option.values()) {
            if (option.getTextWithPrefix().equals(name)) {
                isOption = true;
            }
        }

        return isOption;
    }

    /**
     * 文字列からオプションを取得する。
     *
     * @param name 検証したい文字列
     * @return null or Option
     */
    public static Option getByName(String name) {
        for (Option option : Option.values()) {
            if (option.getText().equals(name)) {
                return option;
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * プレフィックスを取り除く
     *
     * @param optionWithPrefix プレフィックス付きのオプション
     * @return プレフィックスを除いたオプション
     */
    public static String removePrefix(String optionWithPrefix) {
        return optionWithPrefix.substring(prefix.length(), optionWithPrefix.length());
    }
}
