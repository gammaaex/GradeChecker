package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;

/**
 * 成績を表現するイミュータブルなクラス
 */
public final class Exam extends AbstractEntity {

    /**
     * 点数
     */
    private final Double score;

    /**
     * コンストラクタ
     *
     * @param id    識別子
     * @param score 点数
     */
    public Exam(Integer id, Double score) {
        super(id);
        this.score = score;
    }

    /**
     * @return get score.
     */
    public Double getScore() {
        return score;
    }
}
