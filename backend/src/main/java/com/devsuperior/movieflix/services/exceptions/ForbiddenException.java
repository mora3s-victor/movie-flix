package com.devsuperior.movieflix.services.exceptions;

//ForbiddenException É LANÇADA QUANDO O USUÁRIO ESTÁ LOGADO MAS NÃO TEM PERMISSÃO PARA ACESSAR DETERMINADO RECURSO
public class ForbiddenException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public ForbiddenException(String msg) {
		super(msg);
	}
}
