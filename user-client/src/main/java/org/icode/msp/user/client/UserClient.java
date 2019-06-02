package org.icode.msp.user.client;

import org.icode.msp.user.domain.User4Org;
import org.icode.msp.user.domain.Result;
import org.icode.msp.user.dto.UserDrop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sheriff on 2018/11/21.
 */
@FeignClient(name = "icode-msp-user-service")
public interface UserClient {

      @GetMapping(value = "/api/v1.0.0/usersDrop")
      public Result<List<UserDrop>> getUserDrop();

      @GetMapping(value = "/api/v1.0.0/user/getNickname")
      Result<String> getNickname(@RequestParam("account") String account);

      @PostMapping(value = "/api/v1.0.0/user/getNicknames")
      Result<Map<String, String>> getNicknames(@RequestBody List<String> accounts);

      @GetMapping(value = "/api/v1.0.0/user/getAccount")
      Result<List<String>> getAccount(@RequestParam("nickname") String nickname);

      @PostMapping(value = "/api/v1.0.0/users/for/organization")
      List<User4Org> getUnassignedUsers(@RequestBody List<User4Org> exclude);

}
