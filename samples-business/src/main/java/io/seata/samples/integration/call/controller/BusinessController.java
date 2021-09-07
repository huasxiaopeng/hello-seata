package io.seata.samples.integration.call.controller;

import io.seata.samples.integration.call.service.BusinessService;
import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author: heshouyou
 * @Description  Dubbo业务执行入口
 * @Date Created in 2019/1/14 17:15
 */
@RestController
@RequestMapping("/business/dubbo")
@Slf4j
public class BusinessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);


    @Autowired
    private BusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    ObjectResponse handleBusiness(){
        BusinessDTO businessDTO =new BusinessDTO();
        businessDTO.setAmount(new BigDecimal(100.00));
        businessDTO.setCommodityCode("C201901140001");
        businessDTO.setName("水杯");
        businessDTO.setCount(2);
        businessDTO.setUserId("1");
        LOGGER.info("请求参数：{}",businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
