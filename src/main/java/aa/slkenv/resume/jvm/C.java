package aa.slkenv.resume.jvm;

import java.util.Arrays;

/**
 * A1 B A2:
 * ABA, BAA, AAB
 * <p>
 * 123
 * 3*2*1
 */
public class C {
    public static void main(String[] args) {
        // 全部不相同：
        String str = "ABCDEFGAB";
        char[] chars = str.toCharArray();

        // A(length, length*length)
        char[][] a = {chars, chars};
        System.out.println(Arrays.deepToString(a));

        // 排列数/2^same
        // 3的排列数/2^1


    }
}
