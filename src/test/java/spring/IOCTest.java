package spring;

import com.service.IDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ioc test
 *
 * @author Liukx
 * @create 2017-12-06 13:51
 * @email liukx@elab-plus.com
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/transactional/app*.xml"})
public class IOCTest {

//    @Qualifier("demoService2")
    @Autowired
    private IDemoService demoService;



    @Test
    public void initIOCTest() throws Exception {
        demoService.test("aaaa");
    }

}
