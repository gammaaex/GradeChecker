package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;

import java.util.Objects;

/**
 * 少数を含むような詳細な成績を表現するクラス
 */
public final class DetailScore extends AbstractValueObject {

    /**
     * テストの成績
     */
    private final Double score;

    /**
     * コンストラクタ
     *
     * @param score テストの成績
     */
    public DetailScore(Double score) {
        this.score = score;
    }

    /**
     * scoreを数値に変換して返す。
     *
     * @return 数値に変換されたscore
     */
    public Double getZeroOrScore() {
        return this.score == null ? 0 : this.score;
    }

    /**
     * scoreのオブジェクトをそのまま返す。
     *
     * @return scoreのオブジェクト
     */
    public Double getNullOrScore() {
        return this.score;
    }

    /**
     * scoreの値をStringで返す。
     *
     * @return scoreの値
     */
    public String getText() {
        return this.score == null
                ? Double.toString(0.000)
                : String.format("%.3f", this.score);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        DetailScore that = (DetailScore) object;

        if (!this.score.equals(that.score)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.score);
    }
}
