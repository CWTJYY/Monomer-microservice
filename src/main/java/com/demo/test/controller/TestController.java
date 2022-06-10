package com.demo.test.controller;

import com.demo.test.common.web.WebPageResponse;
import com.demo.test.common.web.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @Author: cwt
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/index")
    public WebResponse<Object> index() {
        log.info("测试成功");
        return WebResponse.success();
    }

    @GetMapping("/page")
    public WebPageResponse<Object> page() {
        return WebPageResponse.buildPage(null);
    }
}
