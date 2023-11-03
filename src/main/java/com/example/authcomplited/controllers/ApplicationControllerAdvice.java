package com.example.authcomplited.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.example.authcomplited.exceptions.SenhaInvalidaException;
import com.example.authcomplited.exceptions.UserExistException;
import com.example.authcomplited.utils.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	private String mensagemErro;

	@ResponseBody
	@ExceptionHandler(UserExistException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors usuarioCadastradoExceptionHandle(UserExistException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(SenhaInvalidaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors senhaInvalidaExceptionHandle(SenhaInvalidaException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors usernameNotFoundExceptionHandle(UsernameNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity ResponseStatusExceptionHandle(ResponseStatusException ex) {
		String messagemErro = ex.getReason();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(messagemErro);
		return new ResponseEntity(apiErrors, codigoStatus);

	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors validateFieldsHandle(MethodArgumentNotValidException ex) {
		List<String> erros = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

		return new ApiErrors(erros);
	}
}
