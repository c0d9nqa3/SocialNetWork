package Graph;

public class LinkQueue implements IQueue{
	private Node front;
	private Node rear;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		rear=front=null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node p =front;
		int length = 0;
		while(p!=null) {
			p=p.next;
			++length;
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(front!=null)
			return front.data;
		else
		return null;
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p=new Node(x);
		if(front!=null) {
			rear.next=p;
			rear=p;
		}
		else
			front=rear=p;
		
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		if(front!=null) {
			Node p=front;
			front=front.next;
			if(p==rear)
				rear=null;
			return p.data;
		}
		else
			return null;
		
	}
	
	public void display() {
		Node p=front;
		while(p!=null) {
			System.out.print(p.data.toString()+" ");
			p=p.next;
		}
	}

}
