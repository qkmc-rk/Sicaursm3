package com.rk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rk.model.User;
import com.rk.service.UserService;
import com.rk.util.logindata.AdminLoginData;


@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * 用户登录方法
	 * @return
	 */
	public String userlogin() {
		return "/user/login";
		
	}
	//登录动作
	@ResponseBody
	@RequestMapping(value="loginin",method=RequestMethod.POST)
	public String loginin(@RequestParam("account")String account,@RequestParam("password")String password) {
		
		return null;
		
}
	
	/**
	 * 返回用户页面，携带数据
	 */
     @RequestMapping("/index")
	  public ModelAndView toindex(HttpSession session) {
	
		ModelAndView mdv = new ModelAndView();
		//1.增加数据
				User user  = (User)session.getAttribute("user");
				
				mdv.addObject("user", user);
				//2.增加view name
				mdv.setViewName("/user/index");
		         return mdv;
	}
	 

}
