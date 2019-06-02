package org.icode.msp.user.repository;

import org.apache.ibatis.annotations.Param;
import org.icode.msp.user.domain.User4Org;
import org.icode.msp.user.domain.User;
import org.icode.msp.user.dto.UserDrop;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by sheriff on 2018/11/20.
 */

@Repository
public interface UserRepository {

    public User getOneByAccount(String account);

    public Integer existsByAccount(String account);

    public List<User> findAll();

    public List<User> findByCondition(@Param("condition") Map<String, String> condition);

    public List<User> findAllByAccount(String account);

    public List<User> findByAccounts(@Param("accounts") List<String> accounts);

    public long count();

    public boolean deleteByAccount(String account);

    public boolean delete(User user);

    public boolean deleteAll();

    public boolean deleteInBatch(List<User> users);

    public void save(User user);

    public boolean updataColumnInBatch(@Param("columnName") String columnName, @Param("value") String value, @Param("accounts") List<String> accounts);

//    public boolean saveInBatch(List<User> users);

    public List<UserDrop> getUserDrop();

    public List<User4Org> getUnassignedUsers(@Param("exclude") List<User4Org> exclude);
}