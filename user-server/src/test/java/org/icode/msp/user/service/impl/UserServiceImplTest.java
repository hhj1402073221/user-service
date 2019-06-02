package org.icode.msp.user.service.impl;

import org.icode.msp.user.UserApplication;
import org.icode.msp.user.domain.User;
import org.icode.msp.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.DateUtil.now;
import static org.junit.Assert.*;

/**
 * Created by sheriff on 2018/11/20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserServiceImplTest {

    @Autowired UserService userService;

    @Test
    public void getOneByAccount() throws Exception {

        User user = userService.getOneByAccount("123456");

        System.out.println(user.toString());
    }

    @Test
    public void existsById() throws Exception {

        System.out.println(userService.existsById("123456"));
    }

    @Test
    public void findAll() throws Exception {

        List<User> users = userService.findAll();

        System.out.println(users.size());
    }

    @Test
    public void findAllById() throws Exception {
    }

    @Test
    public void count() throws Exception {

        System.out.println(userService.count());
    }

    @Test
    public void deleteByAccount() throws Exception {
        System.out.println(userService.deleteByAccount("123456"));
    }

    @Test
    public void delete() throws Exception {
        User user = new User();
        user.setAccount("10001");
        user.setNickname("sheriff");
        user.setEmail("4444@qq.com");
        user.setCreateTime(now());
        user.setLastLoginTime(now());
        userService.delete(user);
    }

    @Test
    public void deleteAll() throws Exception {

        userService.deleteAll();
    }

    @Test
    public void deleteInBatch() throws Exception {
        List<User> users = new ArrayList<User>();

        User user = new User();
        user.setAccount("10001");
        user.setNickname("sheriff");
        user.setEmail("4444@qq.com");
        user.setCreateTime(now());
        user.setLastLoginTime(now());

        users.add(user);

        User user1 = new User();
        user1.setAccount("10002");
        user1.setNickname("jerry");
        user1.setEmail("4444@qq.com");
        user1.setCreateTime(now());
        user1.setLastLoginTime(now());

        users.add(user1);
        userService.deleteInBatch(users);

    }

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setAccount("10001");
        user.setNickname("sheriff");
        user.setEmail("4444@qq.com");
        user.setCreateTime(now());
        user.setLastLoginTime(now());

        userService.save(user);
    }

}