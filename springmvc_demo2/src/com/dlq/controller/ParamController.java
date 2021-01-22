package com.dlq.controller;

import com.dlq.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class ParamController {
		
	/*
	 * 在springMVC获取客户端传递的数据方式：
	 * 1、在处理请求的方法中，加入相对应的形参，保证形参参数名和传递的数据的参数名保持一致，就可以自动赋值
	 * value：当不满足赋值条件时，可以使用value属性，指定映射关系
	 * required：设置形参是否必须被赋值，默认为true，必须赋值，若设置为false，则不必须赋值，因此形参的值为null
	 * defaultValue：若形参所获得的值为null，则设置一个默认值
	 * 
	 */
	/*@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(@RequestParam(value = "name", required = false, defaultValue = "1") String username,
			String password, String age) {
		System.out.println("username=" + username + ",password=" + password + ",age=" + age);
		return "success";
	}*/
	
	/*
	 * @RequestHeader：在处理请求的方法上，获取请求头信息，用法和@RequestParam一致
	 */
	/*@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(@RequestHeader("Accept-Language")String AcceptLanguage) {
		System.out.println("AcceptLanguage=" + AcceptLanguage );
		return "success";
	}*/
	
	/*
	 * @CookieValue：在处理请求的方法上，获取cookie信息，用法和@RequestParam一致
	 */
	/*@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(@CookieValue(value="JSESSIONID")String JSESSIONID) {
		System.out.println("JSESSIONID=" + JSESSIONID );
		return "success";
	}*/
	
	/*
	 * 可以使用POJO获取客户端数据，要求实体类对象中的属性名一定要和页面中表单元素的name属性值一致，且支持级联关系
	 * 可以通过形参的方式，获取servletAPI
	 */
	/*@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(User user, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		System.out.println("testServletApi："+response.getStatus());
//		System.out.println(user);
		System.out.println(username);
		return "success";
	}*/
	
	
	/*
	 * springMVC处理请求过程中，往作用域中放值有以下三种方式
	 * 总结：根据ModelAndView源码调试，不管使用以下哪种方式，最终都会把Model数据和view数据封装到一个ModelAndView中
	 */
	/*@RequestMapping(value = "/param", method = RequestMethod.POST)
	public ModelAndView param() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "root");//往request作用域中放值
		mav.setViewName("success");//设置视图名称，实现页面跳转
		return mav;
	}*/
	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(Map<String ,Object> map, Model model, ModelMap modelMap) {
		map.put("map", "java.util.Map");//向作用域中放值
		model.addAttribute("model","org.springframework.ui.Model");
		modelMap.addAttribute("modelMap","org.springframework.ui.ModelMap");

		System.out.println(map== model);
		System.out.println(map== modelMap);
		System.out.println(model== modelMap);

		System.out.println(map.getClass().getName());
		System.out.println(model.getClass().getName());
		System.out.println(modelMap.getClass().getName());

		return "success";//返回视图名称
	}
	
	/*@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(Model model) {
		model.addAttribute("username", "张三");//向作用域中放值
		return "success";//返回视图名称
	}*/
}
