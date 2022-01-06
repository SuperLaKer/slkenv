package aa.slkenv.resume.newcode.huawei;

import java.util.Random;

/**
 * 整数转二进制 1的个数
 */
public class D_num_1 {
    public static void main(String[] args) {
        int num = 0;
        Random random = new Random();
        int a = random.nextInt(10000) + 10000;
        // 校验
        System.out.println(Integer.toBinaryString(a));
        // Java int 32位，可以优化
        for (int i = 1; i <= 32; i++) {
            if ((a & 1 << i) != 0) {
                num++;
            }
        }
        System.out.println(num);
    }
}
