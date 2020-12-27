package com.yc.hilo.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yc.hilo.dao.PayDao;


@RestController
public class PayAction {
	@Resource
	private PayDao pd;
	
	@RequestMapping(path="pay.s" ,params = "op=queryOid")
	public void updateOid(int oid) {
		pd.queryOid(oid);
	}
}
