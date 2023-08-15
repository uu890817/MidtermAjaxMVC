package tw.midterm.model.order;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "OrderList")
public class OrderList {
	
	@Id
	@Column(name = "orderListID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderListID;
	
	@Column(name = "orderFormID")
	private int orderFormID;
	
	@Column(name = "classID")
	private int classID;

	@Column(name = "totalPrice")
	private int totalPrice;
	
	@Column(name = "orderListState")
	private int orderListState;

	public OrderList() {
	}
	
	

	public OrderList(int orderListID, int orderListState) {
		this.orderListID = orderListID;
		this.orderListState = orderListState;
	}



	public OrderList(int orderListID ,int orderFormID, int classID, int totalPrice, int oderListState) {
		this.orderListID = orderListID;
		this.orderFormID = orderFormID;
		this.classID = classID;
		this.totalPrice = totalPrice;
		this.orderListState = oderListState;
	}
	
	public OrderList(int orderFormID, int classID, int totalPrice, int oderListState) {
		this.orderFormID = orderFormID;
		this.classID = classID;
		this.totalPrice = totalPrice;
		this.orderListState = oderListState;
	}

	public int getOrderListID() {
		return orderListID;
	}

	public void setOrderListID(int orderListID) {
		this.orderListID = orderListID;
	}

	public int getOrderFormID() {
		return orderFormID;
	}

	public void setOrderFormID(int orderFormID) {
		this.orderFormID = orderFormID;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderListState() {
		return orderListState;
	}

	public void setOrderListState(int orderListState) {
		this.orderListState = orderListState;
	}

	public void setOderListState(int orderListState) {
		this.orderListState = orderListState;
	}

}
