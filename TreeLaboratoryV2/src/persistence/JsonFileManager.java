package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import models.Language;
import models.Word;

public class JsonFileManager {

	private static final String FAILED_READ_TITLE = "Error de carga";
	private static final String FAILED_READ_MESSAGE = "La lectura del archivo ha fallado";
	private static final String FAILED_WRITE_TITLE = "Error de escritura";
	private static final String FAILED_WRITE_MESSAGE = "La escritura del archivo ha fallado";
	private static final String NEXT_LINE_JUMP = "\n";
	private static final String PATH_DATA_FILE_FRENCH = "db/frenchDictionary.json";
	private static final String PATH_DATA_FILE_ENGLISH = "db/englishWordsDictionary.json";

	public static ArrayList<Word> readJsonFile(String path) {
		Gson gson = new Gson();
		ArrayList<Word> wordList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				wordList.add(gson.fromJson(linea, Word.class));
			}
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, FAILED_READ_MESSAGE, FAILED_READ_TITLE, JOptionPane.ERROR_MESSAGE);
		} catch (IOException ex1) {
			JOptionPane.showMessageDialog(null, FAILED_READ_MESSAGE, FAILED_READ_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		return wordList;
	}

	public static void writeAppendJsonFile(Word word) {
		Gson gson = new Gson();
		Word wordAux = new Word(word.getSpanishWord(), word.getTraductWord(), word.getLanguage());
		String wordJsonObj = gson.toJson(wordAux);

		if (word.getLanguage() == Language.ENGLISH) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_DATA_FILE_ENGLISH, true))) {
				bw.write(wordJsonObj + NEXT_LINE_JUMP);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, FAILED_WRITE_MESSAGE, FAILED_WRITE_TITLE,
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (word.getLanguage() == Language.FRENCH) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_DATA_FILE_FRENCH, true))) {
				bw.write(wordJsonObj + NEXT_LINE_JUMP);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, FAILED_WRITE_MESSAGE, FAILED_WRITE_TITLE,
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void writeCompleteJsonFile(ArrayList<Word> list, Language language) {
		Gson gson = new Gson();
		if (language == Language.ENGLISH) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_DATA_FILE_ENGLISH, false))) {
				for (int i = 0; i < list.size(); i++) {
					Word wordAux = new Word(list.get(i).getSpanishWord(), list.get(i).getTraductWord(),
							list.get(i).getLanguage());
					String wordJsonObj = gson.toJson(wordAux);
					bw.write(wordJsonObj + NEXT_LINE_JUMP);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, FAILED_WRITE_MESSAGE, FAILED_WRITE_TITLE,
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (language == Language.FRENCH) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_DATA_FILE_FRENCH, false))) {
				for (int i = 0; i < list.size(); i++) {
					Word wordAux = new Word(list.get(i).getSpanishWord(), list.get(i).getTraductWord(),
							list.get(i).getLanguage());
					String wordJsonObj = gson.toJson(wordAux);
					bw.write(wordJsonObj + NEXT_LINE_JUMP);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, FAILED_WRITE_MESSAGE, FAILED_WRITE_TITLE,
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}