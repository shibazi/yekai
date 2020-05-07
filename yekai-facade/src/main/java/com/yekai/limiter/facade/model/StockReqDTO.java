package com.yekai.limiter.facade.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 库存请求参数
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
public class StockReqDTO extends BaseReqDTO {

    /**
     * 产品编号
     */
    @NotNull(message = "产品编号不能为空")
    @NotBlank(message = "产品编号不能为空字符")
    private String productId;

    /**
     * 数量
     */
    @Min(value = 1,message = "商品数量需大于0")
    private Integer num;
}
