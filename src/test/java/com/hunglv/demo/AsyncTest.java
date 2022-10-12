package com.hunglv.demo;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTest {
    @Test
    public void t2() throws ExecutionException, InterruptedException {
        var d1 = new Date().getTime();
        System.out.println("t1");
        CompletableFuture l1 = CompletableFuture.runAsync(() -> {
            sleep(100);
            System.out.println("log l1");
        });
        CompletableFuture l2 = CompletableFuture.runAsync(() -> {
            sleep(200);
            System.out.println("log l2");
        });
        System.out.println("t2");

        CompletableFuture a = CompletableFuture.allOf(l1, l2);
        a.thenCompose((da) -> {
            sleep(50);
            System.out.println("log l3");
            return null;
        });
        a.get();
        System.out.println("t3");
        System.out.println("time :" + (new Date().getTime() - d1));
    }

    @Test
    public void t3() {
        var d1 = new Date().getTime();
        System.out.println("t1");

        sleep(100);
        System.out.println("log l1");

        sleep(200);
        System.out.println("log l2");

        System.out.println("t2");
        sleep(50);
        System.out.println("log l3");

        System.out.println("t3");
        System.out.println("time :" + (new Date().getTime() - d1));
    }

    private void sleep(int v) {
        try {
            Thread.sleep(v);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
