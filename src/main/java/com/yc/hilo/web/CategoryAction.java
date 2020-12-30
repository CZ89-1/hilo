package com.yc.hilo.web;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.dao.CategoryDao;
import com.yc.hilo.po.Category;



@RestController
public class CategoryAction {

	@Resource
	private CategoryDao cdao;
	@RequestMapping("queryCategory")
	public List<Category> queryCategory(){
		return cdao.queryCategory();
		
	}
	

}
