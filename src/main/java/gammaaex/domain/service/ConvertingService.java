package gammaaex.domain.service;

/**
 * 変換を司るクラス
 */
public class ConvertingService {

    /**
     * コンストラクタ
     */
    public ConvertingService() {

    }

    /**
     * nullを整数値に変換する
     *
     * @param number Integerオブジェクト
     * @return nullでないIntegerオブジェクト
     */
    public Integer convertNullToInteger(Integer number) {
        return number == null ? 0 : number;
    }

    /**
     * nullを整数値に変換する
     *
     * @param number Doubleオブジェクト
     * @return nullでないDoubleオブジェクト
     */
    public Double convertNullToDouble(Double number) {
        return number == null ? 0.0 : number;
    }
}
