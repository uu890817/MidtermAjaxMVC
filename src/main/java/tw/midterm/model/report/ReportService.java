package tw.midterm.model.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReportService {
	@Autowired
	private ReportDAO rDao;
	
	public Report insert(Report rBean) {
		return rDao.insert(rBean);
	}
	
	public List<Report> findById(int reportid) {
		return rDao.findById(reportid);
	}

	public List<Report> findAll(){
		return rDao.findAll();			
	}
	
	public Report update(Report pBean) {
		return rDao.update(pBean);
	}
	
	public boolean deleteById(int reportid) {
		return rDao.deleteById(reportid);
	}
}
