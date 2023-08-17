package tw.midterm.model.report;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository("reportDao")
@Transactional
public class ReportDAO {

	@Autowired
	private SessionFactory factory;

	public Report insert(Report rBean) {
		Session session = factory.openSession();
		
		if (rBean != null) {
			session.persist(rBean);
			session.flush();
		}
		session.close();
		return rBean;
	}

	public List<Report> findById(int reportid) {
		Session session = factory.openSession();
		Query<Report> query = session.createQuery("from Report where reportID=:reportid", Report.class);	
		query.setParameter("reportid",reportid);
		List<Report> lists = query.list();
		session.close();
		return lists;
	}

	public List<Report> findAll() {
		Session session = factory.openSession();
		Query<Report> query = session.createQuery("from Report", Report.class);	
		List<Report> lists = query.list();
		session.close();
		return lists;
	}

	public Report update(Report rBean) {
		Session session = factory.openSession();
		if(rBean!=null) {
			session.merge(rBean);
			session.flush();
		}
		session.close();
		return rBean;
	}

	public boolean deleteById(int reportid) {
		Session session = factory.openSession();
		Report resultBean = session.get(Report.class, reportid);

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