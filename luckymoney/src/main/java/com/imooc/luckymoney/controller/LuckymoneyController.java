package com.imooc.luckymoney.controller;


import com.imooc.luckymoney.aspect.HttpAspect;
import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.domain.Result;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import com.imooc.luckymoney.service.LuckymoneyService;
import com.imooc.luckymoney.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    private final static Logger logger = LoggerFactory.getLogger(LuckymoneyController.class);

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /**
    * 获取红包列表
    */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){

        logger.info("list");
        return repository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping("/luckymoneys")
    //加valid表示要验证的是luckymoney这个对象
    public Result<Luckymoney> create(@Valid Luckymoney luckymoney, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //获取错误信息
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        //Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());

        return ResultUtil.success(repository.save(luckymoney)) ;
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {

        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            //luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        service.createTwo();
    }

    @GetMapping("/luckymoneys/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        service.getAge(id);
    }
}
