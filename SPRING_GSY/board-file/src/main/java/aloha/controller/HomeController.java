package aloha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	//home
	@GetMapping( {"/", ""} )
	public String home(Model model) {
//		 �𵨿� �Ӽ� �߰�
		model.addAttribute("welcome", "�ȳ��ϼ���");
		return "index";
	}
}
