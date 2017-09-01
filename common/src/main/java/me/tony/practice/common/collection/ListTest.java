package me.tony.practice.common.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ListTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndex() {
        List<String> list = new ArrayList<>(Collections.emptyList());
        list.set(0, "hello");
        System.out.println(list.size());
    }


    @Test
    public void testRemove() {
//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("reach:" + list.get(i));
//            if (list.get(i) % 3 == 0) {
//                System.out.println("remove:" + i + "-" + list.get(i));
//                list.remove(i);
//            }
//        }
//        System.out.println(list);
        List<Integer> list = gen();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Integer data = list.get(i);
            if (data % 3 == 0) {
                list.remove(data);
                i--;
            }
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(list.size());

        list = gen();
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Integer data = list.get(i);
            if (data % 3 == 0) {
                list.remove(i);
                i--;
            }
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(list.size());

        list = gen();
        start = System.currentTimeMillis();
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer data = list.get(i);
            if (data % 3 == 0) {
                list.remove(i);
            }
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(list.size());
    }

    private List<Integer> gen() {
        return IntStream.range(1, 100000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
