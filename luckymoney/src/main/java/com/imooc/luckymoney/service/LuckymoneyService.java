package com.imooc.luckymoney.service;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.enums.ResultEnum;
import com.imooc.luckymoney.exception.LuckymoneyException;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

//    @Autowired
//    private LuckymoneyRepository repository;

    /**
     * 事务：要么都成功要么都失败，事务指的是数据库事务，必须数据库本身要支持事务才可以（innodb支持）
     * 扣库存 > 创建订单  必须都发生或者都不发生
     */

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    @Transactional
    public void createTwo(){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer("me");
        luckymoney.setMoney(new BigDecimal("520"));
        luckymoneyRepository.save(luckymoney);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("me");
        luckymoney2.setMoney(new BigDecimal("520"));
        luckymoneyRepository.save(luckymoney2);
    }

    /**
     * service里面处理判断逻辑
     * 如果判断不通过，直接向外面抛异常
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        Luckymoney luckymoney = luckymoneyRepository.getOne(id);
        Integer age= luckymoney.getAge();
        if(age<10){
            throw new LuckymoneyException(ResultEnum.PRIMARY);
        }
        else if(age>10 && age<16){
            throw new LuckymoneyException(ResultEnum.MIDDLE);
        }

    }

    /**
     * 通过id查询红包信息
     * @param id
     * @return
     */
    public Luckymoney findOne(Integer id){
        return luckymoneyRepository.getOne(id);
    }
}
