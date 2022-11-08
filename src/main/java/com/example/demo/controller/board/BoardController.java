package com.example.demo.controller.board;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.board.Board;
import com.example.demo.repository.board.BoardJpaRepo;

@Controller
public class BoardController {

	@Autowired
	BoardJpaRepo boardJpaRepo;
	
	//글 전체 조회하기
	@GetMapping("/findAllBoards")
	@ResponseBody
	public List<Board> findAllBoards() {
		return boardJpaRepo.findAll();
	}
	
	//글 내용 조회하기
	@GetMapping("/findBoard/{id}")
	@ResponseBody
	public Board findAllBoards(@PathVariable Long id) {
		Optional<Board> optionalBoard = boardJpaRepo.findById(id);
		if(optionalBoard.isPresent()) {
			return optionalBoard.get();
		}
		return null;
	}
	
	//글 쓰기
	//글 지우기
	//글 수정하기
}
