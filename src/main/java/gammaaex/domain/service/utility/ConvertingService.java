package gammaaex.domain.service.utility;

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

    /**
     * Stringの配列をIntegerの配列に変換する。
     *
     * @param stringArray 変換元のString配列
     * @return 変換後のInteger配列
     */
    public Integer[] convertArrayToArray(String[] stringArray) {
        Integer[] integerArray = new Integer[stringArray.length];

        for (Integer index = 0; index < stringArray.length; index++) {
            try {
                integerArray[index] = Integer.parseInt(stringArray[index]);
            } catch (NumberFormatException numberFormatException) {
                integerArray[index] = null;
            }
        }

        return integerArray;
    }
}
