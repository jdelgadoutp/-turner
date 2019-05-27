package co.turner.jdelgado.model;

public class Adviser {

	private String name;
	private Boolean active;
	private Service[] services;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Service[] getServices() {
		return services;
	}

	public void setServices(Service[] services) {
		this.services = services;
	}

	public Adviser(String name, Boolean active, Service[] services) {
		this.name = name;
		this.active = active;
		this.services = new Service[2];
	}

	
}
