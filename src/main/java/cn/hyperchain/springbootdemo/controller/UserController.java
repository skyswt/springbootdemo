package cn.hyperchain.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import cn.hyperchain.springbootdemo.bean.EasyUIData;
import cn.hyperchain.springbootdemo.bean.EasyUIDataPageRequest;
import cn.hyperchain.springbootdemo.bean.Message;
import cn.hyperchain.springbootdemo.entity.User;
import cn.hyperchain.springbootdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIData<User> list(EasyUIDataPageRequest easyUIDataPageRequest, @RequestParam(defaultValue = "") String name) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        if (easyUIDataPageRequest.getOrder().equals("asc")) {
            orders.add(new Sort.Order(Direction.ASC, easyUIDataPageRequest.getSort()));
        } else {
            orders.add(new Sort.Order(Direction.DESC, easyUIDataPageRequest.getSort()));
        }
        Pageable pageable = PageRequest.of(easyUIDataPageRequest.getPage() - 1, easyUIDataPageRequest.getRows(),
                Sort.by(orders));
        return userService.findByUserContaining(name, pageable);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Message save(User user) {
        return userService.save(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message delete(User user) {
        return userService.delete(user);
    }
}