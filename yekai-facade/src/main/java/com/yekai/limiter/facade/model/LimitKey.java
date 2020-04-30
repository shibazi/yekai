package com.yekai.limiter.facade.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 限流条件明细
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LimitKey implements Serializable {

    /**
     * key 维度
     */
    @NotNull(message = "限流维度不能为空")
    @NotBlank(message = "限流维度不能为空")
    public String key;

    /**
     * value 维度值
     */
    public String value;
}
