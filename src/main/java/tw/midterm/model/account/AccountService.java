package tw.midterm.model.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountDao aDao;
	
	public AccountBean insert(AccountBean aBean) { 
		return aDao.insert(aBean);
	}
	
	public AccountBean checkLogin(AccountBean aBean) {
		return aDao.checkLogin(aBean);
	}
	
	public List<AccountBean> findAll(){
		return aDao.findAll();
	}
	
	public AccountBean findById(int id){
		return aDao.findById(id);
	}
	
	public AccountBean update(AccountBean aBean) {
		return aDao.update(aBean);
	}
	
	public boolean deleteById(int id) {
		return aDao.deleteById(id);
	}

}
