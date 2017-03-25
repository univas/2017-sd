package br.edu.univas.si7.sd.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SimpleCalculatorService")
public class SimpleCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String str1 = request.getParameter("par1");
		String str2 = request.getParameter("par2");
		
		int value1 = Integer.parseInt(str1);
		int value2 = Integer.parseInt(str2);
		
		//recuperar o parâmetro operation
		//Efetuar a operação correspondente ao operation
		
		int result = value1 + value2;
		
		request.setAttribute("resultValue", result);
		
		ServletContext ctx = request.getServletContext();
		RequestDispatcher disp = ctx.getRequestDispatcher("/result.jsp");
		disp.forward(request, response);
		//response.getWriter().append("Resultado: " + result);
	}
}
