package com.carl.rdj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CMain {
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String index() {
		return "HOLA :D";
	}
}
