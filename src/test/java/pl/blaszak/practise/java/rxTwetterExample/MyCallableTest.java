package pl.blaszak.practise.java.rxTwetterExample;

import org.junit.Test;

import java.util.List;
import java.util.Random;

public class MyCallableTest {

    @Test
    public void name() {
        Random random = new Random();
        MyCallable myCallable = new MyCallable(random);
        List<String> report = myCallable.callAll();
        report.forEach(r -> System.out.println(r));
    }
}