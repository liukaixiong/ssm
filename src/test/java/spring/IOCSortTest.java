package spring;

import com.service.sort.ISortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ioc test
 *
 * @author Liukx
 * @create 2017-12-06 13:51
 * @email liukx@elab-plus.com
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/ioc/ioc.xml"})
public class IOCSortTest {

    @Qualifier("sort2Service")
    @Autowired
    private ISortService sort2Service;

    @Autowired
    private List<ISortService> sortServiceList;

    /**
     * 测试结论:
     * 1. 当定义了@Qualifier并指定了名称的,优先级最高
     * 2. 定义了@Primary的bean会在第一步没有指定的时候优先级最高,如果存在重复则报错
     * 3. 当上两步骤都没有做的时候,按照定义的字段名称去获取,找不到则报异常
     */
    @Test
    public void sortTest() throws Exception {
        sort2Service.sort();

        for (int i = 0; i < sortServiceList.size(); i++) {
            System.out.println(i + "-" + sortServiceList.get(i).getClass().getName());
        }
    }


}
