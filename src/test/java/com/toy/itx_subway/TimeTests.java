package com.toy.itx_subway;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;

@SpringBootTest
class TimeTests {

    @Test
    public void time() throws UnsupportedEncodingException {
        LocalTime time1 = LocalTime.of(06, 10);
        LocalTime time2 = LocalTime.of(16, 10);

        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);

    }
}
