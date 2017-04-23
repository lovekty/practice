package me.tony.practice.common.lambda;

import com.google.common.collect.ImmutableMap;
import me.tony.practice.common.Base;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tony on 2017/4/18.
 */
public class LambdaTest extends Base {

    @Test
    public void test() {
        Map<String, String> m = ImmutableMap.of("1", "A", "2", "B", "3", "C");
        Map<String, String> m1 = m.entrySet().stream().collect(Collectors.toMap(e -> e.getValue(), Map.Entry::getKey));
        System.out.println(m1);
    }

    @Test
    public void testLocalDate() {
//        LocalDate now = LocalDate.now();
        LocalDate now = LocalDate.of(1900, 3, 31);
        LocalDate lastMonth = now.minusMonths(1);
        LocalDate firstOfLastMonth = lastMonth.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastOfLastMonth = lastMonth.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now);
        System.out.println(lastMonth);
        System.out.println(firstOfLastMonth);
        System.out.println(lastOfLastMonth);
    }

    @Test
    public void testDateTimeFormatter() {
        LocalDate l = LocalDate.parse("20170401", DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(l);
    }

    @Test
    public void sortTest() {
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2012, 4, 12),
                LocalDate.of(2013, 4, 12),
                LocalDate.of(2014, 4, 12),
                LocalDate.of(2013, 2, 12),
                LocalDate.of(2012, 5, 12)
        );
        System.out.println(dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
