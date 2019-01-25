package br.com.alura.crudaluno.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home {
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("Seja bem vindo a Home!!!");
		
	}
	
	public void panel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		out.println("Esse eh o nosso painel de controle!!!");
	}
	
}
