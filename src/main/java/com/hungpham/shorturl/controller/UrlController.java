package com.hungpham.shorturl.controller;

import com.hungpham.shorturl.model.Url;
import com.hungpham.shorturl.repository.UrlRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/v1/url")
public class UrlController {

	@Autowired
	private UrlRepository urlRepository;

	@DeleteMapping(value = "/{url}")
	public Mono<ResponseEntity<Void>> deleteUrl(@PathVariable(value = "url") String url) {
		return urlRepository.findById(Math.abs(url.hashCode())).flatMap(item ->
			urlRepository.delete(item).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
		).defaultIfEmpty(
			new ResponseEntity<>(HttpStatus.NOT_FOUND)
		);
	}

	@PostMapping()
	public Mono<ResponseEntity<Url>> createUrl(@RequestBody Url req) {
		req.setId(Math.abs(req.getOriginalUrl().hashCode()));
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
	public Mono<ResponseEntity<Url>> getShortenUrl(@NotNull @PathVariable(value = "url") String url) {
		int hashUrl = Math.abs(url.hashCode());
		return Mono.from(urlRepository.findById(hashUrl)
			.map(ResponseEntity::ok)
			.defaultIfEmpty(ResponseEntity.notFound().build()));
	}

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"isWorking\" : true }";
	}
}
