package com.demo.test.utils;

import com.github.pagehelper.PageHelper;

import java.util.Objects;

/**
 * 分页工具类
 *
 * @Author: cwt
 */
public class PageUtils {
    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * PageHelper分页
     */
    public static void startPage() {
        Integer pageNum = ServletUtils.getParameterToInt(PAGE_NUM);
        Integer pageSize = ServletUtils.getParameterToInt(PAGE_SIZE);
        if (Objects.nonNull(pageNum) && Objects.nonNull(pageSize)) {
            PageHelper.startPage(pageNum, pageSize);
        }
    }
}
