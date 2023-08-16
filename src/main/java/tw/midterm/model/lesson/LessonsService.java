package tw.midterm.model.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LessonsService {
	@Autowired
	private LessonsDAO lDAO;
	//新增
	public Lessons insert(Lessons lBean) {
		return lDAO.insert(lBean);
	}
	//單筆查詢
	public Lessons findByClassId(int classid) {
		return lDAO.findByClassId(classid);
	}
	//查詢全部
	public List<Lessons> findAll(){
		return lDAO.findAll();
	}
	//修改
	public Lessons update(Lessons lBean) {
		return lDAO.update(lBean);
	}
	//刪除
	public boolean deleteById(int classid) {
		return lDAO.deleteById(classid);
	}
}
