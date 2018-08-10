package gammaaex.domain.service.utility;


/**
 * 引数を解析するクラス
 */
public class ArgumentValidatorService {

    /**
     * コマンドライン引数が1つのアプリケーションのための検証メソッド
     * 引数が2つ以上あった場合にエラー終了する。
     *
     * @param arguments コマンドライン引数
     */
    public Boolean validateForOne(String[] arguments) {
        if (arguments.length >= 2) {
            return false;
        }
        return true;
    }

    /**
     * コマンドライン引数が複数のアプリケーションのための検証メソッド
     * 引数がなかった場合にエラー終了する。
     *
     * @param arguments コマンドライン引数
     */
    public Boolean validateForMany(String[] arguments) {
        if (arguments.length == 0) {
            return false;
        }
        return true;
    }

    /**
     * コマンドライン引数が複数のアプリケーションのための検証メソッド
     * 引数が指定された数と一致しなかった場合にエラー終了する。
     *
     * @param arguments コマンドライン引数
     * @param length    検証したい引数の数
     */
    public Boolean validateForMany(String[] arguments, Integer length) {
        if (arguments.length == length) {
            return false;
        }
        return true;
    }
}
