package com.service.sort.impl;

import com.service.sort.ISortService;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * @author Liukx
 * @create 2018-03-16 11:18
 * @email liukx@elab-plus.com
 **/
//@Primary
@Service("sort2Service")
public class Sort2ServiceImpl implements ISortService,Ordered {

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public void sort() {
        System.out.println("============Sort2ServiceImpl================");
    }
}
