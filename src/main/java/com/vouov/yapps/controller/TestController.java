package com.vouov.yapps.controller;

import com.vouov.yapps.model.User;
import com.vouov.yapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * User: yuml
 * Date: 12-9-6
 * Time: 上午1:18
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String> login() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("test1", messageSource.getMessage("test.index", null,Locale.getDefault()));
        return data;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> users() {
       return userService.selectAll();
    }
}
