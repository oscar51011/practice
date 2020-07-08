package com.practice.notifyLine.service.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.practice.notifyLine.dto.NotifyResult;
import com.practice.notifyLine.dto.NotifyTokenCheckResult;

@Component("notifyLineAdapterImpl")
public class NotifyLineAdapterImpl implements NotifyLineAdapter {
	
	@Value("${linenotify.notify.api.url}")
	private String lineNotifyApiUrl; 
	
	@Value("${linenotify.tokencheck.api.url}")
	private String lineNotifyTokenCheckApiUrl;
	
	@Value("${linenotify.notify.api.token}")
	private String lineNotifyToken;
	
	@Override
	public NotifyResult sendLineNotifyMessage(String message) {
				
		RestTemplate restTemplate = new RestTemplate();
		
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer " + lineNotifyToken );
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("message", message);
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
		
		// call api
		ResponseEntity<String> response = restTemplate.exchange(lineNotifyApiUrl, HttpMethod.POST, requestEntity, String.class);
		
		return new Gson().fromJson(response.getBody(), NotifyResult.class);
	}

	@Override
	public NotifyTokenCheckResult checkLineNotifyTokenVaild() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer " + lineNotifyToken );
				
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
		
		// call api
		ResponseEntity<String> response = restTemplate.exchange(lineNotifyTokenCheckApiUrl, HttpMethod.GET, requestEntity, String.class);
		
		return new Gson().fromJson(response.getBody(), NotifyTokenCheckResult.class);
			
	}
	
	
	
}
