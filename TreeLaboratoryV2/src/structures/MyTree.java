package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MyTree<T> {
	private NodeTree<T> root;
	private Comparator<T> comparator;
	private int size;

	public MyTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void createTree() {
		root = null;
	}

	public void build(T data) {
		NodeTree<T> auxNode = new NodeTree<T>(data);
		if (root == null) {
			root = auxNode;
		} else {
			build(data, root);
		}
	}

	private void build(T data, NodeTree<T> father) {
		NodeTree<T> auxNode = new NodeTree<T>(data);
		if (comparator.compare(father.getValue(), data) == 1) {
			if (father.getRight() == null) {
				father.setRight(auxNode);
			} else {
				build(data, father.getRight());
			}
		} else if (comparator.compare(father.getValue(), data) == 0) {
			if (father.getLeft() == null) {
				father.setleft(auxNode);
			} else {
				build(data, father.getLeft());
			}
		}
	}

	public boolean isIntoTree(T value) {
		NodeTree<T> reco = root;
		while (reco != null) {
			if (comparator.compare(reco.getValue(), value) == 2) {
				return true;
			} else {
				if (comparator.compare(reco.getValue(), value) == 1) {
					reco = reco.getRight();
				} else {
					reco = reco.getLeft();
				}
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return root == null ? true : false;
	}

	public NodeTree<T> getRoot() {
		return root;
	}

	public NodeTree<T> findNode(T value) {
		NodeTree<T> auxNode = root;
		while (auxNode != null) {
			if (comparator.compare(value, auxNode.getValue()) == 2) {
				return auxNode;
			} else {
				if (comparator.compare(auxNode.getValue(), value) == 1) {
					auxNode = auxNode.getRight();
				} else {
					auxNode = auxNode.getLeft();
				}
			}
		}
		return auxNode;
	}

	public void delete(T data) throws Exception {
		root = delete(root, data);
	}

	private NodeTree<T> delete(NodeTree<T> node, T data) throws Exception {
		if (node == null)
			throw new Exception();
		else if (comparator.compare(node.getValue(), data) == 1) {
			NodeTree<T> rightNode = delete(node.getRight(), data);
			node.setRight(rightNode);
		} else if (comparator.compare(node.getValue(), data) == 0) {
			NodeTree<T> leftNode = delete(node.getLeft(), data);
			node.setleft(leftNode);
		} else {
			NodeTree<T> auxNode = node;
			if (auxNode.getLeft() == null)
				node = auxNode.getRight();
			else if (auxNode.getRight() == null)
				node = auxNode.getLeft();
			else
				auxNode = replace(auxNode);
			auxNode = null;
		}

		return node;
	}

	private NodeTree<T> replace(NodeTree<T> actual) {
		NodeTree<T> auxNode, fatherNode;
		fatherNode = actual;
		auxNode = actual.getLeft();
		while (auxNode.getRight() != null) {
			fatherNode = auxNode;
			auxNode = auxNode.getRight();
		}
		actual.setValue(auxNode.getValue());
		if (fatherNode == actual)
			fatherNode.setleft(auxNode.getLeft());
		else
			fatherNode.setRight(auxNode.getLeft());
		return auxNode;
	}

	public NodeTree<T> getLeftSubTree() {
		NodeTree<T> aux = root;
		return aux.getLeft();
	}

	public NodeTree<T> getRightSubTree() {
		NodeTree<T> aux = root;
		return aux.getRight();
	}

	public Iterator<T> inOrder() {
		ArrayList<T> inOrderList = new ArrayList<T>();
		inOrder(inOrderList, root);
		return inOrderList.iterator();
	}

	private void inOrder(ArrayList<T> inOrderList, NodeTree<T> rootAux) {
		if (rootAux != null) {
			inOrder(inOrderList, rootAux.getRight());
			inOrderList.add(rootAux.getValue());
			inOrder(inOrderList, rootAux.getLeft());
		}
	}

	public Iterator<T> preOrder() {
		ArrayList<T> preOrderList = new ArrayList<>();
		preOrder(preOrderList, root);
		return preOrderList.iterator();
	}

	private void preOrder(ArrayList<T> preOrderList, NodeTree<T> rootAux) {
		if (rootAux != null) {
			preOrderList.add(rootAux.getValue());
			preOrder(preOrderList, rootAux.getRight());
			preOrder(preOrderList, rootAux.getLeft());
		}
	}

	public Iterator<T> postOrder() {
		ArrayList<T> postOrderList = new ArrayList<>();
		postOrder(postOrderList, root);
		return postOrderList.iterator();
	}

	private void postOrder(ArrayList<T> postOrderList, NodeTree<T> rootAux) {
		if (rootAux != null) {
			postOrder(postOrderList, rootAux.getRight());
			postOrder(postOrderList, rootAux.getLeft());
			postOrderList.add(rootAux.getValue());
		}
	}

	private void sizeTreeNodes(NodeTree<T> node) {
		if (node != null) {
			size++;
			sizeTreeNodes(node.getLeft());
			sizeTreeNodes(node.getRight());
		}
	}

	public int sizeTreeNodes() {
		size = 0;
		sizeTreeNodes(root);
		return size;
	}
}