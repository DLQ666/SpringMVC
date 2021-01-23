package com.dlq.test;

import com.dlq.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {						
	
	/**						               					                   
	 * 假设：localhost:8080/springmvc_demo1/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello(Book book) {
		System.out.println(book);
		return "success";
	}
}
