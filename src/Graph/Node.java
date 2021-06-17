package Graph;

public class Node {
	public Object data;
	public Node next;
	public Node() {
		this(null,null);
	}
	public Node(Object data) {
		this(data,null);
	}
	public Node(Object data, Node next) {
		// TODO �Զ����ɵĹ��캯�����
		this.data=data;
		this.next=next;
	}
	
}
