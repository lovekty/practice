package me.tony.practice.common.executor;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(new Mission(499));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        try {
            String s = result.get(500, TimeUnit.MILLISECONDS);
            System.out.println("end sign:" + s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("duration in millisec:" + (System.currentTimeMillis() - start));
        }
    }

    @Test
    public void test() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            Random r = new Random();
            int i = r.nextInt(10);
            if (i == 9) {
                throw new RuntimeException();
            }
            System.out.println("haha:" + i);
        }, 5, 5, TimeUnit.SECONDS);
        Scanner scanner = new Scanner(System.in);
        String end = scanner.nextLine();
    }

    static class Mission implements Callable<String> {

        private long tts;

        public Mission(long tts) {
            this.tts = tts;
        }

        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(tts);
                System.out.println("mission done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "done";
        }
    }
}
