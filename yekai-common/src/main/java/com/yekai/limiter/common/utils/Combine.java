package com.yekai.limiter.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 排列组合算法
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
public class Combine {

    /**
     * 排列组合
     *          C(n,k)
     *
     * @param source        原始数据
     * @return              排列组合结果
     */
    public static <E> Set<List<E>> combination(List<E> source){
        Set<List<E>> target = Sets.newHashSet();
        List<E> workSpace = Lists.newArrayList();
        for(int i = 1; i <= source.size(); i ++){
            combine(source,0,i,workSpace,target);
        }
        return target;
    }

    /**
     * 递归实现排列组合
     *
     * @param source            原始数据
     * @param workSpace         临时空间
     * @param target            结果集合
     */
    private static <E> void combine(List<E> source,int begin, int number,List<E> workSpace,Set<List<E>> target){
        if(number == 0){
            target.add(new ArrayList<E>(workSpace));
            return;
        }
        if(begin == source.size()){
            return;
        }
        workSpace.add(source.get(begin));
        combine(source,begin + 1,number -1, workSpace,target);
        workSpace.remove(source.get(begin));
        combine(source,begin + 1,number,workSpace,target);
    }
}
