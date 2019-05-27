package co.turner.jdelgado.model;

public class ServiceList {

	private NodeService head;
	private NodeService tail;
	private int size;

	public NodeService getHead() {
		return head;
	}

	public void setHead(NodeService head) {
		this.head = head;
	}

	public NodeService getTail() {
		return tail;
	}

	public void setTail(NodeService tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
