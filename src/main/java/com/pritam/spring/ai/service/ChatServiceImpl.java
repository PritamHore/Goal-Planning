package com.pritam.spring.ai.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ChatServiceImpl implements ChatService {

	@Value("${gemini.api.url}")
	private String gemeniApiUrl;
	
	@Value("${gemini.api.key}")
	private String gemeniApiKey;
	
	private final WebClient webClient;
	
	public ChatServiceImpl(WebClient.Builder webClient) {
		this.webClient = webClient.build();
	}
	
	@Override
	public String getAnswer(String question) {

		// construct the payload that google accepts
		/*
		 * 
		 * { "contents": [{ "parts":[{"text": "Explain how AI works"}] }] }
		 * 
		 * 
		 */

		Map<String, Object> requestBody = Map.of("contents", new Object[] { Map.of("parts",

				new Object[] { Map.of("text", question) }) }

		);
		
		String answer = webClient.post()
			.uri(gemeniApiUrl + gemeniApiKey)
			.header("Content-Type", "application/json")
			.bodyValue(requestBody)
			.retrieve()
			.bodyToMono(String.class)
			.block();

		return answer;
	}

}
