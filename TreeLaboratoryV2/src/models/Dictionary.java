package models;

import java.util.Iterator;

import structures.MyTree;

public class Dictionary {

	MyTree<Word> languageTree;

	public Dictionary() {
		languageTree = new MyTree<>(new ComparatorWords());
		languageTree.createTree();
	}

	public void addTraduction(String spanishWord, String traductionWord, Language language) throws Exception {
		if (!languageTree.isIntoTree(new Word(spanishWord))) {
			languageTree.build(new Word(spanishWord, traductionWord, language));
		} else {
			throw new Exception(
					ConstantsModels.WARNING_REPEAT_WORD_FIRST_PART + spanishWord + ConstantsModels.WARNING_REPEAT_WORD);
		}
	}

	public String findWord(String spanishWord, String traduction) {
		if (languageTree.findNode(new Word(spanishWord)) == null) {
			throw new NullPointerException(ConstantsModels.WARNING_NOT_FOUND_WORD);
		} else {
			traduction = languageTree.findNode(new Word(spanishWord)).getValue().getTraductWord();
		}
		return traduction;
	}

	public void deleteWord(String word) throws Exception {
		languageTree.delete(new Word(word));
	}

	public int getCountWords() {
		return languageTree.sizeTreeNodes();
	}

	public Iterator<Word> getIterator() {
		return languageTree.inOrder();
	}
}