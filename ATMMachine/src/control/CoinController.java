package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.service.CoinService;
import com.my.vo.Coin;
import com.my.vo.Machine;

@Controller
public class CoinController {
	@Autowired
	private CoinService service;

	@PostMapping("/coin")
	public ModelAndView doCoinChange(@ModelAttribute Coin coin, int price) {
		List<List<Coin>> list = service.changeList(coin, price);
		ModelAndView mnv = new ModelAndView();
		mnv.addObject("status", 1);
		mnv.addObject("list", list);
		mnv.addObject("price", price);
		mnv.setViewName("result.jsp");
		return mnv;
	}

}
