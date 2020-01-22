package com.xt.controller;

import com.xt.entity.Customer;
import com.xt.service.CustomerService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "before/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Customer customer, HttpSession session) {

        Integer login = customerService.login(customer);

        if (login != null) {
            session.setAttribute("id", login);
            session.setAttribute("username",customer.getUsername());
            return "success";
        }
        return null;
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "before/register";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(Customer customer,HttpSession session) {

        Integer register = customerService.register(customer);

        if (register >= 1) {

            return "success";
        }
        return null;
    }

}
