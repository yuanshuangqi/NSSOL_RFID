package com.nssol.controller.metalcheck;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nssol.model.TMetalcheck;
import com.nssol.model.TMstDictionary;
import com.nssol.model.T_Bagging;
import com.nssol.service.TMstDictionaryService;
import com.nssol.service.bagging.TBaggingService;
import com.nssol.service.metalcheck.TMetalcheckService;


@Controller
public class TMetalcheckPageController {
	
	private TMetalcheck tMetalcheckCommon;
	@Autowired
	private TMetalcheckService metalcheckService;
	
	@Autowired
	private TMstDictionaryService dictService;
	
	 @RequestMapping("/metalcheckSearch")
	 public String setForm() {
		 tMetalcheckCommon=new TMetalcheck();
		 return "redirect:/metalcheckSearchPage?currPage=1";
		}
	 
	 
	 @RequestMapping("/metalcheckSearchQuery")
	 public String setQuery(@RequestParam(name = "currPage", defaultValue = "1") Integer currPage,TMetalcheck metalcheck,Model model) {
		 TMetalcheck metalcheckInput = new TMetalcheck();
		    metalcheck.setCurrentPageNumber(currPage);
			BeanUtils.copyProperties(metalcheck, metalcheckInput);
			//bagInput.setCurrentPageNumber(bagging.getCurrentPageNumber()+1);
			metalcheckInput.setCurrentPageShowCounts(10);
	        tMetalcheckCommon =metalcheckInput;
	        
	        List<TMetalcheck> metalcheckPut = metalcheckService.getMetalcheckPage(metalcheckInput);
	        TMstDictionary mstDict = new TMstDictionary();
	        mstDict.setDicType("MetalCheck");
			List<TMstDictionary> dicList = dictService.getMstDictionary(mstDict);
			
	        if(metalcheckPut!=null && !metalcheckPut.isEmpty() && metalcheckPut.size()>0)
	        {
		        model.addAttribute("data", metalcheckPut); //前端要展示的数据
		        model.addAttribute("searchdata", metalcheck); //前端要展示的数据
		        model.addAttribute("ddldata", dicList); //前端要展示的数据
		        model.addAttribute("currPage", metalcheckPut.get(0).getCurrentPageNumber()); //当前页
		        model.addAttribute("totalPage", metalcheckPut.get(0).getPagesCount()); //总页页数
	        }else {
	        	   model.addAttribute("data", null); //前端要展示的数据
	        	   model.addAttribute("searchdata", metalcheck); //前端要展示的数据
	        	   model.addAttribute("ddldata", dicList); //前端要展示的数据
			       model.addAttribute("currPage", 1); //当前页
			       model.addAttribute("totalPage", 1); //总页页数
	        }
	        return "metalcheckSearch";
	        
		}
	 
	 @RequestMapping("/metalcheckSearchPage")
	 public String getForm(@RequestParam(name = "currPage") Integer currPage,Model model) {
		 if(tMetalcheckCommon==null) {
			 tMetalcheckCommon=new TMetalcheck();
		 }
		 TMetalcheck bagInput = tMetalcheckCommon;
	       
		    bagInput.setCurrentPageNumber(currPage);	
		    bagInput.setCurrentPageShowCounts(10);
	
	        List<TMetalcheck> metalcheckPut = metalcheckService.getMetalcheckPage(bagInput);
	        TMstDictionary mstDict = new TMstDictionary();
	        mstDict.setDicType("MetalCheck");
			List<TMstDictionary> dicList = dictService.getMstDictionary(mstDict);
	        if(metalcheckPut!=null && !metalcheckPut.isEmpty() && metalcheckPut.size()>0)
	        {
		        model.addAttribute("data", metalcheckPut); //前端要展示的数据
		        model.addAttribute("searchdata", bagInput); //前端要展示的数据
		        model.addAttribute("ddldata", dicList); //前端要展示的数据
		        model.addAttribute("currPage", currPage); //当前页
		        model.addAttribute("totalPage", metalcheckPut.get(0).getPagesCount()); //总页页数
	        }else {
	        	   model.addAttribute("data", null); //前端要展示的数据
	        	   model.addAttribute("searchdata", bagInput); //前端要展示的数据
	        	   model.addAttribute("ddldata", dicList); //前端要展示的数据
			       model.addAttribute("currPage", 1); //当前页
			       model.addAttribute("totalPage", 1); //总页页数
	        }
	        return "metalcheckSearch";
		}

}
