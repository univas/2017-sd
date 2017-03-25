package br.edu.univas.si7.sd.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentService")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String id = request.getParameter("ident");
		
		Aluno al = new Aluno(name, id);
		AlunoXMLDAO dao = new AlunoXMLDAO("student.xml");
		
		try {
			dao.saveToFile(al);
			
			Collection<Aluno> students = dao.readAlunos().values();
			
			request.setAttribute("studentList", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServletContext ctx = request.getServletContext();
		RequestDispatcher disp = ctx.getRequestDispatcher("/students.jsp");
		disp.forward(request, response);

	}

}
