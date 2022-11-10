package com.example.demo.service.board;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.board.Board;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class BoardService {
	public static final String COL_NAME = "boards";
	
	//CREATE
	public String saveBoardDetails(Board board) throws InterruptedException, ExecutionException, JsonProcessingException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME)
																.document(board.getBoardId().toString())
																.set(board);
		
		return collectionsApiFuture.get().getUpdateTime().toString();
		
	}
	
	//READ
	public Board getBoardDetails(String boardId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME)
													.document(boardId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		Board board = null;
		
		if(document.exists()) {
			board = document.toObject(Board.class);
		}
		
		return board;
	}
	
	public List<Board> getAllBoards() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
		
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for(QueryDocumentSnapshot document : documents){
			System.out.println(document.getString("boardTitle"));
		}
		return null;
	}
	
	//UPDATE
	public String updateBoardDetails(Board board) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME)
																.document(board.getBoardId().toString())
																.set(board);
		
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	//DELETE
	public String deleteBoard(String boardId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME)
														.document(boardId)
														.delete();
		
		return "Document with Board ID "+boardId+" has been deleted";
	}
}
