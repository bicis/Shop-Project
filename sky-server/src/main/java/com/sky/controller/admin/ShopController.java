package com.sky.controller.admin;


import com.sky.constant.ShopStatusConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 设置营业状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置营业状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置营业状态：{}", Objects.equals(
                status, ShopStatusConstant.SHOP_STATUS_OPEN) ?
                ShopStatusConstant.SHOP_STATUS_OPENING_MES :
                ShopStatusConstant.SHOP_STATUS_CLOSING_MES);

        redisTemplate.opsForValue().set(
                ShopStatusConstant.SHOP_STATUS_KEY,
                status);

        return Result.success();
    }

    /**
     * 获取营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取营业状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(
                ShopStatusConstant.SHOP_STATUS_KEY);

        if(status == null) {
            status = ShopStatusConstant.SHOP_STATUS_CLOSE;
            redisTemplate.opsForValue().set(
                    ShopStatusConstant.SHOP_STATUS_KEY,
                    status);
        }


        log.info("获取营业状态：{}", status.equals(
                ShopStatusConstant.SHOP_STATUS_OPEN) ?
                ShopStatusConstant.SHOP_STATUS_OPENING_MES :
                ShopStatusConstant.SHOP_STATUS_CLOSING_MES);

        return Result.success(status);
    }
}
