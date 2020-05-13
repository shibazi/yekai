package com.yekai.limiter.common.utils;

import com.yekai.limiter.common.exception.LimitException;
import com.yekai.limiter.common.exception.ResponseCodeEnum;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 参数校验
 *
 * <p>
 *     1、参数校验
 * </p>
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
public class ParamValidate {

    private ParamValidate() {}

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 校验参数框架
     */
    private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();

    /**
     * 参数校验
     *
     * @param object                待验证参数
     * @throws LimitException       参数校验异常
     */
    public static void validateObject(Object object) throws LimitException {
        Validator validator = FACTORY.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (violations == null || violations.size() == 0) {
            return;
        }
        for (ConstraintViolation<Object> violation : violations) {
            throw new LimitException(ResponseCodeEnum.ERR_000001, violation.getMessage());
        }
    }
}