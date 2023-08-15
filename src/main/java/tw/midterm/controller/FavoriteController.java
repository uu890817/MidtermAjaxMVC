package tw.midterm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.midterm.model.favoriate.Favorite;
import tw.midterm.model.favoriate.FavoriteService;


@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService fService;
	
	@PostMapping(path = "/favorite")
	@ResponseBody
	public Favorite processInsertAction(@RequestBody Favorite fBean) {
		return fService.insert(fBean);
	}
	
	@GetMapping("/favorite/{uid}")
	@ResponseBody
	public List<Favorite> processQueryUserAction(@PathVariable("uid") int userId){
		return fService.findById(userId);
	}
	
	@GetMapping("/favorite")
	@ResponseBody
	public List<Favorite> processQueryAllAction(){
		return fService.findAll();
	}
	
	@PutMapping("/favorite/{fid}")
	@ResponseBody
	public String processUpdateAction(@PathVariable("fid") int fid, 
										@RequestParam("UserID") int uid, 
										@RequestParam("ClassID") int cid, 
										@RequestParam("FavoriteDate") String favoriteDate,
										@RequestParam("ClassName") String className,
										@RequestParam("ClassPrice") int classPrice) {
		Favorite updateBean = new Favorite(fid,uid, cid, favoriteDate, className,classPrice);
		fService.update(updateBean);
		return "Update OK";
	}
	
	@DeleteMapping("/favorite/{fid}")
	@ResponseBody
	public String processDeleteAction(@PathVariable("fid") int fid) {
		fService.deleteById(fid);
		return "Delete OK";
	}
}
