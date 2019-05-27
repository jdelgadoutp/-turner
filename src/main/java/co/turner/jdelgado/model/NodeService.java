package co.turner.jdelgado.model;

public class NodeService {

	private Service data;
	private NodeService next;

	public Service getData() {
		return data;
	}

	public void setData(Service data) {
		this.data = data;
	}

	public NodeService getNext() {
		return next;
	}

	public void setNext(NodeService next) {
		this.next = next;
	}

	public NodeService(String name) {
		this.data = new Service(name);
	}

}
