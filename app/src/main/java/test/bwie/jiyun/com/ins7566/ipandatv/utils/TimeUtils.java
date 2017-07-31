package test.bwie.jiyun.com.ins7566.ipandatv.utils;

import java.util.TimeZone;

/**
 * Created by lx on 2017/7/31.
 */

public class TimeUtils {
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }

    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    /**
     * 把timestamp各式化成yyyy/MM/dd
     *
     * @param dateTaken
     * @return
     */
    public static String dateString(long dateTaken) {
        return android.text.format.DateFormat.format("MM-dd-yyyy", dateTaken).toString();
    }

}
