package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.model.User;

import java.util.Date;

/**
 * ioc test
 *
 * @author Liukx
 * @create 2017-12-06 13:51
 * @email liukx@elab-plus.com
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/transactional/applicationContext-ioc.xml"})
public class IOC2Test {

    @Autowired
    private User user;

    @Test
    public void initIOCTest() throws Exception {
        Date created = user.getCreated();
        System.out.println(created);
    }


}
