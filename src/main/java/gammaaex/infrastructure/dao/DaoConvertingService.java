package gammaaex.infrastructure.dao;

public class DaoConvertingService {

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
            } catch (NumberFormatException e) {
                integerArray[index] = null;
            }
        }

        return integerArray;
    }

}
