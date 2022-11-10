package com.example.demo.controller.board;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.board.Board;
import com.example.demo.service.board.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class BoardController {

	//@Autowired
	//BoardJpaRepo boardJpaRepo;
	
	@Autowired
	BoardService boardService;
	
	//글 전체 조회하기
	/*
	public List<Board> findAllBoards() {
		return boardJpaRepo.findAll();
	}
	*/
	@GetMapping("/findAllBoards")
	@ResponseBody
	public void findAllBoards() {
		
	}
	
	//글 내용 조회하기
	/*
	 public Board findAllBoards(@PathVariable Long id) {
		Optional<Board> optionalBoard = boardJpaRepo.findById(id);
		if(optionalBoard.isPresent()) {
			return optionalBoard.get();
		}
		return null;
	}
	 */
	@GetMapping("/findBoard/{id}")
	@ResponseBody
	public void findBoard() throws InterruptedException, ExecutionException {
		boardService.getAllBoards();
	}
	
	//글 쓰기
	@PostMapping("/writeBoard")
	public String writeBoard(@RequestBody Board newBoard) throws InterruptedException, ExecutionException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(newBoard));
		return boardService.saveBoardDetails(newBoard);
		//return "TEST";
	}
	
	//글 지우기
	@DeleteMapping("/deleteBoard")
	public String deleteBoard(@RequestParam String boardId) throws InterruptedException, ExecutionException {
		return boardService.deleteBoard(boardId);
	}
	
	//글 수정하기
	@PutMapping("/updateBoard")
	public String updateBoard(@RequestBody Board newBoard)  throws InterruptedException, ExecutionException {
		return boardService.updateBoardDetails(newBoard);
	}
}
