package org.icode.msp.user.controller;

import org.icode.msp.user.domain.User4Org;
import org.icode.msp.user.config.ResultEnum;
import org.icode.msp.user.domain.Result;
import org.icode.msp.user.domain.User;
import org.icode.msp.user.dto.UserDrop;
import org.icode.msp.user.service.UserService;
import org.icode.msp.user.utils.EmptyUtil;
import org.icode.msp.user.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sheriff on 2018/11/20.
 */
@RestController
@RequestMapping(value = "/api/v1.0.0")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户基本资料
     *
     * @return Result<User>
     */
    @GetMapping(value = "/users")
    public Result<List<User>> findAll() {
        return ResultUtil.success(userService.findAll());
    }

    @GetMapping(value = "/getUserByPage")
    public Result<List<User>> getUserByPage() {
        return ResultUtil.success(userService.getUserByPage());
    }

    @PostMapping(value = "/getUserByConditionWithPage")
    public Result<List<User>> getUserByConditionWithPage(@RequestBody(required = false) User condition) {
        return ResultUtil.success(userService.getUserByConditionWithPage(condition));
    }

    /**
     * 查询指定用户的基本资料
     *
     * @param account
     * @return Result<User>
     */
    @GetMapping(value = "/user/{account}")
    public Result<User> getOneByAccount(@PathVariable("account") String account) {
        if (EmptyUtil.isEmpty(account)) {
            return ResultUtil.error(ResultEnum.ERROR_NULL_ID, null);
        }

        return ResultUtil.success(userService.getOneByAccount(account));
    }

    /**
     * 保存一个用户的基本信息
     *
     * @param user
     * @return Result<User>
     */
    @PostMapping(value = "/user")
    public Result<User> save(@RequestBody User user) {
        return ResultUtil.success(userService.save(user));
    }

    /**
     * 转换用户状态
     *
     * @param accounts
     * @return
     */
    @PostMapping(value = "/user/changeState")
    public Result<User> changeState(@RequestBody List<String> accounts, String state) {
        return ResultUtil.success(userService.changeState(state, accounts));
    }

    /**
     * 删除指定账号的用户基本资料
     *
     * @param account
     * @return
     */
    @DeleteMapping(value = "/user/{account}")
    public Result<User> deleteByAccount(@PathVariable String account) {
        if (EmptyUtil.isEmpty(account)) {
            return ResultUtil.error(ResultEnum.ERROR_NULL_ID, null);
        }
        return ResultUtil.success(userService.deleteByAccount(account));
    }

    /**
     * 删除指定用户的用户基本资料
     *
     * @param user
     * @return
     */
    @DeleteMapping(value = "/user")
    public Result<User> delete(@RequestBody User user) {
        if (EmptyUtil.isEmpty(user)) {
            return ResultUtil.error(ResultEnum.ERROR_NULL_ID, null);
        }
        return ResultUtil.success(userService.delete(user));
    }

    /**
     * 删除所有用户资料
     *
     * @return
     */
    @DeleteMapping(value = "/users")
    public Result<User> deleteAll() {
        return ResultUtil.success(userService.deleteAll());
    }

    /**
     * 删除所有用户资料
     *
     * @return
     */
    @DeleteMapping(value = "/users/batchDelete")
    public Result<User> deleteInBatch(@RequestBody List<User> users) {
        return ResultUtil.success(userService.deleteInBatch(users));
    }

    /**
     * 获取用户下拉框信息
     *
     * @return
     */
    @GetMapping(value = "/usersDrop")
    public Result<List<UserDrop>> getUserDrop() {
        return ResultUtil.success(userService.getUserDrop());
    }


    /**
     * 通过账户获取用户昵称
     *
     * @param account
     * @return
     */
    @GetMapping(value = "user/getNickname")
    public Result<String> getNickname(String account) {
        return ResultUtil.success(userService.getNickname(account));
    }

    /**
     * 通过账户获取用所有户昵称
     *
     * @param accounts
     * @return
     */
    @PostMapping(value = "user/getNicknames")
    public Result<Map<String, String>> getNicknames(@RequestBody List<String> accounts) {
        return ResultUtil.success(userService.getNicknames(accounts));
    }

    /**
     * 通过用户昵称获取账户
     */
    @GetMapping(value = "user/getAccount")
    public Result<List<String>> getAccount(String nickname) {
        return ResultUtil.success(userService.getAccount(nickname));
    }

    /**
     * 获取不包含exclude中的用户
     * exclude中是已分配的用户,可为null
     *
     * @param exclude
     * @return
     */

    @PostMapping(value = "users/for/organization")
    public List<User4Org> getUnassignedUsers(@RequestBody List<User4Org> exclude) {
        return userService.getUnassignedUsers(exclude);
    }

    /**
     *  用户登录
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user/login")
    public Result<User> login(@RequestBody User user){
        return ResultUtil.success(userService.login(user));
    }
}
