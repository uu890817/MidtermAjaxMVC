package tw.midterm.model.order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrderListDao {

	@Autowired
	private SessionFactory factory;

	// 新增
	public OrderList insert(OrderList oBean) {
		Session session = factory.openSession();
		if (oBean != null) {
			session.persist(oBean);
			session.flush();
		}
		session.close();
		return oBean;
	}

	// 單筆查詢
	public OrderList findById(int id) {
		Session session = factory.openSession();
		OrderList rb = session.get(OrderList.class, id);
		session.close();
		return rb;
	}

	// 多筆查詢
	public List<OrderList> findAll() {
		Session session = factory.openSession();
		Query<OrderList> query = session.createQuery("from OrderList", OrderList.class);
		List<OrderList> lists = query.list();
		session.close();
		return lists;
	}

	// 修改
	public OrderList update(OrderList oBean) {
		Session session = factory.openSession();
		if (oBean != null) {
			session.merge(oBean);
			session.flush();
		}
		session.close();
		return oBean;
	}

	// 刪除
	public boolean deleteById(int id) {
		Session session = factory.openSession();
		OrderList rb = session.get(OrderList.class, id);
		if (rb != null) {
			session.remove(rb);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
}
