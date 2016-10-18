package staffserver.model;

import java.util.List;

public class Entities {

	private List<Staff> staffs;
	private List<Department> departments;
	private List<Position> positions;
	private List<Cert> certs;
	private List<Salary> salaries;
	private List<String> months;

	public Entities(){}

	public Entities(List<Staff> staffs, List<Department> departments, List<Position> positions, List<Cert> certs, List<Salary> salaries,
			List<String> months) {
		super();
		this.staffs = staffs;
		this.departments = departments;
		this.positions = positions;
		this.certs = certs;
		this.salaries = salaries;
		this.months = months;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public List<Cert> getCerts() {
		return certs;
	}

	public void setCerts(List<Cert> certs) {
		this.certs = certs;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public List<String> getMonths() {
		return months;
	}

	public void setMonths(List<String> months) {
		this.months = months;
	}

}
