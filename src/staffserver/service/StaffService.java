package staffserver.service;

import java.util.List;

import staffserver.model.Department;
import staffserver.model.Entities;
import staffserver.model.Staff;
import staffserver.model.StaffClient;

public interface StaffService {

	public void check();
	public Department getDepartment(int id);
	public List<Department> getAllDept();
	
	public Entities getListEntities();
	
	public List<Integer> getIds();
	public List<Staff> getStaffs(String id1, String id2, String id3, String id4);
	public List<Staff> getStaffs(String department, String position);
	public StaffClient getStaff(int id);
	
}

