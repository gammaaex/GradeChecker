package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.value_object.DetailScore;

/**
 * 成績を表現するイミュータブルなクラス
 */
public final class Exam extends AbstractEntity {

    /**
     * 点数
     */
    private final DetailScore detailScore;

    /**
     * コンストラクタ
     *
     * @param id    識別子
     * @param score 点数
     */
    public Exam(Integer id, DetailScore score) {
        super(id);

        if (score == null) throw new IllegalArgumentException();

        this.detailScore = score;
    }

    /**
     * @return get detailScore.
     */
    public DetailScore getDetailScore() {
        return detailScore;
    }
}
