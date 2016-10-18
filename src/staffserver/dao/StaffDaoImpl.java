package staffserver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import staffserver.model.Cert;
import staffserver.model.Department;
import staffserver.model.ListStaffCert;
import staffserver.model.Position;
import staffserver.model.Salary;
import staffserver.model.Staff;
import staffserver.model.StaffClient;

@Repository
@SuppressWarnings("unchecked")
public class StaffDaoImpl implements StaffDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void check() {

		try{
			List<Staff> list = sessionFactory.getCurrentSession().createQuery("from Staff").list();
			List<Cert> list1 = sessionFactory.getCurrentSession().createQuery("from Cert").list();
			List<Department> list2 = sessionFactory.getCurrentSession().createQuery("from Department").list();
			List<Position> list3 = sessionFactory.getCurrentSession().createQuery("from Position").list();
			List<ListStaffCert> list4 = sessionFactory.getCurrentSession().createQuery("from ListStaffCert").list();

			System.out.println("Info:\n"+list.get(0).getName()+" -- "+list1.get(1).getName()+" -- "+list2.get(1).getName()+" -- "+list3.get(1).getPosition()
					+" -- "+list4.get(1).getCert());
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public List<Staff> findAllStaffs(){
		List<Staff> list = sessionFactory.getCurrentSession().createQuery("from Staff st where st.id > 0").list();
		//System.out.println("Staff: "+list.get(15).getDept().getName());

		int i, n = list.size();

		for( i = 0; i < n; i++)
			if(list.get(i).getListStaffCert().getCert() == 0){
				String s = new String(list.get(i).getListStaffCert().getMulti_cert());
				list.get(i).getListStaffCert().getCert_name()
				.setName(s);
				//System.out.println("s = "+s);

			}

		return list;
	}

	@Override
	public List<Department> findAllDepartments(){

		List<Department> list = sessionFactory.getCurrentSession().createQuery("from Department").list();
		//System.out.println("Department: "+list.get(1).getName());
		return list;
	}

	@Override
	public List<Position> findAllPositions(){

		List<Position> list = sessionFactory.getCurrentSession().createQuery("from Position").list();
		//System.out.println("Position: "+list.get(1).getPosition());
		return list;
	}

	@Override
	public List<Cert> findAllCerts(){

		List<Cert> list = sessionFactory.getCurrentSession().createQuery("from Cert c where c.id > 0").list();
		//System.out.println("Cert: "+list.get(1).getName());
		return list;
	}

	@Override
	public List<Salary> findAllSalaries(){

		List<Salary> list = sessionFactory.getCurrentSession().createQuery("from Salary").list();
		//System.out.println("Salary: "+list.get(1).getMonth1());
		return list;
	}

	@Override
	public List<String> listMonth(){

		List<String> list = new ArrayList<String>();

		list.add("January");
		list.add("February");
		list.add("March");
		list.add("April");
		list.add("May");
		list.add("June");
		list.add("July");
		list.add("August");
		list.add("September");
		list.add("October");
		list.add("November");
		list.add("December");

		//System.out.println("Months: "+list.size());
		return list;
	}

	@Override
	public List<Integer> findIds(){
		List<Integer> list = sessionFactory.getCurrentSession()
				.createQuery("select s.id from Staff s where s.id > 0")
				.list();

		return list;
	}

	@Override
	public List<Staff> findStaffs(String id1, String id2, String id3, String id4){
		if(id1.equals("All")) id1 = "";

		if(id2.equals("All")) id2="";	
		if (id2.equals("Director"))	id2 = "Director and CEO";

		if(id3.equals("All")) id3="";
		if(id3.equals("Any certificate")) id3 = "%%";

		if (id4.equals("")) id4 = "January";

		List<Staff> list = sessionFactory.getCurrentSession()
				.createQuery("from Staff s where s.id > 0 and s.dept.name like '%"+id1+"%'"
						+ " and ('"+id2+"' like CONCAT('%', s.position.position, '%') or '"+id2+"' = '')"
						+ " and (s.listStaffCert.cert_name.name like '%"+id3+"%' or '"+id3+"'='')")
				.list();

		System.out.println("size = "+list.size());
		for (Staff s : list)
			System.out.println("name = " + s.getName()
			+"\t dept = "+s.getDept().getName()+"\t position = "+ s.getPosition().getPosition()
			+"\t cert = "+s.getListStaffCert().getCert_name().getName());
		return list;

	}

	@Override
	public List<Staff> findStaffs(String id1, String id2){
		if(id1.equals("All")) id1 = "";

		if(id2.equals("All")) id2="";	
		if (id2.equals("Director"))	id2 = "Director and CEO";

		List<Staff> list = sessionFactory.getCurrentSession()
				.createQuery("from Staff s where s.id > 0 and s.dept.name like '%"+id1+"%'"
						+ " and ('"+id2+"' like CONCAT('%', s.position.position, '%') or '"+id2+"' = '')")
				.list();

		return list;
	}

	@Override
	public StaffClient findStaff(int id){

		List<Staff> list = sessionFactory.getCurrentSession()
				.createQuery("from Staff s where s.id = "+id).list();

		String[] s = new String[6];
		if(list.size() == 1 ) {
			Staff st = list.get(0);
			return new StaffClient(st.getId(), st.getName(), st.getInfo(),
					st.getAvatar(), st.getDept().getName(), st.getPosition().getPosition());
		}

		return null;
	}

	@Override
	public Department findDepartment(int id){
		List<Department> list = sessionFactory.getCurrentSession().createQuery("from Department where id="+id).list();
		return list.get(0);
	}

}
