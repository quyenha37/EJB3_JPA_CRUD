package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qha.com.dto.StudentDTO;
import qha.com.ejb.StudentEJBRemote;

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 2L;

	@EJB
	private StudentEJBRemote studentEJB;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String action = request.getPathInfo();
		
		
		try {
            switch (action) {
	            case "/new":
	                newStudentForm(request, response);
	                break;
	            case "/add":
	                addStudent(request, response);
	                break;
	            case "/edit":
	            	editStudentForm(request, response);
	            	break;
	            case "/update":
	            	updateStudent(request, response);
	                break;
	            case "/delete":
	                deleteStudent(request, response);
	                break;
	            default:
	                listStudent(request, response);
	                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
            
        }
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		request.setAttribute("students", studentEJB.getStudents());
		request.getRequestDispatcher("jsp/displayStudent.jsp").forward(request, response);
	}
	
	private void newStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/studentForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setFirstName(firstName);
		studentDTO.setLastName(lastName);
		studentDTO.setEmail(email);
		
		//Add student
		studentEJB.addStudent(studentDTO);
		
		//Redirect to display students after we added
		listStudent(request, response);
	}

	private void editStudentForm(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDTO existingStudent = studentEJB.getStudent(id);
		request.setAttribute("student", existingStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/updateStudentForm.jsp");
		dispatcher.forward(request, response);	
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		StudentDTO studentDTO = new StudentDTO(id, firstName, lastName, email);
		studentEJB.updateStudent(studentDTO);
		
		listStudent(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDTO studentDTO = new StudentDTO(id);
		studentEJB.deleteStudent(studentDTO);
		
		listStudent(request, response);
	}
	
}
