package models;

public class Word {
	private String spanishWord;
	private String traductWord;
	private Language language;

	public Word(String spanishWord, String traductWord, Language language) {
		this.spanishWord = spanishWord;
		this.traductWord = traductWord;
		this.language = language;
	}
	
	public Word(String spanishWord) {
		this.spanishWord = spanishWord;
	}

	public String getSpanishWord() {
		return spanishWord;
	}

	public String getTraductWord() {
		return traductWord;
	}

	public Language getLanguage() {
		return language;
	}
}