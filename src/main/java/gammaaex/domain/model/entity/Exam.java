package gammaaex.domain.model.entity;

/**
 * 成績を表現するイミュータブルなクラス
 */
public final class Exam {

    /**
     * 識別子
     */
    private final Integer id;

    /**
     * 点数
     */
    private final Double point;

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

    /**
     * @return get id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return get point.
     */
    public Double getPoint() {
        return point;
    }
}
