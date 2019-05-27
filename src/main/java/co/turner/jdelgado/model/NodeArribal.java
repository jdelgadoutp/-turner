package co.turner.jdelgado.model;

import java.sql.Date;

public class NodeArribal {

	private User data;
	private NodeArribal next;
	private Date fecha;
	private Service service;
	private Priority priority;
	private String nTurner;

	public NodeArribal(String id, String name, Date fecha, Service service, Priority priority, String nTurner) {
		this.data = new User(id, name);
		this.fecha = fecha;
		this.service = service;
		this.priority = priority;
		this.nTurner = nTurner;
	}

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}

	public NodeArribal getNext() {
		return next;
	}

	public void setNext(NodeArribal next) {
		this.next = next;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getnTurner() {
		return nTurner;
	}

	public void setnTurner(String nTurner) {
		this.nTurner = nTurner;
	}

}
