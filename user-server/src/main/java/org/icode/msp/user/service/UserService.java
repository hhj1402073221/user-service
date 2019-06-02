package org.icode.msp.user.service;

import org.icode.msp.user.domain.User4Org;
import org.icode.msp.user.domain.PageInfo;
import org.icode.msp.user.domain.User;
import org.icode.msp.user.dto.UserDrop;

import java.util.List;
import java.util.Map;

/**
 * Created by sheriff on 2018/11/20.
 */
public interface UserService {

    public User getOneByAccount(String account);

    public boolean existsById(String account);

    public List<User> findAll();

    String getNickname(String account);

    Map<String, String> getNicknames(List<String> accounts);

    PageInfo getUserByPage();

    PageInfo getUserByConditionWithPage(User condition);

    List<String> getAccount(String nickname);

    public List<User> findAllById(String id);

    boolean changeState(String state, List<String> accounts);

    public long count();

    public boolean deleteByAccount(String account);

    public boolean delete(User user);

    public boolean deleteAll();

    public boolean deleteInBatch(List<User> users);

    public boolean save(User user);

    public List<UserDrop> getUserDrop();

    public List<User4Org> getUnassignedUsers(List<User4Org> exclude);

    public int login(User user);
}
