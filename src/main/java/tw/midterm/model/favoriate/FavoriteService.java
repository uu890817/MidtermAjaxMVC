package tw.midterm.model.favoriate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FavoriteService {
	
	@Autowired
	private FavoriteDao fDao;
	
	public Favorite insert(Favorite fBean) {
		return fDao.insert(fBean);
	}
	
	public List<Favorite> findById(int userid) {
		return fDao.findById(userid);
	}

	public List<Favorite> findAll(){
		return fDao.findAll();			
	}
	
	public Favorite update(Favorite pBean) {
		return fDao.update(pBean);
	}
	
	public boolean deleteById(int favoritelistid) {
		return fDao.deleteById(favoritelistid);
	}

}
