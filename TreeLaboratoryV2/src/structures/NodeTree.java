package structures;

public class NodeTree<T> {
	private T data;
	private NodeTree<T> rightNode;
	private NodeTree<T> leftNode;

	public NodeTree(T data) {
		this.data = data;
	}

	public T getValue() {
		return data;
	}
	
	public void setValue(T data) {
		this.data = data;
	}

	public NodeTree<T> getRight() {
		return rightNode;
	}

	public void setRight(NodeTree<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	public NodeTree<T> getLeft(){
		return leftNode;
	}
	
	public void setleft(NodeTree<T> leftNode) {
		this.leftNode = leftNode;
	}
}
