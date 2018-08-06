package gammaaex.value_object;

/**
 * 課題を表現するイミュータブルなクラス
 */
public class Assignments {

    /**
     * 識別子
     */
    public final Integer id;

    /**
     * 課題1の成績
     */
    public final Integer assignment1;

    /**
     * 課題2の成績
     */
    public final Integer assignment2;

    /**
     * 課題3の成績
     */
    public final Integer assignment3;

    /**
     * 課題4の成績
     */
    public final Integer assignment4;

    /**
     * 課題5の成績
     */
    public final Integer assignment5;

    /**
     * 課題6の成績
     */
    public final Integer assignment6;

    public Assignments(
            Integer id,
            Integer assignment1,
            Integer assignment2,
            Integer assignment3,
            Integer assignment4,
            Integer assignment5,
            Integer assignment6
    ) {
        this.id = id;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.assignment4 = assignment4;
        this.assignment5 = assignment5;
        this.assignment6 = assignment6;
    }
}
