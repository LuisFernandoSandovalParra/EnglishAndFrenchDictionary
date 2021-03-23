package models;

import java.util.Comparator;

public class ComparatorWords implements Comparator<Word>{

	@Override
	public int compare(Word wordOne, Word wordTwo) {
		int compare = wordOne.getSpanishWord().compareToIgnoreCase(wordTwo.getSpanishWord());
		if (compare < 0) { //wordOne < wordTwo
			return 1;
		}else if(compare == 0){ //wordOne y wordTwo son iguales.
			return 2;
		}else {			//wordOne > wordTwo
			return 0;
		}
	}
}
