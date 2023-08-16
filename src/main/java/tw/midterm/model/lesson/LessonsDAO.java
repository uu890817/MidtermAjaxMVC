package tw.midterm.model.lesson;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class LessonsDAO {
	@Autowired
	private SessionFactory factroy;
	
	//新增資料
	public Lessons insert(Lessons lBean) {
		Session session = factroy.openSession();
		
		if(lBean!=null) {
			session.persist(lBean);
			session.flush();
		}
		session.close();
		return lBean;
	}
	
	//靠ID查詢資料
	public Lessons findByClassId(int classid) {
		Session session = factroy.openSession();
		
		Lessons resultBean = session.get(Lessons.class,classid);
		session.close();
		return resultBean;
	}
	
	//查詢全部資料
	public List<Lessons> findAll(){
		Session session = factroy.openSession();
		Query<Lessons> query = session.createQuery("from Lessons",Lessons.class);
		List<Lessons> lists = query.list();
		session.close();
		return lists;
	}
	
	//修改資料
	public Lessons update(Lessons lBean) {
		Session session = factroy.openSession();
		if(lBean!=null) {
			session.merge(lBean);
			session.flush();
		}
		session.close();
		return lBean;
	}
	
	//刪除資料
	public boolean deleteById(int classid) {
		Session session = factroy.openSession();
		Lessons resultBean = session.get(Lessons.class,classid);
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
