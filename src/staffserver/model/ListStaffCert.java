package staffserver.model;

import staffserver.model.Cert;

public class ListStaffCert {
	private int id;
	private int cert;
	private String multi_cert;
	private Cert cert_name;
	
	public ListStaffCert(){}

	public ListStaffCert(int id, int cert, String multi_cert) {
		super();
		this.id = id;
		this.cert = cert;
		this.multi_cert = multi_cert;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCert() {
		return cert;
	}

	public void setCert(int cert) {
		this.cert = cert;
	}

	public String getMulti_cert() {
		return multi_cert;
	}

	public void setMulti_cert(String multi_cert) {
		this.multi_cert = multi_cert;
	}

	public Cert getCert_name() {
		return cert_name;
	}

	public void setCert_name(Cert cert_name) {
		this.cert_name = cert_name;
	}
		
}

