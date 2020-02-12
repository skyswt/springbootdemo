package cn.hyperchain.springbootdemo.service;

import cn.hyperchain.springbootdemo.entity.Admin;

public interface AdminService {
    public Admin findByUsername(String username);
}
