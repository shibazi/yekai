package com.yekai.limiter.manager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据基础模型
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
@Getter
@Setter
@ToString
public class BaseDO implements Serializable {

    /**
     * 数据库主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 最后更新人
     */
    private String updatedBy;

}