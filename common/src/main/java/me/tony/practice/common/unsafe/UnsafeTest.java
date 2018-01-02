package me.tony.practice.common.unsafe;

import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tony.zhuby
 * @date 2017/12/28
 */
public class UnsafeTest {

    static final Unsafe UNSAFE;

    static {
        try {
//            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            UNSAFE = (Unsafe) theUnsafe.get(null);
            UNSAFE = Unsafe.getUnsafe();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String... args) throws IOException {
        boolean odd;
        switch (args.length < 1 ? "usage" : args[0].toLowerCase()) {
            case "odd":
                odd = true;
                break;
            case "even":
                odd = false;
                break;
            default:
                System.err.println("Usage: java UnsafeTest [odd|even]");
                return;
        }
        int runs = 10000000;
        long start = 0;
        System.out.println("Waiting for the other odd/even");
        File counters = new File(System.getProperty("java.io.tmpdir"), "counters.deleteme");
        counters.deleteOnExit();

        try (FileChannel fc = new RandomAccessFile(counters, "rw").getChannel()) {
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
            long address = ((DirectBuffer) mbb).address();
            for (int i = -1; i < runs; i++) {
                for (; ; ) {
                    long value = UNSAFE.getLongVolatile(null, address);
                    boolean isOdd = (value & 1) != 0;
// wait for the other side.
                    if (isOdd != odd) {
                        continue;
                    }
// make the change atomic, just in case there is more than one odd/even process
                    if (UNSAFE.compareAndSwapLong(null, address, value, value + 1)) {
                        break;
                    }
                }
                if (i == 0) {
                    System.out.println("Started");
                    start = System.nanoTime();
                }
            }
        }
        System.out.printf("... Finished, average ping/pong took %,d ns%n",
                (System.nanoTime() - start) / runs);
    }
}
