package com.example.demo.dto.board;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="board")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId; // 게시글 Id
	
	@Column(nullable = false)
	private String boardWriter; // 게시글 작성자

	@Column(nullable = false)
	private int boardHit; // 게시글 조회수

	@Column(nullable = false)
	private String boardTitle; // 게시글 제목

	@Column(length = 50000, nullable = false)
	private String boardContent; // 게시글 내용

	@Column(nullable = false)
	private Date createdDate; // 게시글 작성일

	@Column(nullable = false)
	private String boardPassword; // 게시글 비밀번호
}
