package qha.com.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import qha.com.dto.StudentDTO;

@Remote
public interface StudentEJBRemote {
	
	public StudentDTO getStudent(int id) throws SQLException;
	public List<StudentDTO> getStudents();
	public boolean addStudent(StudentDTO studentDTO);
	public boolean updateStudent(StudentDTO studentDTO) throws SQLException;
	public boolean deleteStudent(StudentDTO studentDTO)	throws SQLException;
}


