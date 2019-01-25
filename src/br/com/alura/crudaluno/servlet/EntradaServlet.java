package br.com.alura.crudaluno.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.crudaluno.action.Home;
import br.com.alura.crudaluno.model.Controller;

@WebServlet("/")
public class EntradaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		
		Controller controller = new Controller(url);
		
		
		String className = "br.com.alura.crudaluno.action." + controller.getNome();
		
		try {
			
			Class<?> classe = Class.forName(className);
			Home home = (Home) classe.newInstance();
			
			Class<?> paramTypes[] = {HttpServletRequest.class, HttpServletResponse.class};
			Method mtd = classe.getMethod(controller.getAction(), paramTypes);
			
			Object array[] = {request, response};
			mtd.invoke(home, array);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			
			PrintWriter out = response.getWriter();
			out.println("Página não encontrada!!!");
		}

		
	}
	
}
