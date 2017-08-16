package me.tony.practice.common.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {

    @Test
    public void testAddByIndex() {
        List<String> list = new ArrayList<>(Collections.emptyList());
        list.set(0, "hello");
        System.out.println(list.size());
    }
}
