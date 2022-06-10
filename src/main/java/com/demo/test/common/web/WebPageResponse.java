package com.demo.test.common.web;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 *
 * @Author: cwt
 */
@Getter
@Setter
public class WebPageResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 消息状态码 */
    private long code;

    /** 消息内容 */
    private String msg;

    /** 总记录数 */
    private Long total;

    /** 数据列表 */
    private List<T> list;

    /**
     * PageHelper分页后的list
     * Mybatis数据查询前可调用utils包下的PageUtils.startPage()方法，配合使用
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> WebPageResponse<T> buildPage(List<T> list) {
        WebPageResponse<T> result = new WebPageResponse<>();
        PageInfo<T> pageInfo = new PageInfo<>();
        result.setList(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());

        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }
}
