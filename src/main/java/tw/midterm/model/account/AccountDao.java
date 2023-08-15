package tw.midterm.model.account;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDao {
	@Autowired
	private SessionFactory factory;
	
//-----------------------------------------------	
	public AccountBean insert(AccountBean aBean) {
		Session session = factory.openSession();
		
		if(aBean!=null) {
			session.persist(aBean);
			session.flush();
		}
		session.close();
		return aBean;
	}
	
	public AccountBean checkLogin(AccountBean aBean) {
		Session session = factory.openSession();
		String hql = "FROM AccountBean WHERE userName= :username AND password= :password ";
		
		Query<AccountBean> query = session.createQuery(hql, AccountBean.class);
		System.out.println("getUserName" + aBean.getUserName());
		System.out.println("getPassword" + aBean.getPassword());
		query.setParameter("username", aBean.getUserName());
		query.setParameter("password", aBean.getPassword());
		AccountBean resultBean = query.uniqueResult();
		session.close();
		
		if(resultBean!=null) {
			return resultBean;
		}
		return null;
	}
	
	public List<AccountBean> findAll(){
		Session session = factory.openSession();
		Query<AccountBean> query = session.createQuery("from AccountBean", AccountBean.class);		
		List<AccountBean> lists = query.list();
		session.close();
		return lists;
	}
	
	
	public AccountBean findById(int id){
		Session session = factory.openSession();
		AccountBean aBean = session.get(AccountBean.class, id);
		session.close();
		return aBean;
	}
	
	public AccountBean update(AccountBean aBean) {
		Session session = factory.openSession();
		
		if(aBean!=null) {
			session.merge(aBean);
			session.flush();
		}
		
		session.close();
		return aBean;
	}
	
	public boolean deleteById(int id) {
		Session session = factory.openSession();
		AccountBean resultBean = session.get(AccountBean.class, id);
		
		if(resultBean!=null) {
			session.remove(resultBean);
			session.flush();
			session.close();
			return true;
		}
		
		session.close();
		return false;
	}
	
	
	
//	public AccountBean selectById(int userId) {
//		return session.get(AccountBean.class, userId);
//	}
//	
//	public List<AccountBean> selectByUserName(String userName) {
//		String hql = "From AccountBean Where userName= :userName";
//		
//		Query<AccountBean> query = session.createQuery(hql, AccountBean.class);
//	    query.setParameter("userName", userName);
//	    return query.list();
//	}
//	
//	public List<AccountBean> selectAllUser() {
//		String hql = "From AccountBean";
//		Query<AccountBean> query = session.createQuery(hql, AccountBean.class);
//	    return query.list();
//	}
////	--------------------------------------------------------------------------------
//
//	public AccountBean insertOneAccount(AccountBean accountBean) {
//		AccountBean resultBean = session.get(AccountBean.class, accountBean.getUserId());
//		
//		System.out.println((resultBean == null));
//		
//		if(resultBean == null) {
//			session.persist(accountBean);
//			return accountBean;
//		}else {
//			return null;
//		}
//	}
//	
//	
////	--------------------------------------------------------------------------------	
//	
//	public AccountBean updateAccountById(AccountBean accountBean){
//		AccountBean resultBean = session.get(AccountBean.class, accountBean.getUserId());
//		
//		if(resultBean!=null) {
//			resultBean.setUserName(accountBean.getUserName());;
//		}
//		return resultBean;
//	}
//	
//	
////	--------------------------------------------------------------------------------	
//	
//	public boolean deleteById(int userId) {
//		AccountBean resultBean = session.get(AccountBean.class, userId);
//		
//		if(resultBean!=null) {
//			session.remove(resultBean);
//			return true;
//		}
//		return false;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
