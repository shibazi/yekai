package com.yekai.limiter.facade.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 基本请求参数
 *
 * @author : LZQ Date: 2020/04/29  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BaseReqDTO implements Serializable {

    /**
     * 请求系统
     */
    @NotNull(message = "请求系统不能为空")
    @NotBlank(message = "请求系统不能为空字符")
    public String requireSystem;

    /**
     * 日志跟踪号
     */
    @NotNull(message = "日志跟踪号不能为空")
    @NotBlank(message = "日志跟踪号不能为空字符")
    public String logId;
}
