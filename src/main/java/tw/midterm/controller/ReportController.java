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

import tw.midterm.model.report.*;

@Controller
public class ReportController {
	@Autowired
	private ReportService rService;

	@PostMapping(path = "/report")
	@ResponseBody
	public Report processInsertAction(@RequestBody Report rBean) {
		return rService.insert(rBean);
	}

	@GetMapping("/report/{rid}")
	@ResponseBody
	public List<Report> processQueryUserAction(@PathVariable("rid") int rid) {
		return rService.findById(rid);
	}

	@GetMapping("/report")
	@ResponseBody
	public List<Report> processQueryAllAction() {
		return rService.findAll();
	}

	@PutMapping("/report/{rid}")
	@ResponseBody
	public String processUpdateAction(@PathVariable("rid") int rid, @RequestParam("ReportContent") String rc) {
		List<Report> findById = rService.findById(rid);
		Report report = findById.get(0);
		report.setReportContent(rc);
		rService.update(report);
		return "Update OK";
	}

	@DeleteMapping("/report/{rid}")
	@ResponseBody
	public String processDeleteAction(@PathVariable("rid") int rid) {
		rService.deleteById(rid);
		return "Delete OK";
	}
}
