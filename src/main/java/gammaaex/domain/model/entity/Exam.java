package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.value_object.ExamScore;

/**
 * 成績を表現するイミュータブルなクラス
 */
public final class Exam extends AbstractEntity {

    /**
     * 点数
     */
    private final ExamScore score;

    /**
     * コンストラクタ
     *
     * @param id    識別子
     * @param score 点数
     */
    public Exam(Integer id, ExamScore score) {
        super(id);
        this.score = score;
    }

    /**
     * @return get score.
     */
    public ExamScore getScore() {
        return score;
    }
}
