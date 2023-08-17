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

import tw.midterm.model.score.Score;
import tw.midterm.model.score.ScoreService;





@Controller
public class ScoreController {

	@Autowired
	private ScoreService sService;
	
	@PostMapping(path = "/score")
	@ResponseBody
	public Score processInsertAction(@RequestBody Score sBean) {
		return sService.insert(sBean);
	}
	
	@GetMapping("/score/{sid}")
	@ResponseBody
	public List<Score> processQueryScoreAction(@PathVariable("sid") int orderlistid){
		return sService.findById(orderlistid);
	}
	
	@GetMapping("/score")
	@ResponseBody
	public List<Score> processQueryAllAction() {
		return sService.findAll();
	}
	
	@PutMapping("/score/{olid}")
	@ResponseBody
	public String processUpdateAction(@PathVariable("olid") int olid,
									  @RequestParam("ofid") int ofid,
									  @RequestParam("classid") int classid,
									  @RequestParam("reviewsore") int reviewsore,
									  @RequestParam("reviewcontent") String reviewcontent,
									  @RequestParam("reviewdate") String reviewdate) {
		Score updateBean = new Score(olid,ofid,classid,reviewsore,reviewcontent,reviewdate);
		sService.update(updateBean);
		return "Update Ok";
	}
	
	@DeleteMapping("/score/{olid}")
	@ResponseBody
	public String processDeleteAction(@PathVariable("olid") int olid) {
		sService.deleteById(olid);
		return "Delete Ok";
	}
	
}
