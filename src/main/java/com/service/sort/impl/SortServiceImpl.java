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
@Service("sortService")
public class SortServiceImpl implements ISortService,Ordered {

    @Override
    public int getOrder() {
        return 15;
    }

    @Override
    public void sort() {
        System.out.println("============SortServiceImpl================");
    }
}
