package org.icode.msp.user.service.impl;

import com.github.pagehelper.PageInfo;
import org.icode.msp.user.domain.User4Org;
import org.icode.msp.user.domain.User;
import org.icode.msp.user.dto.UserDrop;
import org.icode.msp.user.repository.UserRepository;
import org.icode.msp.user.service.UserService;
import org.icode.msp.user.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sheriff on 2018/11/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getOneByAccount(String account) {
        return userRepository.getOneByAccount(account);
    }

    @Override
    public boolean existsById(String account) {
        Integer result = userRepository.existsByAccount(account);
        if (result != 1)
            return false;
        return true;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public String getNickname(String account) {
        List<String> accounts = new ArrayList<>(1);
        accounts.add(account);
        List<User> list = userRepository.findByAccounts(accounts);
        if(list != null && list.size() > 0){
            return list.get(0).getNickname();
        }
        return null;
    }

    @Override
    public Map<String, String> getNicknames(List<String> accounts) {
        List<User> list = userRepository.findByAccounts(accounts);
        Map<String, String> res = new HashMap<>(list.size());
        if(list != null) {
            for (User user : list) {
                res.put(user.getAccount(), user.getNickname());
            }
        }
        return res;
    }

    @Override
    public org.icode.msp.user.domain.PageInfo getUserByPage() {
        List<User> users = userRepository.findAll();
        PageInfo info = new PageInfo(users);
        org.icode.msp.user.domain.PageInfo res = new org.icode.msp.user.domain.PageInfo(info.getTotal(), info.getPages(), info.getList());
        return res;
    }

    @Override
    public List<String> getAccount(String nickname){
        List<String> accounts = new ArrayList<>();
        if(nickname ==null || nickname.equals("")){
            return accounts;
        }
        Map<String, String> con = new HashMap<>(1);
        con.put("nickname", nickname);
        List<User> users = userRepository.findByCondition(con);
        if(users != null){
            for (User user: users){
                accounts.add(user.getAccount());
            }
        }
        return accounts;
    }

    @Override
    public org.icode.msp.user.domain.PageInfo getUserByConditionWithPage(User condition) {
        Map<String, String> con = new HashMap<>();
        if(condition != null) {
            if (condition.getAccount() != null && !condition.getAccount().equals("")) {
                con.put("account", condition.getAccount());
            }
            if (condition.getNickname() != null && !condition.getNickname().equals("")) {
                con.put("nickname", condition.getNickname());
            }
            if (condition.getSex() != null) {
                con.put("sex", condition.getSex() + "");
            }
            if (condition.getEmail() != null && !condition.getEmail().equals("")) {
                con.put("email", condition.getEmail());
            }
            if (condition.getTel() != null && !condition.getTel().equals("")) {
                con.put("tel", condition.getTel());
            }
            if (condition.getState() != null && !condition.getState().equals("")) {
                con.put("state", condition.getState() + "");
            }
        }
        List<User> users = userRepository.findByCondition(con);
        PageInfo info = new PageInfo(users);
        org.icode.msp.user.domain.PageInfo res = new org.icode.msp.user.domain.PageInfo(info.getTotal(), info.getPages(), info.getList());
        return res;
    }

    @Override
    public List<User> findAllById(String id) {
        return null;
    }

    @Override
    public boolean changeState(String state, List<String> accounts) {
        return userRepository.updataColumnInBatch("state", state, accounts);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public boolean deleteByAccount(String account) {
        userRepository.deleteByAccount(account);
        return true;
    }

    @Override
    public boolean delete(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public boolean deleteAll() {
        userRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteInBatch(List<User> users) {

        for (User user:users) {
            userRepository.delete(user);
        }
        return true;
    }

    @Override
    public boolean save(User user) {
        if(user.getAccount() != null && !user.getAccount().equals("")){
            List<String> accounts = new ArrayList<>(1);
            accounts.add(user.getAccount());
            if(userRepository.findByAccounts(accounts) == null) {
                user.setCreateTime(new Date());
            }
            if(user.getPassword() != null && !user.getPassword().equals("")){
                String password = MD5.MD5(user.getPassword()); // 密码加密
                user.setPassword(password);
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDrop> getUserDrop() {
        List<UserDrop> users = userRepository.getUserDrop();
        return users;
    }

    @Override
    public List<User4Org> getUnassignedUsers(List<User4Org> exclude) {
        return userRepository.getUnassignedUsers(exclude);
    }

    @Override
    public int login(User user) {
        User oldUser = userRepository.getOneByAccount(user.getAccount());
        if(oldUser != null && oldUser.getPassword().equals(MD5.MD5(user.getPassword()))){
            if(oldUser.getState() == 1){
                return 1; // 表示账号密码正确，并且处于启用状态
            }else{
                return 2; // 表示账号密码正确，并且处于禁用状态
            }
        }
        return 0;
    }
}
