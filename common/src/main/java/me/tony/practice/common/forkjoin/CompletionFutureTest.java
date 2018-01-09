package me.tony.practice.common.forkjoin;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author tony.zhuby
 * @date 2018/1/3
 */
public class CompletionFutureTest {

    @Test
    public void testCompletionStage() {
        long start = System.currentTimeMillis();
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (a, b) -> a + " " + b).join();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    @Test
    public void test() {
        CompletableFuture cf = new CompletableFuture();

    }

    public static void main(String[] args) {
    }

    static class MyTask {

    }
}
