package aa.slkenv.resume.newcode.huawei;

import aa.slkenv.other.MyRandom;

public class A_StringR {
    public static void main(String[] args) {
        String str = MyRandom.str(6);
        System.out.println(str);
        char[] chars = str.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        char headValue;
        while (head < tail) {
            headValue = chars[head];
            chars[head] = chars[tail];
            chars[tail] = headValue;
            head++;
            tail--;
        }
        System.out.println(new String(chars));
    }
}
