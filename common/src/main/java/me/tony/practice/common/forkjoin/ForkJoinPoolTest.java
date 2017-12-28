package me.tony.practice.common.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(2);
        final long start = System.currentTimeMillis();
        String result = pool.invoke(new FetchResultJob(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        System.out.println("duration:" + (System.currentTimeMillis() - start));
        System.out.println(result);
    }

    static class FetchResultJob extends RecursiveTask<String> {

        private List<Integer> jobs;

        public FetchResultJob(List<Integer> jobs) {
            this.jobs = jobs;
        }

        @Override
        protected String compute() {
            if (jobs == null || jobs.isEmpty()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
                return null;
            } else if (jobs.size() == 1) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
                return "[" + jobs.get(0) + "]";
            } else {
                List<Integer> sub1 = jobs.subList(0, jobs.size() / 2);
                List<Integer> sub2 = jobs.subList(jobs.size() / 2, jobs.size());
                FetchResultJob job1 = new FetchResultJob(sub1);
                FetchResultJob job2 = new FetchResultJob(sub2);
                invokeAll(job1, job2);
                return job1.join() + job2.join();
            }
        }
    }
}
