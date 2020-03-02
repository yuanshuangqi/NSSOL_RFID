package com.nssol.controller.bagging;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nssol.model.TMstDictionary;
import com.nssol.model.T_Bagging;
import com.nssol.service.TMstDictionaryService;
import com.nssol.service.bagging.TBaggingService;


@Controller
public class TBaggingPageController {
	
	private T_Bagging tBaggingCommon;
	@Autowired
	private TBaggingService baggingService;
	
	@Autowired
	private TMstDictionaryService dictService;
	
	@RequestMapping("/main")
	 public String main() {
		 tBaggingCommon=new T_Bagging();
		 return "redirect:/baggingSearchPage?currPage=1";
		}
	
	 @RequestMapping("/baggingSearch")
	 public String setForm() {
		 tBaggingCommon=new T_Bagging();
		 return "redirect:/baggingSearchPage?currPage=1";
		}
	 
	 
	 @RequestMapping("/baggingSearchQuery")
	 public String setQuery(@RequestParam(name = "currPage", defaultValue = "1") Integer currPage,T_Bagging bagging,Model model) {
		    T_Bagging bagInput = new T_Bagging();
	        bagging.setCurrentPageNumber(currPage);
			BeanUtils.copyProperties(bagging, bagInput);
			//bagInput.setCurrentPageNumber(bagging.getCurrentPageNumber()+1);
	        bagInput.setCurrentPageShowCounts(10);
	        tBaggingCommon =bagInput;
	        
	        List<T_Bagging> baggingPut = baggingService.getBaggingListPage(bagInput);
	        TMstDictionary mstDict = new TMstDictionary();
	        mstDict.setDicType("Bagging");
			List<TMstDictionary> dicList = dictService.getMstDictionary(mstDict);
			
	        if(baggingPut!=null && !baggingPut.isEmpty() && baggingPut.size()>0)
	        {
		        model.addAttribute("data", baggingPut); //前端要展示的数据
		        model.addAttribute("searchdata", bagging); //前端要展示的数据
		        model.addAttribute("ddldata", dicList); //前端要展示的数据
		        model.addAttribute("currPage", baggingPut.get(0).getCurrentPageNumber()); //当前页
		        model.addAttribute("totalPage", baggingPut.get(0).getPagesCount()); //总页页数
	        }else {
	        	   model.addAttribute("data", null); //前端要展示的数据
	        	   model.addAttribute("searchdata", bagging); //前端要展示的数据
	        	   model.addAttribute("ddldata", dicList); //前端要展示的数据
			       model.addAttribute("currPage", 1); //当前页
			       model.addAttribute("totalPage", 1); //总页页数
	        }
	        return "baggingSearch";
	        
		}
	 
	 @RequestMapping("/baggingSearchPage")
	 public String getForm(@RequestParam(name = "currPage") Integer currPage,Model model) {
		 if(tBaggingCommon==null) {
			 tBaggingCommon=new T_Bagging();
		 }
		    T_Bagging bagInput = tBaggingCommon;
	       
		    bagInput.setCurrentPageNumber(currPage);	
		    bagInput.setCurrentPageShowCounts(10);
	
	        List<T_Bagging> baggingPut = baggingService.getBaggingListPage(bagInput);
	        TMstDictionary mstDict = new TMstDictionary();
	        mstDict.setDicType("Bagging");
			List<TMstDictionary> dicList = dictService.getMstDictionary(mstDict);
	        if(baggingPut!=null && !baggingPut.isEmpty() && baggingPut.size()>0)
	        {
		        model.addAttribute("data", baggingPut); //前端要展示的数据
		        model.addAttribute("searchdata", bagInput); //前端要展示的数据
		        model.addAttribute("ddldata", dicList); //前端要展示的数据
		        model.addAttribute("currPage", currPage); //当前页
		        model.addAttribute("totalPage", baggingPut.get(0).getPagesCount()); //总页页数
	        }else {
	        	   model.addAttribute("data", null); //前端要展示的数据
	        	   model.addAttribute("searchdata", bagInput); //前端要展示的数据
	        	   model.addAttribute("ddldata", dicList); //前端要展示的数据
			       model.addAttribute("currPage", 1); //当前页
			       model.addAttribute("totalPage", 1); //总页页数
	        }
	        return "baggingSearch";
		}

}
