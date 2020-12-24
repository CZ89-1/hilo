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
 
  
  
  @RequestMapping("fruitsN")
  public List<Fruit> queryFruitsNew(){
	  return fd.SelectFruitsNew();
  }
  @RequestMapping("fruitsP")
  public List<Fruit> queryFruitsPopular(){
	  return fd.SelectFruitsPopular();
  }
  @RequestMapping("fruitsG")
  public List<Fruit> queryFruitsGuanggao(){
	  return fd.SelectFruitsGuanggao();
  }
  @RequestMapping("fruitsT")
  public List<Fruit> queryFruitsTuijian(){
	  return fd.SelectFruitsTuijian();
  }
  
  @RequestMapping(path="fruit.s",params = "op=queryFruitById")
	public Fruit queryFruitById(int fid){
		return fd.queryFruitById(fid);
	}
	
}
