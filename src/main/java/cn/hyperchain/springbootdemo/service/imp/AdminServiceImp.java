package cn.hyperchain.springbootdemo.service.imp;

import cn.hyperchain.springbootdemo.dao.AdminDao;
import cn.hyperchain.springbootdemo.entity.Admin;
import cn.hyperchain.springbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findByUsername(String username) {
        return adminDao.findByUsername(username);
    }
}
