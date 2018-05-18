package transactional;

import com.service.demo.ITransactionalService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 事物处理
 *
 * @author Liukx
 * @create 2017-08-10 9:43
 * @email liukx@elab-plus.com
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/transactional/app*.xml"}) //加载配置文件
public class TransactionalTest {


    //    Logger logger = LoggerFactory.getLogger(getClass());
    Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    @Qualifier("transactionalService")
    private ITransactionalService transactionalService;

    /**
     * 用于测试事物是否提交
     *
     * @throws Exception
     */
    @Test
    public void testTransactionalCommit() throws Exception {
        transactionalService.testQuery();
//        transactionalService.testTransactional();
        logger.debug("test---------");
    }

}
