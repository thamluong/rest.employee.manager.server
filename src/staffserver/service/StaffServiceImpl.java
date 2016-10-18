package staffserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import staffserver.dao.StaffDao;
import staffserver.model.Department;
import staffserver.model.Entities;
import staffserver.model.Staff;
import staffserver.model.StaffClient;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	@Autowired 
	private StaffDao staffDao;

	@Override
	public void check(){
		staffDao.check();
	}

	@Override
	public Entities getListEntities(){

		Entities entities = new Entities(staffDao.findAllStaffs(), staffDao.findAllDepartments(), staffDao.findAllPositions()
				, staffDao.findAllCerts(), staffDao.findAllSalaries(), staffDao.listMonth());
		return entities;
	}

	@Override
	public List<Integer> getIds(){
		return staffDao.findIds();
	}
	
	@Override
	public List<Staff> getStaffs(String id1, String id2, String id3, String id4){
		return staffDao.findStaffs(id1, id2, id3, id4);
	}
	
	@Override
	public List<Staff> getStaffs(String id1, String id2){
		return staffDao.findStaffs(id1, id2);
	}

	@Override
	public StaffClient getStaff(int id){
		return staffDao.findStaff(id);
	}
	
	@Override
	public Department getDepartment(int id){
		return staffDao.findDepartment(id);
	}
	
	@Override
	public List<Department> getAllDept(){
		return staffDao.findAllDepartments();
	}
	
}
