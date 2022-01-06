package aa.slkenv.resume.jvm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 任给一个数组，其中只有一个元素是单独出现，其他是成对出现，输出单独的元素
 */
public class B {

    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(4);
        linkedList.add(4);
        for (Integer integer : linkedList) {
            setEx(integer, 1);
        }
        map.forEach((key, value) -> {
            if (value == 1) {
                System.out.println(value);
            }
        });
    }

    public static void setEx(Integer key, int value) {
        map.merge(key, value, Integer::sum);
    }

}
