package com.xt.controller;

import com.xt.entity.Book;
import com.xt.entity.Orders;
import com.xt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/insertOrder")
    public String insertOrder(HttpSession session, Integer bookId) {

        Integer id = (Integer) session.getAttribute("id");

        Orders orders = new Orders();

        orders.setBookid(bookId);
        orders.setCustomerid(id);
        orders.setCount(1);

        Integer integer = orderService.selectCountByCustomer(orders.getBookid(), orders.getCustomerid());

        if (integer >= 1) {
            Integer integer1 = orderService.updateCount(orders.getBookid(),orders.getCustomerid());
        } else {
            orderService.insertAll(orders);
        }

        return "redirect:/book/toBookList";
    }

    @RequestMapping("/toOrdersList")
    public String toOrdersList() {
        return "before/OrdersList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String, Object> list(HttpSession session, Integer countPage) {

        Integer id = (Integer) session.getAttribute("id");

        int count = 5;
        int page = (countPage - 1) * count;

        List<Orders> orders = orderService.selectAll(page, count, id);

        HashMap<String, Object> HashMap = new HashMap<>();

        Integer total = orderService.selectCount();

        HashMap.put("obj", orders);
        HashMap.put("total", total);

        return HashMap;

    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        orderService.delete(id);
        return "redirect:/order/toOrdersList";
    }

}
