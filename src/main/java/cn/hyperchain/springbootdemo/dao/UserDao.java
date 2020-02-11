package cn.hyperchain.springbootdemo.dao;

import cn.hyperchain.springbootdemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public Page<User> findByNameContaining(String name, Pageable pageable);
}
