package pl.blaszak.practise.java.rxTwetterExample;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyCallable implements Callable<String> {

    private final Random random;

    public MyCallable(Random random) {
        this.random = random;
    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().sleep(random.nextInt(5) * 1000);
        return Thread.currentThread().getName() + " ::: " + LocalTime.now().format(DateTimeFormatter.ISO_TIME);
    }

    public List<String> callAll() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Random random = new Random();
        Callable<String> callable = new MyCallable(random);
        try {
            List<Future<String>> futures = IntStream.range(0, 100)
                    .boxed()
                    .map(i -> executor.submit(callable))
                    .collect(Collectors.toList());
            AtomicInteger ai = new AtomicInteger(0);
            return futures.stream()
                    .map(MyCallable::futureToMyFutureMapper)
                    .map(f -> new Integer(ai.getAndIncrement()).toString() + " ::: " + f.get())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            executor.shutdown();
        }
    }

    public static MyFuture futureToMyFutureMapper(Future<String> future) {
        return new MyFuture(future);
    }

    public static class MyFuture {
        private final Future<String> future;

        MyFuture(Future<String> future) {
            this.future = future;
        }

        public String get() {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return "";
            }
        }
    }
}
