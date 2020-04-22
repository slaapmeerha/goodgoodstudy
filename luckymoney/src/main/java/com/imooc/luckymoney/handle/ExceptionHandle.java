package com.imooc.luckymoney.handle;

import com.imooc.luckymoney.domain.Result;
import com.imooc.luckymoney.exception.LuckymoneyException;
import com.imooc.luckymoney.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof LuckymoneyException){
            LuckymoneyException luckymoneyException = (LuckymoneyException) e;
            return ResultUtil.error(luckymoneyException.getCode(), luckymoneyException.getMessage());
        }
        else {
            logger.error("系统异常{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
