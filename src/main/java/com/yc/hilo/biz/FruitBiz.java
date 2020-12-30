package com.yc.hilo.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.hilo.dao.FruitsDao;
import com.yc.hilo.po.Fruit;
import com.yc.hilo.po.User;
import com.yc.hilo.util.Utils;



@Service
public class FruitBiz {
	
	@Resource
	private FruitsDao fd;

	@Transactional
	public void create(Fruit f) throws BizException{
		// 验证输入
		Utils.checkNull(f.getFname(), "商品名称不能为空");
		Utils.checkNull(f.getfImage(), "商品图片不能为空");
		Utils.checkNull(f.getFprice(), "商品商城价不能为空");
		Utils.checkNull(f.getFnprice(), "商品销售价不能为空");
		Utils.checkNull(f.getFdesc(), "商品描述不能为空");
		
		
		// 添加到数据库
		fd.insert(f);
	}

	public List<?> queryFruitByfname(String fname) {
		System.out.println(fname);
		return fd.queryFruitByFname(fname);
	}
	
	public void SaveFruit(String fid,String fname,String fprice,String fnprice,String fImage,String fdesc,String hot,String guanggao,String cid) throws BizException, SQLException {
		// 字段验证
		
		Utils.checkNull(fname, "商品名不能为空");
		Utils.checkNull(fprice, "现价为空");
		Utils.checkNull(fnprice, "原价为空");
		Utils.checkNull(fImage, "照片为空");
		Utils.checkNull(fdesc, "描述不能为空");
		
		
		try {
			
			fd.SaveFruit(fid, fname, fprice, fnprice, fImage, fdesc, hot, guanggao, cid);
		} catch (SQLException e) {
			throw new BizException("修改商品失败",e);
		}
	}
	
}