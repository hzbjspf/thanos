package com.thanos.thanosspringbootstarter;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class test extends TestBase{

    @Test
    public void test(){
        log.info("info");
        log.debug("debug");
    }
}
