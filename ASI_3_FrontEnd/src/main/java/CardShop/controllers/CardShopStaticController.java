package CardShop.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class CardShopStaticController {

	@RequestMapping("/")
	public String Home() {
		return "redirect:/cardHome.html";
	}

}


