package com.lingting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingting.model.User;
import com.lingting.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/demo")
@Api(value = "demo", tags = "测试模块")
public class DemoController {

	/**
	 * @ApiOperation：用在请求的方法上，说明方法的用途、作用 value="说明方法的用途、作用" notes="方法的备注说明"
	 * @ApiImplicitParams：用在请求的方法上，表示一组参数说明
	 * @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面 name：参数名
	 *                                                         value：参数的汉字说明、解释
	 *                                                         required：参数是否必须传
	 *                                                         paramType：参数放在哪个地方 ·
	 *                                                         header -->
	 *                                                         请求参数的获取：@RequestHeader
	 *                                                         · query -->
	 *                                                         请求参数的获取：@RequestParam
	 *                                                         ·
	 *                                                         path（用于restful接口）-->
	 *                                                         请求参数的获取：@PathVariable
	 *                                                         · body（不常用） ·
	 *                                                         form（不常用）
	 *                                                         dataType：参数类型，默认String，其它值dataType="Integer"
	 *                                                         defaultValue：参数的默认值
	 * 
	 * @ApiResponses：用在请求的方法上，表示一组响应
	 * @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息 code：数字，例如400
	 *                                               message：信息，例如"请求参数没填好"
	 *                                               response：抛出异常的类
	 * 
	 * @ApiModel：用于响应类上，表示一个返回响应数据的信息 （这种一般用在post创建的时候，使用@RequestBody这样的场景，
	 *                                请求参数无法使用@ApiImplicitParam注解进行描述的时候）
	 * @ApiModelProperty：用在属性上，描述响应类的属性
	 * @return
	 */

	@Autowired
	private UserService userService;

	@ApiOperation(value = "单用户查询", notes = "单用户查询")
	@GetMapping("/demo")
	public String demo() {
		User user = userService.selectByKey(2);
		System.out.println(user);
		return "hello word: " + user;
	}

	@ApiOperation(value = "用户插入", notes = "用户插入")
	@ApiImplicitParam(name="user", value="User", required=true, dataType="User")
	@PostMapping("/insert")
	public String insert(@RequestBody User user) {
		/*User user = new User();
		user.setUserName("赵六");
		user.setUserPwd("123456");*/
		int index = userService.insert(user);
		System.out.println(user);
		return "hello word: " + user;
	}

	@ApiOperation(value = "用户分页查询", notes = "用户分页查询")
	@ApiImplicitParams(value={
			@ApiImplicitParam(name="pageNum", value="页码", required=true, dataType="int"),
			@ApiImplicitParam(name="pageSize", value="每页显示数量", required=true, dataType="int")
	})
	@PostMapping("/queryAll")
	public String queryAll(int pageNum, int pageSize) {
		List<User> users = userService.selectAll(pageNum, pageSize);
		System.out.println(users);
		return "hello word: " + users;
	}
}
