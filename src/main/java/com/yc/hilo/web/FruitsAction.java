package com.yc.hilo.web;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.biz.BizException;
import com.yc.hilo.biz.FruitBiz;
import com.yc.hilo.dao.FruitsDao;
import com.yc.hilo.po.Fruit;
import com.yc.hilo.po.Result;
import com.yc.hilo.po.User;

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
  
  @RequestMapping(path="fruitss")
	public List<Fruit> queryFruit(int pageNum,int pageSize) {
		return fd.queryFruit(pageNum,pageSize); 
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
  @RequestMapping(path="fruit.s",params ="op=deleteFruit")
  public Result del(int fid) {
		fd.delFruit(fid);
		return Result.success("商品删除成功!");
		
	}
    //后台查询所有商品
	@RequestMapping("queryFruit")
	public List<Fruit> queryAllF(){
		return fd.queryFruit();
	}
	
   @RequestMapping(path="queryfnames")
   public Result queryFruitByfname(String fname){
	   System.out.println("fname:"+fname);
  	  if(fname.equals("")) {
  		  return new Result(0,"请输入你想搜索的物品");
  	  }else {
  		  List<?> list = fb.queryFruitByfname(fname);
  		  System.out.println(list);
  		  if(list.isEmpty()) {
  			  return new Result(0,"没有搜索到您想要的商品");
  		  }else {
  			  return new Result(1,"搜索成功");
  		  }
  	  }
   }
   @RequestMapping(path="search.s")
   public List<Fruit> queryByfname(String fname){
	   return fd.queryByfname(fname);
   }
 
  
  @RequestMapping(path="fruit.s",params = "op=queryFruitByCid")
	public List<Fruit> queryProductByCid(int cid,int pageNum,int pageSize){
		return fd.queryFruitByCid(cid,pageNum,pageSize);
	}
  
  @RequestMapping(path="fruit",params = "op=queryCount")
  public int getFruitsTotalNum() {
	  return fd.getFruitsTotalNum();
  }
  
  //后台商品修改
  @RequestMapping(path="saveFruit.s" ,params = "op=save")
	public Result SaveFruit(String fid,String fname,String fprice,String fnprice,String fImage,String fdesc,String hot,String guanggao,String cid,HttpSession session) throws SQLException, BizException {
		
		
		fb.SaveFruit(fid, fname, fprice, fnprice, fImage, fdesc, hot, guanggao, cid);
		
		
		return Result.success("修改信息成功!");
		
	}


}
