package com.yibuyiyin.restful.base;

import com.yibuyiyin.restful.RestfulApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * To be explained
 *
 * @author peng.yu
 */

@SpringBootTest(classes = RestfulApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BaseTest {
}
