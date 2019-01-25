package br.com.alura.crudaluno.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
	
	private String nome;
	private String action;
	private List<String> params = new ArrayList<>();
	
	public Controller(String url) {
		this.tratamentoUrl(url);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getAction() {
		return action;
	}
	
	public List<String> getParams() {
		return Collections.unmodifiableList(this.params);
	}
	
	private void tratamentoUrl(String url) {
		String[] arr_url = url.split("/");
		
		if(arr_url.length>2) {
			this.nome = arr_url[2].substring(0, 1).toUpperCase() + arr_url[2].substring(1);
		}
		
		if(arr_url.length>3) {
			this.action = arr_url[3];
		}
		
		if(arr_url.length>4) {
			for(int i=4; i<arr_url.length; i++) {
				this.params.add(arr_url[i]);
			}
		}
	}
	
}
