package com.example.demo.controller;

import com.example.demo.common.Msg;
import com.example.demo.annotation.MySysLog;
import com.example.demo.common.ReturnResult;
import com.example.demo.controller.form.UserForm;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author hongtao.hao
 * @date 2019/6/27
 */
@RestController
@RequestMapping("/api/demo/user")
@Api(value = "/demo", tags = "demo", description = "demo test")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "list")
    @ApiResponses({@ApiResponse(code = 200, message = "test success", response = List.class),})
    @GetMapping("/list")
    public ReturnResult list() {

        List<UserDTO> userDTOS = userService.listUser();
        return ReturnResult.createSuccessReturn(userDTOS);
    }

    @ApiOperation(value = "page")
    @ApiResponses({@ApiResponse(code = 200, message = "test success", response = List.class),})
    @GetMapping("/page")
    public ReturnResult page(@RequestParam int start, @RequestParam int offset) {

        PageInfo pageInfo = userService.listPageUser(start, offset);
        return ReturnResult.createSuccessReturn(pageInfo);
    }

    @ApiOperation(value = "save")
    @ApiResponses({@ApiResponse(code = 200, message = "test success", response = List.class),})
    @PostMapping("/save")
    public ReturnResult saveUser(@RequestBody @Valid UserForm userForm) {

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userForm, userDTO);
        userDTO.setUsername(null);
        userService.saveUser(userDTO);
        return ReturnResult.createSuccessReturn();
    }

    @ApiOperation(value = "getUser")
    @ApiResponses({@ApiResponse(code = 200, message = "test success", response = List.class),})
    @PostMapping("/get")
    public ReturnResult getUser(@RequestParam String userName) {

        UserDTO userDTO = userService.getUser(userName);

        return ReturnResult.createSuccessReturn(userDTO);
    }

}
