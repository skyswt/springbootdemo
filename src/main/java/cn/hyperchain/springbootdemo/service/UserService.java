package cn.hyperchain.springbootdemo.service;

import cn.hyperchain.springbootdemo.bean.EasyUIData;
import cn.hyperchain.springbootdemo.bean.Message;
import cn.hyperchain.springbootdemo.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public EasyUIData<User> findByUserContaining(String name, Pageable pageable);
    public Message save(User seed);
    public Message delete(User seed);

}
