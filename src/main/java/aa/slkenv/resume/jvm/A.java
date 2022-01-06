package aa.slkenv.resume.jvm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * M G T，字符串排序
 */
public class A {
    static Map<String, Integer> ruleMap = new HashMap<>();

    public static void main(String[] args) {
        rulesInit();
        ArrayList<String> strings = new ArrayList<>();

        strings.add("1T");
        strings.add("0.1G");
        strings.add("1G");
        strings.add("100M");
        strings.add("3G");
        strings.add("2000M");

        strings.sort(Comparator.comparingInt(o -> Math.round(toFloat(o))));
        System.out.println(strings);
    }

    public static void rulesInit() {
        // 根据业务是否支持float，选择合适的单位 K,B et..
        ruleMap.put("M", 1);
        ruleMap.put("G", 1000);
        ruleMap.put("T", 1000000);
        ruleMap.put("P", 1000000000);
    }

    public static float toFloat(String targetStr) {
        int baseNum = 1;
        String newStr = null;
        for (String key : ruleMap.keySet()) {
            newStr = targetStr.replace(key, "");
            if (!targetStr.equals(newStr)) {
                baseNum = baseNum * ruleMap.get(key);
                break;
            }
        }
        assert newStr != null;
        float aFloat = Float.parseFloat(newStr);
        return aFloat * baseNum;
    }
}
