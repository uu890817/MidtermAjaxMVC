package tw.midterm.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderListService {

	@Autowired
	private OrderListDao oDao;

	public OrderList insert(OrderList oBean) {
		return oDao.insert(oBean);
	}

	public OrderList findById(int id) {
		return oDao.findById(id);
	}

	public List<OrderList> findAll() {
		return oDao.findAll();
	}

	public OrderList update(OrderList oBean) {
		return oDao.update(oBean);
	}
	
	public boolean deleteById(int id) {
		return oDao.deleteById(id);
	}
}
