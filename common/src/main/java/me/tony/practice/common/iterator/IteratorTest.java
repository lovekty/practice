package me.tony.practice.common.iterator;

import com.google.common.collect.Lists;
import me.tony.practice.common.Base;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tony on 2017/7/15.
 */
public class IteratorTest extends Base {

    @Test
    public void test() {
        List<String> list = Lists.newArrayList("hello", "world", "i", "am", "tony", "haha", "test");

        Iterator<String> it = list.iterator();
        for (; it.hasNext(); ) {
            String str = it.next();
            if (str.length() < 3 || str.startsWith("he")) {
                it.remove();
            }
        }

        for (String str : list) {
            System.out.println(str);
        }
    }
}
