package com.hunglv.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

@Slf4j
public class LoopTest {

    @Test
    public void t1() {
        var s = new Date().getTime();
        log.debug("main thread start");

        var a = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
        a.parallelStream().forEach(data ->  {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug(data.toString());
        });
        log.debug("main thread end: {}",  (new Date().getTime()- s));

    }
}
