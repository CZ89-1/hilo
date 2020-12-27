package com.yc.hilo.web;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.biz.BizException;
import com.yc.hilo.biz.FruitBiz;
import com.yc.hilo.dao.FruitsDao;
import com.yc.hilo.po.Fruit;
import com.yc.hilo.po.Result;

@RestController
public class FruitsAction {
	
	
  @Resource
  private FruitsDao fd;
 
  @Resource
  private FruitBiz fb;
  
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
  @RequestMapping(path="fruits.s",params = "op=queryFruits")
	public List<Fruit> queryFruitByCid(int cid){
		return fd.queryFruitByCid(cid);

	}
  
  //后台添加商品
  @RequestMapping("createFruit")
	public Result create(Fruit f) {
		try {
			fb.create(f);
			return Result.success("商品添加成功!");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
  //后台删除商品
  @RequestMapping(path="fruit.do",params = "op=del")
	public Result del(int fid) {
		fd.delFruit(fid);
		return Result.success("商品删除成功!");
		
	}
    //后台查询所有商品
	@RequestMapping("queryFruit")
	public List<Fruit> queryAllF(){
		return fd.queryFruit();
	}
	
}
