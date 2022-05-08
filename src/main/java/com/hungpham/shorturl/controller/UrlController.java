package com.hungpham.shorturl.controller;

import com.hungpham.shorturl.model.Url;
import com.hungpham.shorturl.repository.UrlRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/api/v1/url")
public class UrlController {

	@Autowired
	private UrlRepository urlRepository;

	@DeleteMapping(value = "/{url}")
	public Mono<ResponseEntity<Void>> deleteUrl(@NotNull @PathVariable(value = "url") String url) {
		return urlRepository.findById(url).flatMap(item ->
			urlRepository.delete(item).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
		).defaultIfEmpty(
			new ResponseEntity<>(HttpStatus.NOT_FOUND)
		);
	}

	@PostMapping()
	public Mono<ResponseEntity<Url>> createUrl(@NotNull @RequestBody Url req) {
		String hashURL = Integer.toString(req.getOriginalUrl().hashCode());
		req.setId(hashURL);
		return urlRepository.save(req).map(item -> {
			return ResponseEntity.ok(item);
		}).defaultIfEmpty(
			new ResponseEntity<>(HttpStatus.NOT_FOUND)
		);
	}

	@GetMapping()
	public Flux<Url> getAllUrls() {
		return urlRepository.findAll();
	}

	@GetMapping(value = "/{url}")
	public Mono<ResponseEntity<Object>> getShortenUrl(@NotNull @PathVariable(value = "url") String url) {
		return urlRepository.findById(url).map(item -> {
			try {
				return redirectToExternalUrl(item.getOriginalUrl());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}).defaultIfEmpty(
			new ResponseEntity<>(HttpStatus.NOT_FOUND)
		);
	}

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"isWorking\" : true }";
	}

	private ResponseEntity<Object> redirectToExternalUrl(String url) throws URISyntaxException {
		URI redirectedURL = new URI(url);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(redirectedURL);
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
}
