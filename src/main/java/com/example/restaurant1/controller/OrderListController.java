package com.example.restaurant1.controller;

import com.example.restaurant1.model.OrderList;
import com.example.restaurant1.model.User;
import com.example.restaurant1.service.IOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class OrderListController {

    @Autowired
    IOrderListService orderListService;

    @RequestMapping(path = "/orderListPage",method = RequestMethod.POST)
    public String orderListPage(
            @RequestParam(name = "number")
            int n,Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        PageRequest of = PageRequest.of(n,10);
        Page<OrderList> orderList = orderListService.getOrderList(of);
        model.addAttribute("orderList",orderList);
        return "orderList";
    }

    @RequestMapping(path = "/orderListByDishesId",method = RequestMethod.POST)
    public String orderListByDishesId(
            @RequestParam(name = "id")
            int id,
            @RequestParam(name = "number")
            int n,Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        PageRequest of = PageRequest.of(n,10);
        Page<OrderList> orderList = orderListService.getOrderList(of);
        model.addAttribute("orderList",orderList);
        return "orderList";
    }

}
