package com.dlq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestExceptionController {

	@RequestMapping(value="/testException",method=RequestMethod.GET)
	private String testException() {
		return "success";
	}
}
