package cn.hyperchain.springbootdemo.controller;

import cn.hyperchain.springbootdemo.bean.Message;
import cn.hyperchain.springbootdemo.entity.Admin;
import cn.hyperchain.springbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public Message login(@RequestBody Admin admin) {
        Admin a = adminService.findByUsername(admin.getUsername());
        Message message = new Message();
        if(a == null) {
            message.setCode(-10);
            message.setMsg("该用户不存在");
        } else {
            if(admin.getPassword().trim() != null && a.getPassword().equals(admin.getPassword())) {
                message.setCode(0);
            } else {
                message.setCode(-10);
                message.setMsg("账号或密码错误");
            }
        }
        System.out.println(message.getCode() + " " + message.getMsg());
        return message;
    }
}
