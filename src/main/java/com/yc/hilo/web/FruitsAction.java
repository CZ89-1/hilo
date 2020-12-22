package com.yc.hilo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.dao.FruitsDao;
import com.yc.hilo.po.Fruit;

@RestController
public class FruitsAction {
  @Resource
  private FruitsDao fd;
  
  @RequestMapping("fruits")
  public List<Fruit> queryFruits(){
	  return fd.SelectFruits();
  }
	
}
