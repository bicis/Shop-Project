package com.sky.controller.user;


import com.sky.constant.ShopStatusConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取店铺的营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(
                ShopStatusConstant.SHOP_STATUS_KEY);

        if(status == null) {
            status = ShopStatusConstant.SHOP_STATUS_CLOSE;
            redisTemplate.opsForValue().set(
                    ShopStatusConstant.SHOP_STATUS_KEY,
                    status);
        }

        log.info("获取店铺的营业状态：{}", status.equals(
                ShopStatusConstant.SHOP_STATUS_OPEN) ?
                ShopStatusConstant.SHOP_STATUS_OPENING_MES :
                ShopStatusConstant.SHOP_STATUS_CLOSING_MES);

        return Result.success(status);
    }
}
