package me.tony.practice.common.executor;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

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
}
