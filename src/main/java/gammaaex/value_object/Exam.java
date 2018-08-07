package gammaaex.value_object;

/**
 * 成績を表現するイミュータブルなクラス
 */
public final class Exam {

    /**
     * 識別子
     */
    public final Integer id;

    /**
     * 点数
     */
    public final Double point;

    /**
     * コンストラクタ
     *
     * @param id    識別子
     * @param point 点数
     */
    public Exam(Integer id, Double point) {
        this.id = id;
        this.point = point;
    }
}
