package gammaaex.value_object;

/**
 * 小テストを表現するイミュータブルなクラス
 */
public class MiniExam {

    /**
     * 識別子
     */
    public final Integer id;

    /**
     * 第1回小テストの点数
     */
    public final Integer point1;

    /**
     * 第2回小テストの点数
     */
    public final Integer point2;

    /**
     * 第3回小テストの点数
     */
    public final Integer point3;

    /**
     * 第4回小テストの点数
     */
    public final Integer point4;

    /**
     * 第5回小テストの点数
     */
    public final Integer point5;

    /**
     * 第6回小テストの点数
     */
    public final Integer point6;

    /**
     * 第7回小テストの点数
     */
    public final Integer point7;

    /**
     * 第8回小テストの点数
     */
    public final Integer point8;

    /**
     * 第9回小テストの点数
     */
    public final Integer point9;

    /**
     * 第10回小テストの点数
     */
    public final Integer point10;

    /**
     * 第11回小テストの点数
     */
    public final Integer point11;

    /**
     * 第12回小テストの点数
     */
    public final Integer point12;

    /**
     * 第13回小テストの点数
     */
    public final Integer point13;

    /**
     * 第14回小テストの点数
     */
    public final Integer point14;

    public MiniExam(
            Integer id,
            Integer point1,
            Integer point2,
            Integer point3,
            Integer point4,
            Integer point5,
            Integer point6,
            Integer point7,
            Integer point8,
            Integer point9,
            Integer point10,
            Integer point11,
            Integer point12,
            Integer point13,
            Integer point14
    ) {
        this.id = id;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.point5 = point5;
        this.point6 = point6;
        this.point7 = point7;
        this.point8 = point8;
        this.point9 = point9;
        this.point10 = point10;
        this.point11 = point11;
        this.point12 = point12;
        this.point13 = point13;
        this.point14 = point14;
    }
}
