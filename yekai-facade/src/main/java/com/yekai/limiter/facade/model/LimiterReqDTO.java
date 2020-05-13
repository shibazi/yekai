package com.yekai.limiter.facade.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

/**
 * 限流请求参数
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LimiterReqDTO extends BaseReqDTO {

    /**
     * 需要被计数的参数列表
     */
    @NotEmpty(message = "限流请求参数不能为空")
    @NotNull(message = "限流请求参数不能为空")
    public Map<String,String> params;

}