package models;

import java.util.ArrayList;
import java.util.Iterator;

public class Traslator {

	private Dictionary englishDictionary;
	private Dictionary frenchDictionary;

	public Traslator() {
		englishDictionary = new Dictionary();
		frenchDictionary = new Dictionary();
	}

	public void addNewTraduction(String spanishWord, String traductionWord, Language language)
			throws Exception, NullPointerException {
		if (spanishWord.equalsIgnoreCase(ConstantsModels.EMPTY_STRING)
				|| traductionWord.equalsIgnoreCase(ConstantsModels.EMPTY_STRING)) {
			throw new NullPointerException(ConstantsModels.WARNING_EMPTY_STRING_MESSAGE);
		} else {
			if (language == Language.ENGLISH) {
				englishDictionary.addTraduction(spanishWord, traductionWord, language);
			} else if (language == Language.FRENCH) {
				frenchDictionary.addTraduction(spanishWord, traductionWord, language);
			}
		}
	}

	public String getTraductionWord(String spanishWord, Language language) throws NullPointerException {
		String traduction = "";
		if (spanishWord.equalsIgnoreCase(ConstantsModels.EMPTY_STRING)) {
			throw new NullPointerException(ConstantsModels.WARNING_EMPTY_STRING_MESSAGE);
		} else if (language == Language.ENGLISH) {
			traduction = englishDictionary.findWord(spanishWord, traduction);
		} else if (language == Language.FRENCH) {
			traduction = frenchDictionary.findWord(spanishWord, traduction);
		}
		return traduction;
	}

	public void deleteWord(String spanishWord, Language language) throws Exception {
		if (language == Language.ENGLISH) {
			englishDictionary.deleteWord(spanishWord);
		} else if (language == Language.FRENCH) {
			frenchDictionary.deleteWord(spanishWord);
		}
	}

	public int getCountWords(Language language) {
		if (language == Language.ENGLISH) {
			return englishDictionary.getCountWords();
		}else {
			return frenchDictionary.getCountWords();
		}
	}

	public ArrayList<Word> toArrayList(Language language) {
		ArrayList<Word> list = new ArrayList<Word>();
		Iterator<Word> it = null;
		if (language == Language.ENGLISH) {
			it = englishDictionary.getIterator();
		} else {
			it = frenchDictionary.getIterator();
		}
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public Word createWordToJson(String spanishWord, String traductionWord, Language language) {
		return new Word(spanishWord, traductionWord, language);
	}
}