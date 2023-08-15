package tw.midterm.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository("favoriteDao")
@Transactional
public class FavoriteDao {

	@Autowired
	private SessionFactory factory;
	
	public Favorite insert(Favorite fBean) {
		Session session = factory.openSession();
		
		if(fBean!=null) {
			session.persist(fBean);
			session.flush();
		}
		
		session.close();
		return fBean;
	}
	
	public List<Favorite> findById(int userid){
		Session session = factory.openSession();
		Query<Favorite> query = session.createQuery("from Favorite where userid=:userid", Favorite.class);	
		query.setParameter("userid",userid);
		List<Favorite> lists = query.list();
		session.close();
		return lists;
	}
	
	public List<Favorite> findAll(){
		Session session = factory.openSession();
		Query<Favorite> query = session.createQuery("from Favorite", Favorite.class);	
		List<Favorite> lists = query.list();
		session.close();
		return lists;
	}
	
	public Favorite update(Favorite fBean) {
		Session session = factory.openSession();
		if(fBean!=null) {
			session.merge(fBean);
			session.flush();
		}
		session.close();
		return fBean;
	}
	
	public boolean deleteById(int favoritelistid) {
		Session session = factory.openSession();
		Favorite resultBean = session.get(Favorite.class, favoritelistid);
		
		if(resultBean!=null) {
			session.remove(resultBean);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
}
