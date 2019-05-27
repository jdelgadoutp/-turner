package co.turner.jdelgado.model;

public class NodeLenders {

	private Adviser data;
	private NodeLenders next;

	public Adviser getData() {
		return data;
	}

	public void setData(Adviser data) {
		this.data = data;
	}

	public NodeLenders getNext() {
		return next;
	}

	public void setNext(NodeLenders next) {
		this.next = next;
	}

	public NodeLenders(String name, Boolean active, Service[] services) {
		this.data = new Adviser(name, active, services);

	}

}
