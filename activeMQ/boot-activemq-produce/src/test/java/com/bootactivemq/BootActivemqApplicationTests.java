package com.bootactivemq;

import com.bootactivemq.produce.Queue_Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootActivemqApplicationTests {

    @Resource
    private Queue_Produce queue_produce;

    @Test
    public void contextLoads() throws Exception{
        queue_produce.QueueMsg();
    }

}
