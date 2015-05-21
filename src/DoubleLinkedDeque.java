public class DoubleLinkedDeque<T> implements DequeI<T> {

	private Node<T> head;
	private Node<T> tail;

	public DoubleLinkedDeque() {
		clear();
	}

	@Override
	public void addToFront(T newEntry) {
		Node<T> toAdd = new Node<T>(newEntry, head.next, head);
		head.next.previous = toAdd;
		head.next = toAdd;
	}

	@Override
	public void addToBack(T newEntry) {
		Node<T> toAdd = new Node<T>(newEntry, tail, tail.previous);
		tail.previous.next = toAdd;
		tail.previous = toAdd;
	}

	@Override
	public T removeFront() {
		if (isEmpty())
			return null;

		Node<T> removed = head.next;
		head.next.next.previous = head;
		head.next = head.next.next;

		return removed.data;
	}

	@Override
	public T removeBack() {
		if (isEmpty())
			return null;

		Node<T> removed = tail.previous;
		tail.previous.previous.next = tail;
		tail.previous = tail.previous.previous;

		return removed.data;
	}

	@Override
	public T getFront() {
		return head.next.data;
	}

	@Override
	public T getBack() {
		return tail.previous.data;
	}

	@Override
	public boolean isEmpty() {
		return head.next == tail && tail.previous == head;
	}

	@Override
	public void clear() {
		head = new Node<T>();
		tail = new Node<T>();
		tail.previous = head;
		head.next = tail;
	}

	private static class Node<T> {

		// all fields are visible to the outer class
		private T data; // entry in bag
		private Node<T> next; // link to next node
		private Node<T> previous; // link to the previous node
		
		public Node(){
			this.data = null;
			this.next = null;
			this.previous = null;
		}

		public Node(T data, Node<T> next, Node<T> previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

	} // end Node<T> class

}
