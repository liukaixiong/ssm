package mybatis;

import com.dao.TGirlMapper;
import com.model.TGirl;
import com.model.TGirlExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * mybatis 源码学习
 *
 * @author Liukx
 * @create 2017-09-08 15:45
 * @email liukx@elab-plus.com
 **/

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/transactional/app*.xml"})
public class MybatisTest {

    @Autowired
    private TGirlMapper girlMapper;


    @Test
    public void find() {
        TGirlExample ex = new TGirlExample();
        ex.createCriteria().andAgeGreaterThan(3);
        List<TGirl> tGirls = girlMapper.selectByExample(ex);
        System.out.println("---------------->"+tGirls.size());
    }

}
