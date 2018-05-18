package mybatis;

import com.dao.TGirlMapper;
import com.model.TGirl;
import com.model.TGirlExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Qualifier("girlMapperImpl")
    @Autowired
    private TGirlMapper girlMapper;


    @Test
    public void find() {
        TGirlExample ex = new TGirlExample();
//        ex.createCriteria().andAgeEqualTo(21);
//        TGirlExample.Criteria criteria = ex.createCriteria();
//        criteria.andGirl_nameEqualTo("林允儿");

//        List<TGirl> tGirls = girlMapper.selectByExample(ex);
//        System.out.println("---------------->"+tGirls.size());
//        TGirl girl = girlMapper.selectByPrimaryKey(2);
//        System.out.println(girl.getGirl_name());
        TGirlExample example = new TGirlExample();
        TGirlExample.Criteria criteria = example.createCriteria();
        criteria.andAgeGreaterThan(10);
        criteria.andAgeLessThan(20);
        List<TGirl> tGirls = girlMapper.selectByExample(example);
        System.out.println("-------------------------->" + tGirls.size());

    }

}
