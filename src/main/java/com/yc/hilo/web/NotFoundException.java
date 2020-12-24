package com.yc.hilo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

@Controller
public class NotFoundException implements ErrorController{
	
	public Object error() {
		Map<String,Object> map =new HashMap<>();
		map.put("error", "not found");
		map.put("code", "404");
		return map;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
