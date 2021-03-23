package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Traslator;
import models.Language;
import models.Word;
import persistence.JsonFileManager;
import views.JMainFrame;

public class Controller implements ActionListener {
	private Traslator traslator;
	private JMainFrame mainFrame;

	public Controller() {
		traslator = new Traslator();
		loadData();
		mainFrame = new JMainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case ADD_WORD_ADMIN_OPTION:
			showDialogAddWord();
			break;
		case DELETE_WORD_ADMIN_OPTION:
			showDialogDeleteWord();
			break;
		case ADD_WORD:
			addWord();
			break;
		case DELETE_WORD:
			deleteWord();
			break;
		case CANCEL_ADD_OR_DELETE_WORD:
			cancelAddOrDeleteWord();
			break;
		case BACK_BTN:
			backToMainPanel();
			break;
		case SPA_TO_ENG_BTN:
			showEnglishDictionary();
			break;
		case SEARCH_ENG_WORD:
			searchEnglishWord();
			break;
		case SPA_TO_FRN_BTN:
			showFrenchDictionary();
			break;
		case SEARCH_FRN_WORD:
			searchFrenchWord();
			break;
		case EXIT_BTN:
			exitApp();
			break;
		default:
			break;
		}
	}

	private void backToMainPanel() {
		mainFrame.createFirstPanel(this);
	}

	private void loadData() {
		ArrayList<Word> englishAuxList = JsonFileManager.readJsonFile(ConstantsCtn.PATH_DATA_FILE_ENGLISH);
		ArrayList<Word> frenchAuxList = JsonFileManager.readJsonFile(ConstantsCtn.PATH_DATA_FILE_FRENCH);
		loadDataFromArray(englishAuxList, Language.ENGLISH);
		loadDataFromArray(frenchAuxList, Language.FRENCH);
	}

	private void loadDataFromArray(ArrayList<Word> arrayAux, Language language) {
		for (int i = 0; i < arrayAux.size(); i++) {
			try {
				traslator.addNewTraduction(arrayAux.get(i).getSpanishWord(), arrayAux.get(i).getTraductWord(),
						language);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsCtn.WARNING_MESSAGE,
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void showDialogAddWord() {
		mainFrame.createFormAddWord(this);
	}

	private void showDialogDeleteWord() {
		mainFrame.createFormDeleteWord(this);
	}

	private void addWord() {
		try {
			if (JOptionPane.showConfirmDialog(null, ConstantsCtn.QUESTION_CONTINUE_PROCESS, ConstantsCtn.TEXT_ADD,
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				traslator.addNewTraduction(mainFrame.getSpanishWordPD(), mainFrame.getTraductionWordPD(),
						mainFrame.getLanguagePD());
				JsonFileManager.writeAppendJsonFile(traslator.createWordToJson(mainFrame.getSpanishWordPD(),
						mainFrame.getTraductionWordPD(), mainFrame.getLanguagePD()));
				JOptionPane.showMessageDialog(null, ConstantsCtn.TEXT_ADD_SUCCESS);
				confirmQuantityAddWords();
				hideDialogAddOrDeleteWord();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsCtn.WARNING_MESSAGE,
					JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsCtn.EXIST_WORD, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void deleteWord() {
		try {
			if (JOptionPane.showConfirmDialog(null, ConstantsCtn.QUESTION_CONTINUE_PROCESS, ConstantsCtn.DELETE_TITLE,
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				traslator.deleteWord(mainFrame.getSpanishWordDD(), mainFrame.getLanguageDD());
				if (mainFrame.getLanguageDD() == Language.ENGLISH) {
					JsonFileManager.writeCompleteJsonFile(traslator.toArrayList(Language.ENGLISH), Language.ENGLISH);
				} else if (mainFrame.getLanguageDD() == Language.FRENCH) {
					JsonFileManager.writeCompleteJsonFile(traslator.toArrayList(Language.FRENCH), Language.FRENCH);
				}
				confirmQuantityWordsDialog();
				hideDialogAddOrDeleteWord();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, ConstantsCtn.DELETE_NOT_FOUND_WORD, ConstantsCtn.WARNING_MESSAGE,
					JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCtn.DELETE_NOT_FOUND_WORD, ConstantsCtn.WARNING_MESSAGE,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void confirmQuantityAddWords() {
		if (mainFrame.getLanguagePD() == Language.ENGLISH && mainFrame.getEnglishPanel() != null) {
			mainFrame.setQuantityEn(traslator.getCountWords(Language.ENGLISH));
		} else if (mainFrame.getLanguagePD() == Language.FRENCH && mainFrame.getFrenchDictionary() != null) {
			mainFrame.setQuantityFr(traslator.getCountWords(Language.FRENCH));
		}
	}

	private void confirmQuantityWordsDialog() {
		if (mainFrame.getLanguageDD() == Language.ENGLISH && mainFrame.getEnglishPanel() != null) {
			mainFrame.setQuantityEn(traslator.getCountWords(Language.ENGLISH));
		} else if (mainFrame.getLanguageDD() == Language.FRENCH && mainFrame.getFrenchDictionary() != null) {
			mainFrame.setQuantityFr(traslator.getCountWords(Language.FRENCH));
		}
	}

	private void cancelAddOrDeleteWord() {
		if (JOptionPane.showConfirmDialog(null, ConstantsCtn.QUESTION_CANCEL_PROCESS, ConstantsCtn.TEXT_CANCEL,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			hideDialogAddOrDeleteWord();
		}
	}

	private void hideDialogAddOrDeleteWord() {
		mainFrame.cleanFormAddOrDeleteWord();
	}

	private void showEnglishDictionary() {
		mainFrame.createPanelEnglishDictionary(this);
		mainFrame.setQuantityEn(traslator.getCountWords(Language.ENGLISH));
	}

	private void showFrenchDictionary() {
		mainFrame.createPanelFrenchDictionary(this);
		mainFrame.setQuantityFr(traslator.getCountWords(Language.FRENCH));
	}

	private void searchEnglishWord() {
		try {
			mainFrame.setResultSpanishTextED(mainFrame.getSpanishWordED());
			mainFrame.setResultEnglishTextED(
					traslator.getTraductionWord(mainFrame.getSpanishWordED(), Language.ENGLISH));
		} catch (Exception e) {
			mainFrame.setResultSpanishTextED(ConstantsCtn.LINE_EMPTY);
			mainFrame.setResultEnglishTextED(ConstantsCtn.LINE_EMPTY);
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsCtn.WARNING_MESSAGE,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void searchFrenchWord() {
		try {
			mainFrame.setResultSpanishTextEF(mainFrame.getSpanishWordEF());
			mainFrame
					.setResultFrenchTextEF(traslator.getTraductionWord(mainFrame.getSpanishWordEF(), Language.FRENCH));
		} catch (Exception e) {
			mainFrame.setResultSpanishTextEF(ConstantsCtn.LINE_EMPTY);
			mainFrame.setResultFrenchTextEF(ConstantsCtn.LINE_EMPTY);
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsCtn.WARNING_MESSAGE,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void exitApp() {
		if (JOptionPane.showConfirmDialog(null, ConstantsCtn.EXIT_SECURITY_QUESTION, ConstantsCtn.EXIT_TITLE,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}