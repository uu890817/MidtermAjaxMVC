package tw.midterm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import tw.midterm.model.account.AccountBean;
import tw.midterm.model.account.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService aService;

	@GetMapping(path = "/login")
	public String loginPageController(HttpSession session) {

		AccountBean sessionBean = (AccountBean) session.getAttribute("loginUser");
		if (sessionBean != null) {
			return "redirect:/loginPage";
		}
		return "account/login";
	}

	@GetMapping(path = "/register")
	public String registerController(HttpSession session) {

		AccountBean sessionBean = (AccountBean) session.getAttribute("loginUser");
		if (sessionBean != null) {
			return "redirect:/loginPage";
		}
		return "account/register";
	}
	
	@GetMapping(path = "/registerOK")
	public String registerOKController(HttpSession session) {

		AccountBean sessionBean = (AccountBean) session.getAttribute("loginUser");
		if (sessionBean != null) {
			return "account/registerOK";
		}
		return "account/registerOK";
	}
	@GetMapping(path = "/logout")
	public String logoutController(HttpSession session) {

		session.invalidate();
		return "redirect:/login";

	}

	@PostMapping(path = "/login")
	@ResponseBody
	public String loginActionController(@RequestParam String username, @RequestParam String password,
			HttpSession session) {

		AccountBean account = aService.checkLogin(new AccountBean(username, password));

		if (account != null) {
			session.setAttribute("loginUser", account);
			return "OK";
		}
		return "Error";
	}

	@GetMapping(path = "/loginPage")
	public String loginChangePageController(HttpSession session) {
		AccountBean sessionBean = (AccountBean) session.getAttribute("loginUser");

		System.out.println(sessionBean == null);
		if (sessionBean == null) {
			return "redirect:/login";
		}

		if (sessionBean.isAdmin()) {
			return "account/accountManager";
		}
		return "account/userPage";
	}

	@GetMapping(path = "/accountManager")
	@ResponseBody
	public List<AccountBean> getAllAccountController() {
		return aService.findAll();
	}

	@PutMapping(path = "/accountManager")
	@ResponseBody
	public String registerController(@RequestBody AccountBean aBean) {
		aBean.setAdmin(false);
		aBean.setTeacher(false);
		aService.insert(aBean);
		return "OK";
	}

//	@PutMapping(path = "/accountManager")
//	public List<AccountBean> updatAccountController() {G
//		
//		return aService.update();	
//	}

	@DeleteMapping(path = "/accountManager")
	@ResponseBody
	public String deleteAccountByIdController(@RequestParam int id) {
		boolean isDelete = aService.deleteById(id);
		return Boolean.toString(isDelete);
	}
}
