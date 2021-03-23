package structures;

import java.util.Comparator;
import java.util.Iterator;

public class TestTreee {

	public static void main(String[] args) {
		MyTree<Integer> myTree = new MyTree<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				if(arg0 > arg1) {
					return 1;
				}else if(arg0 == arg1){
					return 2;
				}else {
					return 0;
				}
			}
		});
		myTree.build(7);
		myTree.build(6);
		myTree.build(10);
		myTree.build(3);
		myTree.build(20);
		myTree.build(15);
		myTree.build(4);
		
//		try {
//			System.out.println("esta ? " + myTree.isIntoTree(15));
//			System.out.println("esta ? " + myTree.findNode(15).getValue());
//			myTree.delete(15);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		int size = 0;
		Iterator<Integer> it;
		it = myTree.postOrder();
		while (it.hasNext()) { 
			System.out.println(it.next());
			size++;
		}
		System.out.println("TAMAÑO: " + size);
		
	}
}
