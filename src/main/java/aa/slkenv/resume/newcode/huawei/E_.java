package aa.slkenv.resume.newcode.huawei;

import java.util.Random;

public class E_ {
    // 小数点后一位小于5直接舍去
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            float v = random.nextFloat();
            System.out.println(v);
            // 0.445考虑后三位小数，可用常量代替或枚举0.445
            double left = v - (int) v - 0.445;
            System.out.println(left > 0 ? (int) v + 1 : (int) v);
        }
    }
}