package staffserver.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "staff")
public class Staff {
		
	private int id ;
	private int  department ;
	private String name ;
	private String info ;
	private String avatar;
	private Department dept;
	private ListStaffCert listStaffCert;
	private Position position;
	private Salary salary;
	
	
	public Staff() {}

	public Staff(int id, int department, String name, String info, String avatar) {
		super();
		this.id = id;
		this.department = department;
		this.name = name;
		this.info = info;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public ListStaffCert getListStaffCert() {
		return listStaffCert;
	}

	public void setListStaffCert(ListStaffCert listStaffCert) {
		this.listStaffCert = listStaffCert;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

}

