package com.wcg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wcg.HelloApplication;
import wcg.service.BlogProperties;

/**
 * @author chengangw
 * @date 7/8/2017 6:42 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class HelloApplicationTest {
    private static final Log log = LogFactory.getLog(HelloApplicationTest.class);

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getTest() throws Exception {
        log.info(blogProperties.getName());
        log.info(blogProperties.getTitle());
        log.info(blogProperties.getDesc());
        log.info("随机数生成：");
        log.info(blogProperties.getValue());
        log.info(blogProperties.getNumber());
        log.info(blogProperties.getBignumber());
        log.info(blogProperties.getTest1());
        log.info(blogProperties.getTest2());


    }
}
