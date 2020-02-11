package cn.hyperchain.springbootdemo.service.imp;

import cn.hyperchain.springbootdemo.bean.EasyUIData;
import cn.hyperchain.springbootdemo.bean.Message;
import cn.hyperchain.springbootdemo.dao.UserDao;
import cn.hyperchain.springbootdemo.entity.User;
import cn.hyperchain.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public EasyUIData<User> findByUserContaining(String name, Pageable pageable) {
        Page<User> page = userDao.findByNameContaining(name, pageable);
        EasyUIData<User> easyUIData = new EasyUIData<User>();
        easyUIData.setTotal(page.getTotalElements());
        easyUIData.setRows(page.getContent());
        return easyUIData;
    }

    @Override
    public Message save(User seed) {
        Message messag = new Message();
        try {
            userDao.save(seed);
            messag.setCode(0);
            messag.setMsg("保存成功");
        } catch (Exception e) {
            messag.setCode(-10);
            messag.setMsg("保存失败");
        }
        return messag;
    }

    @Override
    public Message delete(User seed) {
        Message messag = new Message();
        try {
            userDao.delete(seed);
            messag.setCode(0);
            messag.setMsg("删除成功");
        } catch (Exception e) {
            messag.setCode(-10);
            messag.setMsg("删除失败");
        }
        return messag;

    }
}
