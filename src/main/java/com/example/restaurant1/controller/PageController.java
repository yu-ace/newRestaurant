package com.example.restaurant1.controller;

import com.example.restaurant1.model.*;
import com.example.restaurant1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    IOrderListService orderListService;
    @Autowired
    IOrderService orderService;
    @Autowired
    IUserService userService;
    @Autowired
    IDishesService dishesService;
    @Autowired
    ICustomerService customerService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String index1(){
        return "login";
    }

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(path = "/userBoard",method = RequestMethod.GET)
    public String userBoard(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        model.addAttribute("user",user);
        return "userBoard";
    }

    @RequestMapping(path = "/cookBoard",method = RequestMethod.GET)
    public String cookBoard(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        model.addAttribute("user",user);
        return "cookBoard";
    }

    @RequestMapping(path = "/newDishes",method = RequestMethod.GET)
    public String newDishes(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        return "newDishes";
    }

    @RequestMapping(path = "/orderList",method = RequestMethod.GET)
    public String orderList(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        PageRequest of = PageRequest.of(0,10);
        Page<OrderList> orderList = orderListService.getOrderList(of);
        model.addAttribute("orderList",orderList);
        return "orderList";
    }

    @RequestMapping(path = "/orderTotalList",method = RequestMethod.GET)
    public String orderTotalList(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        PageRequest of = PageRequest.of(0,10);
        Page<Order> orderTotalList = orderService.getOrderList(of);
        model.addAttribute("orderTotalList",orderTotalList);
        return "orderTotalList";
    }

    @RequestMapping(path = "/newUser",method = RequestMethod.GET)
    public String newUser(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        return "newUser";
    }

    @RequestMapping(path = "/userList",method = RequestMethod.GET)
    public String userList(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        PageRequest of = PageRequest.of(0,10);
        Page<User> userList = userService.getUserList(0,of);
        model.addAttribute("userList",userList);
        return "userList";
    }

    @RequestMapping(path = "/deleteUser",method = RequestMethod.GET)
    public String deleteUser(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        return "deleteUser";
    }

    @RequestMapping(path = "/changePassword",method = RequestMethod.GET)
    public String changePassword(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        return "changePassword";
    }

    @RequestMapping(path = "/startCooking",method = RequestMethod.GET)
    public String startCooking(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        return "startCooking";
    }

    @RequestMapping(path = "/rest",method = RequestMethod.GET)
    public String rest(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        return "rest";
    }

    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public String add(){
        return "add";
    }

    @RequestMapping(path = "/customerBoard",method = RequestMethod.GET)
    public String customerBoard(Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        return "addDishes";
    }
    @RequestMapping(path = "/addDishes",method = RequestMethod.GET)
    public String addDishes(Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        PageRequest of = PageRequest.of(0,10);
        Page<Dishes> dishesList = dishesService.getDishesList(of);
        model.addAttribute("dishesList",dishesList);
        return "addDishes";
    }

    @RequestMapping(path = "/orderListByCustomer",method = RequestMethod.GET)
    public String orderListByCustomer(Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        PageRequest of = PageRequest.of(0,10);
        Page<OrderList> orderListByCustomer = orderListService.getOrderListByCustomerId(customer.getId(),of);
        model.addAttribute("orderList",orderListByCustomer);
        return "orderListByCustomer";
    }

    @RequestMapping(path = "/pay",method = RequestMethod.GET)
    public String pay(Model model,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null){
            model.addAttribute("error","你的信息登陆失效，请重新登陆");
            return "add";
        }
        Order order = orderService.newOrder(customerService.getCustomer(customer.getTableId()).getId());
        model.addAttribute("order",order);
        return "pay";
    }
}
