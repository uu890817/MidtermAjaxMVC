package tw.midterm.model.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScoreService {
	
	@Autowired
	private ScoreDao sDao;
	
	public Score insert(Score sBean) {
		return sDao.insert(sBean);
	}
	
	public List<Score> findById(int orderlistid){
		return sDao.findById(orderlistid);
	}
	
	public List<Score> findAll() {
		return sDao.findAll();
	}

	public Score update(Score sBean) {
		return sDao.update(sBean);
	}
	
	public boolean deleteById(int orderlistid) {
		return sDao.deleteById(orderlistid);
	}
}
