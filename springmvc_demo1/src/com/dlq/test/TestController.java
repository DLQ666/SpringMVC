package com.dlq.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {						
	
	/**						               					                   
	 * 假设：localhost:8080/springmvc_demo1/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("SUCCESS");
		return "success";
	}

}
