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

import tw.midterm.model.lesson.Lessons;
import tw.midterm.model.lesson.LessonsService;

@Controller
public class LessonsController {
	
	@Autowired
	private LessonsService lService;
	
	//CRUD的新增
	@PostMapping(path="/lessons",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Lessons insertAction(@RequestParam("teacherID")int teacherID,@RequestParam("classTypeID")int classTypeID,
							   @RequestParam("classContent")String classContent,@RequestParam("className")String className,
							   @RequestParam("classInfo")String classInfo,@RequestParam("lessonType")String lessonType,
							   @RequestParam("price")double price) {
		Lessons insertBean= new Lessons(teacherID, classTypeID, classContent, className, classInfo, lessonType, price);
		lService.insert(insertBean);
		return insertBean;
	}
	//使用JSON格式轉成Bean資料新增
	@PostMapping(path="/lessons2",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Lessons insertAction(@RequestBody Lessons lBean) {
		return lService.insert(lBean);
	}
	//CRUD的單筆查詢
	@GetMapping(path="/lessons/{cid}",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Lessons queryAction(@PathVariable("cid")int cid) {
		Lessons resultBean = lService.findByClassId(cid);
		
		if(resultBean!=null) {
			return resultBean;
		}
		return null;
	}
	//CRUD的查詢全部
	@GetMapping("/lessons")
	@ResponseBody
	public List<Lessons> queryAllAction(){
		return lService.findAll();
	}
	//CRUD的修改
	@PutMapping(path="/lessons/{cid}",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Lessons updateAction(@PathVariable("cid")int cid,@RequestParam("teacherID")int teacherID,@RequestParam("classTypeID")int classTypeID,
			   @RequestParam("classContent")String classContent,@RequestParam("className")String className,
			   @RequestParam("classInfo")String classInfo,@RequestParam("lessonType")String lessonType,
			   @RequestParam("price")double price) {
		Lessons updateBean = new Lessons(cid,teacherID,classTypeID,classContent,className,classInfo,lessonType,price);
		lService.update(updateBean);
		return updateBean;
	}
	//CRUD的刪除
	@DeleteMapping(path="/lessons/{cid}",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteAction(@PathVariable("cid")int cid) {
		lService.deleteById(cid);
		return "刪除成功";
	}
}
