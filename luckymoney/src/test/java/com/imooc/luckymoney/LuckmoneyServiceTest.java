package com.imooc.luckymoney;


import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.service.LuckymoneyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.Inet4Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckmoneyServiceTest  {
    //注入需要测试的LuckymoneyService类
    @Autowired
    private LuckymoneyService luckymoneyService;

    //需要测试的方法上加上Test注解
    @Test
    public void findOneTest(){
        Luckymoney luckymoney = luckymoneyService.findOne(5);
        Integer age = luckymoney.getAge();
        Assert.assertEquals(new Integer(9), age);
    }
}
