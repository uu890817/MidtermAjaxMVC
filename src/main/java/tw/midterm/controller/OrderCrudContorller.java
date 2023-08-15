package tw.midterm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.midterm.model.order.OrderList;
import tw.midterm.model.order.OrderListService;

@Controller
public class OrderCrudContorller {

	@Autowired
	private OrderListService oService;

	// 新增controller 方法一，利用建構子
	@PostMapping("/order/postinsert")
//	@GetMapping(path = "/order/	")
	@ResponseBody
	public String insert(@RequestParam("orderformid") int orderformid, @RequestParam("classid") int classid,
			@RequestParam("totalprice") int totalprice, @RequestParam("orderliststate") int orderliststate) {
		OrderList insertBean = new OrderList(orderformid, classid, totalprice, orderliststate);
		oService.insert(insertBean);
		return "Insert OK";
	}

	// 新增controller 方法二，利用Bean
	@PostMapping(path = "/order/insert2")
	@ResponseBody
	public OrderList insert(@RequestBody OrderList oBeaan) {
		return oService.insert(oBeaan);
	}

	// 依id查詢
	@GetMapping(path = "/order/{id}")
	@ResponseBody
	public OrderList query(@PathVariable("id") int id) {
		OrderList resultBean = oService.findById(id);
		if (resultBean != null) {
			return resultBean;
		}
		OrderList nullId = new OrderList();
		nullId.setOrderListID(-1);
		return nullId;
	}

	// 全部查詢
	@GetMapping("/order")
	@ResponseBody
	public List<OrderList> queryAll() {
		return oService.findAll();
	}

	// 更新
	@PutMapping("/order/{id}")
	@ResponseBody
	public String update(@PathVariable("id") int id, @RequestParam("orderformid") int orderformid,
			@RequestParam("classid") int classid, @RequestParam("totalprice") int totalprice,
			@RequestParam("orderliststate") int orderliststate) {
		OrderList updateBean = new OrderList(id, orderformid, classid, totalprice, orderliststate);
		System.out.println("orderListId: " + id);
		System.out.println("orderformid: " + orderformid);
		System.out.println("classid: " + classid);
		System.out.println("totalprice: " + totalprice);
		System.out.println("orderliststate: " + orderliststate);
		oService.update(updateBean);
		return "Update ok!";

	}


	// 刪除
	@DeleteMapping("/order/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		System.out.println("orderListId: " + id);
		oService.deleteById(id);
		return "Delete ok";
	}

}
