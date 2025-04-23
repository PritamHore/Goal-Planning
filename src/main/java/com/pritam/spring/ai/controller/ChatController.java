package com.pritam.spring.ai.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.spring.ai.service.ChatService;


@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
//	private final ChatClient chatClient;
//	
//	public ChatController(ChatClient.Builder builder) {
//		this.chatClient = builder.build();
//	}
//	
//	@GetMapping("/prompt/{prompt}")
//	public String chatPromt(@PathVariable String prompt) {
//		return chatClient
//				.prompt(prompt)
//				.call()
//				.content();
//	}
	
	@PostMapping("/start")
	public ResponseEntity<String> startChat(@RequestBody Map<String, String> payload){
		String answer = chatService.getAnswer(payload.get("question"));
		return ResponseEntity.ok(answer);
	}
	

}
