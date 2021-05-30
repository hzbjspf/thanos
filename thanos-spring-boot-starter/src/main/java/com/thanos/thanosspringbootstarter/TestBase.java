package com.thanos.thanosspringbootstarter;

import com.thanos.thanosspringbootstarter.ThanosSpringBootStarterApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = ThanosSpringBootStarterApplication.class)
public class TestBase extends AbstractTestNGSpringContextTests {
}
