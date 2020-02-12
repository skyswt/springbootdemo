package cn.hyperchain.springbootdemo.dao;

import cn.hyperchain.springbootdemo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Long> {
    public Admin findByUsername(String username);

}
