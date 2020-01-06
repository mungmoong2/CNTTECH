package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.service.SalesService;
import com.my.vo.JanEarnings;
import com.my.vo.Search;

@Controller
public class SalesController {
	@Autowired
	private SalesService service;

	@PostMapping("/detailSearch")
	public ModelAndView detailList(Search search) {
		System.out.println(search.toString());
		ModelAndView mnv = new ModelAndView();
		List<JanEarnings> list = service.Detail(search);
		mnv.addObject("status", 1);
		mnv.addObject("list", list);
		mnv.setViewName("detailresult.jsp");
		return mnv;
	}

	@PostMapping("/countSearch")
	public ModelAndView countList(Search search) {
		System.out.println(search.toString());
		ModelAndView mnv = new ModelAndView();
		List<JanEarnings> list = service.Count(search);
		mnv.addObject("status", 1);
		mnv.addObject("list", list);
		mnv.setViewName("countresult.jsp");
		return mnv;

	}

	@PostMapping("/monthlyCountList")
	public ModelAndView monthlyCount(Search search) {
		System.out.println(search.toString());
		ModelAndView mnv = new ModelAndView();
		List<JanEarnings> list = service.Monthly(search);
		mnv.addObject("status", 1);
		mnv.addObject("list", list);
		mnv.addObject("startDate",search.getStartDate());
		System.out.println(search.getStartDate());
		mnv.setViewName("monthlyresult.jsp");
		return mnv;

	}

}
