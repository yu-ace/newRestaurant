package com.example.restaurant1.controller;

import com.example.restaurant1.model.Customer;
import com.example.restaurant1.model.Dishes;
import com.example.restaurant1.model.OrderList;
import com.example.restaurant1.service.ICustomerService;
import com.example.restaurant1.service.IDishesService;
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
public class CustomerController {

    @Autowired
    ICustomerService customerService;
    @Autowired
    IDishesService dishesService;
    @Autowired
    IOrderListService orderListService;

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String add(
            @RequestParam(name = "id")
            int id,
            @RequestParam(name = "count")
            int count, HttpSession session){
        Customer customer = customerService.newCustomer(count,id);
        session.setAttribute("customer",customer);
        return "redirect:/customerBoard";
    }

    @RequestMapping(path = "/dishesListPage",method = RequestMethod.POST)
    public String dishesListPage(
            @RequestParam(name = "number")
            int n, Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        PageRequest of = PageRequest.of(n,10);
        Page<Dishes> dishesList = dishesService.getDishesList(of);
        model.addAttribute("dishesList",dishesList);
        return "addDishes";
    }

    @RequestMapping(path = "/dishesListByCategoryId",method = RequestMethod.POST)
    public String dishesListByCategoryId(
            @RequestParam(name = "categoryId")
            int categoryId,
            @RequestParam(name = "number")
            int n, Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        PageRequest of = PageRequest.of(n,10);
        Page<Dishes> dishesList = dishesService.getDishesListByCategoryId(categoryId,of);
        model.addAttribute("dishesList",dishesList);
        return "addDishes";
    }

    @RequestMapping(path = "/dishesListByName",method = RequestMethod.POST)
    public String dishesListByName(
            @RequestParam(name = "name")
            String name,Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        Dishes dishes = dishesService.getDishesByName(name);
        model.addAttribute("dishesList",dishes);
        return "addDishes";
    }

    @RequestMapping(path = "/orderListByCustomerPage",method = RequestMethod.POST)
    public String orderListByCustomerPage(
            @RequestParam(name = "number")
            int n,Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        PageRequest of = PageRequest.of(n,10);
        Page<OrderList> orderListByCustomerPage =
                orderListService.getOrderListByCustomerId(customerService.getCustomer(customer.getTableId()).getId(),of);
        model.addAttribute("orderList",orderListByCustomerPage);
        return "orderListByCustomer";
    }

    @RequestMapping(path = "/addOrderList",method = RequestMethod.POST)
    public String addOrderList(
            @RequestParam(name = "id")
            int id,
            @RequestParam(name = "count")
            int count,Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        orderListService.newOrderList(customerService.getCustomer(customer.getTableId()).getId(),
                id,dishesService.getDishesById(id).getPrice(),count);
        model.addAttribute("tip","添加成功");
        return "addDishes";
    }

    @RequestMapping(path = "/payList",method = RequestMethod.POST)
    public String payList(Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        return "add";
    }

}
