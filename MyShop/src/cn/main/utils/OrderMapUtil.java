package cn.main.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;

import cn.main.pojo.Good;
import cn.main.pojo.Order;
import cn.main.pojo.OrderDetails; 
import cn.main.service.GoodService; 
import cn.main.service.serviceimpl.GoodServiceImpl; 
/**
 * 订单
 * @author sff
 *
 */
public class OrderMapUtil {
	private static GoodService goodService = new GoodServiceImpl();

	public static String getJsonBiz(Order order) {
		String title ="共计" + order.getOrderDetails().size() + "件商品:";
		String name = "";
		for (OrderDetails details : order.getOrderDetails()) {
			Good g = goodService.getGoodList(details.getGid(),
					details.getSid(), null, null, null, null, null, null, null)
					.get(0);
			name += g.getName() + ",";
		}
		String code ="{" +
                "\"out_trade_no\":\""+ order.getOrderCode() +"\"," +
                "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "\"total_amount\":\""+order.getPrice()+"\"," +
                "\"subject\":\""+title+"\"," +
                "\"body\":\""+name+"\"" +
                "}";
		return  code;
	} 
}
