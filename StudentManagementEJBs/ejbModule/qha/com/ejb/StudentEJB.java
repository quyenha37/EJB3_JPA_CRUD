package qha.com.ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import qha.com.dto.StudentDTO;
import qha.com.model.Student;

@Stateless
@Remote(StudentEJBRemote.class)
@LocalBean
public class StudentEJB implements StudentEJBRemote {

	@PersistenceContext
	EntityManager entityManager;
	
    public StudentEJB() {
    }
    
    public List<Student> getStudentEntities(){
    	TypedQuery<Student> studentQuery = 
    		entityManager.createQuery("SELECT s FROM Student s", Student.class);
    	return studentQuery.getResultList();
    }

    @Override
    public StudentDTO getStudent(int id) throws SQLException{
    	Student student = new Student();
    	StudentDTO studentDTO = new StudentDTO();
    	
    	try{
    		student = entityManager.find(Student.class, id);
    		
    		studentDTO.setId(student.getId());
    		studentDTO.setLastName(student.getLastName());
    		studentDTO.setFirstName(student.getFirstName());
    		studentDTO.setEmail(student.getEmail());
    	}
    	catch(Exception e){
    		throw new SQLException(e);
    	}
    	finally{
    		//entityManager.close();
    	}
    	return studentDTO;
    }
    
    @Override
    public List<StudentDTO> getStudents(){
    	List<Student> studentEntities = getStudentEntities();
    	List<StudentDTO> students = new ArrayList<StudentDTO>();
    	
    	for(Student studentEntity : studentEntities){
    		StudentDTO student = new StudentDTO();
    		student.setId(studentEntity.getId());
    		student.setLastName(studentEntity.getLastName());
    		student.setFirstName(studentEntity.getFirstName());
    		student.setEmail(studentEntity.getEmail());
    		students.add(student);
    	}
    	return students;
    }
    
    @Override
    public boolean addStudent(StudentDTO studentDTO){
    	
    	Student student = new Student();
    	student.setLastName(studentDTO.getLastName());
    	student.setFirstName(studentDTO.getFirstName());
    	student.setEmail(studentDTO.getEmail());
    	
    	entityManager.persist(student);
    	return true;
    }
    
    @Override
    public boolean updateStudent(StudentDTO updateStudent)
    		throws SQLException
    {
		try {
			
			Student currentStudent = entityManager.find(Student.class, updateStudent.getId());
			
			if(currentStudent != null){
				
				currentStudent.setFirstName(updateStudent.getFirstName());
				currentStudent.setLastName(updateStudent.getLastName());
				currentStudent.setEmail(updateStudent.getEmail());
				entityManager.merge(currentStudent);
			}
			return true;
			
		} catch (Exception e) {
			throw new SQLException(e);
			//e.printStackTrace();
		}	
    	
    }
    
    @Override
    public boolean deleteStudent(StudentDTO studentDTO)	
    		throws SQLException
    {
    	try {
			Student student = entityManager.find(Student.class, studentDTO.getId());
			
			if(student != null){
				
				//entityManager.getTransaction().begin(); =>EJB already contain default transaction so no need to add this line
				entityManager.remove(student);
				//entityManager.remove(123);
				//entityManager.getTransaction().commit(); =>EJB already contain default transaction so no need to add this line
			}
			
			return true;
			
		} catch (Exception e) {
			throw new SQLException(e);
			//e.printStackTrace();
		}
    }
}
