package aa.slkenv.other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyRandom {

    public static String str(int size) {
        String str = "qwertyu1iopl2kjh3gfd4sa5zx6c07vb89nmQW8ERTY7UI6OPL5KJ4H9GF3DSA2ZXCVBN1M";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(str.charAt(random.nextInt(str.length()-1)));
        }
        return new String(builder);
    }

    public static Queue<Integer> range(int begin, int end) {
        Queue<Integer> integers = new LinkedList<>();
        for (int i = begin; i < end; i++) {
            integers.add(i);
        }
        return integers;
    }
}
