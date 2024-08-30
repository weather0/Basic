package com.yedam.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired	OrdersDAO dao;
	
	@Override
	public Map insertOrders(List<Orders> orders) {
		int cnt = 0;
		//테이블 입력
		System.out.println(orders);
		
		
		int sCnt = 0;
		List errList = new ArrayList();
		Map resultList = new HashMap();
		
		for (Orders order : orders) {
		    System.out.println(order);
		    
		    int ordPrice = order.getPrice() * order.getOrd_cnt();
		    order.setOrd_price(ordPrice);
		    
		    
		    if (ordPrice >= 1000) {
		        errList.add(order.getCustomer());
		        cnt++;
		    } else {
		        dao.insertOrders(order);
		        cnt++;
		        sCnt++;
		    }
		    
		}
		
		resultList.put("total", cnt);
		resultList.put("success", sCnt);
		resultList.put("errList", errList);
		
		
		return resultList; // 처리 건수 리턴;
	}

}
