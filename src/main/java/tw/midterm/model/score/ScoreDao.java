package tw.midterm.model.score;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ScoreDao {

	@Autowired
	private SessionFactory factory;
	
	public Score insert(Score sBean) {
		Session session = factory.openSession();
		if(sBean!=null) {
			session.persist(sBean);
			session.flush();
		}
		session.close();
		return sBean;
	}
	
	public List<Score> findById(int orderlistid) {
		Session session = factory.openSession();
		Query<Score> query = session.createQuery("from Score where orderlistid=:orderlistid",Score.class);
		query.setParameter("orderlistid", orderlistid);
		List<Score> lists = query.list();
		session.close();
		return lists;
		
	}
	
	public List<Score> findAll() {
		Session session = factory.openSession();
		Query<Score> query = session.createQuery("from Score",Score.class);
		List<Score> lists = query.list();
		session.close();
		return lists;
		
	}
	
	public Score update(Score sBean) {
		Session session = factory.openSession();
		if(sBean!=null) {
			session.merge(sBean);
			session.flush();
		}
		session.close();
		return sBean;
	}
	
	public boolean deleteById(int orderlistid) {
		Session session = factory.openSession();
		Score resultBean = session.get(Score.class, orderlistid);
		
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
