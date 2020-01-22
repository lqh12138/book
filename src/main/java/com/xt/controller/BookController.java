package com.xt.controller;

import com.xt.entity.Book;
import com.xt.entity.Class;
import com.xt.service.BookService;
import com.xt.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ClassService classService;

    @RequestMapping("/toBookList")
    public String toBookList() {

        return "before/bookList";

    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap list(Integer countPage, HttpSession session) {

        String typeId = (String) session.getAttribute("typeId");

        Integer typeIds=null;

        if (typeId != null) {
            typeIds = Integer.parseInt(typeId);
        }


        if (countPage == null) {
            countPage = 1;
        }

        int count = 5;
        int page = (countPage - 1) * count;

        List<Book> books = bookService.selectAll(page, count, typeIds);


        HashMap<String, Object> HashMap = new HashMap<>();

        Integer total = bookService.selectCount(typeIds);


        HashMap.put("obj", books);
        HashMap.put("total", total);

        return HashMap;
    }

    @RequestMapping("/ClassList")
    @ResponseBody
    public List<Class> ClassList() {

        List<Class> classes = classService.selectAll();

        return classes;
    }

    @RequestMapping("/type")
    public String type(HttpSession session, String typeId) {

        session.setAttribute("typeId", typeId);

        return "redirect:/book/toBookList";
    }

    @RequestMapping("/NewBookList")
    public String NewBookList(HttpSession session){
        session.removeAttribute("typeId");
        return "redirect:/book/toBookList";
    }
}
