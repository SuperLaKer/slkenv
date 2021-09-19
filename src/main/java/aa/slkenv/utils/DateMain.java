package aa.slkenv.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateMain {
    public static void main(String[] args) throws ParseException {
        oneMinAgo();
    }

    private static void oneMinAgo() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(GregorianCalendar.SECOND, -60);
        Date time = calendar.getTime();
        System.out.println(time);
    }

    public static void dateDemo() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(df.format(new Date()));
        String str = "2020年12月11日";
        Date date = df.parse(str);
        System.out.println(date);

    }
}
