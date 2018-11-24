package com.ehl.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className:PageController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/24 16:50
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex()
    {
        return "index";
    }

    @RequestMapping("/{page}" )
    public String showPage(@PathVariable String page)
    {
        return page;
    }
}
