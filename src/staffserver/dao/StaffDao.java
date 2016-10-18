package staffserver.dao;

import java.util.List;

import staffserver.model.Cert;
import staffserver.model.Department;
import staffserver.model.Position;
import staffserver.model.Salary;
import staffserver.model.Staff;
import staffserver.model.StaffClient;

public interface StaffDao {
	
	public void check();
	
	public List<Staff> findAllStaffs();
	public List<Department> findAllDepartments();
	public Department findDepartment(int id);
	
	public List<Position> findAllPositions();
	public List<Cert> findAllCerts();
	public List<Salary> findAllSalaries();
	public List<String> listMonth();
	
	public List<Integer> findIds();
	public List<Staff> findStaffs(String id1, String id2, String id3, String id4);
	public List<Staff> findStaffs(String department, String position);
	public StaffClient findStaff(int id);
	
}
