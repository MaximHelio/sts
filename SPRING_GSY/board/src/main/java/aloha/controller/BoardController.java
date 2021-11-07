package aloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aloha.domain.Board;
import aloha.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;

	//	�Խñ� ���-��ȸ

	//	Spring 4.3 ����
	//	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		//		�Խñ� ��� ��û
		List<Board> list = service.list();
		//		�Խñ� ��� �𵨿� �߰�
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	//	�Խñ� ����-ȭ��
	@GetMapping("/insert")
	public String insertForm(Model model, Board board) throws Exception {
		return "board/insert";
	}
	
	//	�Խñ� ����-ó��
	@PostMapping("/insert")
	public String insert(Model model, Board board) throws Exception {
		log.info(board.toString());
		
		// �Խñ� ���� ��û
		service.insert(board);

		model.addAttribute("msg", "����� �Ϸ�Ǿ����ϴ�");
		
		return "board/success";
	}
	
//	�Խñ� �б�-ȭ��
	@GetMapping("/read")
	public String read(Model model, Integer boardNo) throws Exception {
		// �Խñ� �б� ��û
//		Board board = service.read(boardNo);
		
//		model.addAttribute("board", board);
		
		return "board/read";
	}
	
// 	�Խñ� ����-ȭ��
	@GetMapping("/update")
	public String updateForm(Model model, Integer boardNo) throws Exception {
		
		// �Խñ� �б� ��û
//		Board board = service.read(boardNo);
//		model.addAttribute("board", board);
		return "board/update";
	}
	
//  �Խñ� ���� - ó��
//	�Խñ� ���� - ó��
}
