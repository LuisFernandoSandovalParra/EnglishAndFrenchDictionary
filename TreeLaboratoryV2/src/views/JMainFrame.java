package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Event;
import models.Language;

public class JMainFrame extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuAdminOption;
	private JMenuItem traductionAddBtn, traductionDeleteBtn, exitBtn;
	private JDialogAddOrDeleteWord dialogAddOrDeleteWord;
	private JMainPanel mainPanel;
	private static final long serialVersionUID = 1L;

	public JMainFrame(ActionListener actionListener) {
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.IMG_MAIN_IMAGE_PATH)).getImage());
		setTitle(ConstantsGUI.TITLE_FRAME);
		setSize(new Dimension(ConstantsGUI.WIDTH_FRAME, ConstantsGUI.HEIGHT_FRAME));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(ConstantsGUI.WIDTH_FRAME, ConstantsGUI.HEIGHT_FRAME));
		setLocationRelativeTo(null);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		createMenuBar(actionListener);
		mainPanel = new JMainPanel(actionListener);
		add(mainPanel);
	}

	private void createMenuBar(ActionListener actionListener) {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuAdminOption = new JMenu(ConstantsGUI.TEXT_ADMIN_OPTION);
		menuAdminOption.setFont(ConstantsGUI.FONT_GENERAL_BTNS);

		traductionAddBtn = new JMenuItem(ConstantsGUI.TEXT_ADD_WORD);
		traductionAddBtn.addActionListener(actionListener);
		traductionAddBtn.setFocusable(false);
		traductionAddBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		traductionAddBtn.setActionCommand(Event.ADD_WORD_ADMIN_OPTION.name());
		menuAdminOption.add(traductionAddBtn);
		
		traductionDeleteBtn = new JMenuItem("Eliminar palabra");
		traductionDeleteBtn.addActionListener(actionListener);
		traductionDeleteBtn.setFocusable(false);
		traductionDeleteBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		traductionDeleteBtn.setActionCommand(Event.DELETE_WORD_ADMIN_OPTION.name());
		menuAdminOption.add(traductionDeleteBtn);
		
		exitBtn = new JMenuItem("Salir");
		exitBtn.setFocusable(false);
		exitBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		exitBtn.addActionListener(actionListener);
		exitBtn.setActionCommand(Event.EXIT_BTN.name());
		menuAdminOption.add(exitBtn);

		menuBar.add(menuAdminOption);
	}
	
	public void createFormAddWord(ActionListener actionListener) {
		dialogAddOrDeleteWord = new JDialogAddOrDeleteWord(actionListener);
		createPanelAddWord(actionListener);
		dialogAddOrDeleteWord.setVisible(true);
	}
	
	public void createFormDeleteWord(ActionListener actionListener) {
		dialogAddOrDeleteWord = new JDialogAddOrDeleteWord(actionListener);
		createPanelDeleteWord(actionListener);
		dialogAddOrDeleteWord.setVisible(true);
	}
	
	public void cleanFormAddOrDeleteWord() {
		dialogAddOrDeleteWord.dispose();
	}
	
	public Language getLanguagePD() {
		return dialogAddOrDeleteWord.getLanguagePD();
	}
	
	public String getSpanishWordPD() {
		return dialogAddOrDeleteWord.getSpanishWordPD();
	}
	
	public String getTraductionWordPD() {
		return dialogAddOrDeleteWord.getTraductionWordPD();
	}
	
	public Language getLanguageDD() {
		return dialogAddOrDeleteWord.getLanguageDD();
	}
	
	public String getSpanishWordDD() {
		return dialogAddOrDeleteWord.getSpanisWordDD();
	}
	
	public void createFirstPanel(ActionListener actionListener) {
		mainPanel.createFirstPanel(actionListener);
	}
	
	public void createPanelEnglishDictionary(ActionListener actionListener) {
		mainPanel.createPanelEnglishDictionary(actionListener);
	}
	
	public String getSpanishWordED() {
		return mainPanel.getSpanishWordED();
	}
	
	public void setResultSpanishTextED(String resultSpanishText) {
		mainPanel.setResultSpanishTextED(resultSpanishText);
	}
	
	public void setResultEnglishTextED(String resultEnglishText) {
		mainPanel.setResultEnglishTextED(resultEnglishText);
	}
	
	public void createPanelFrenchDictionary(ActionListener actionListener) {
		mainPanel.createPanelFrenchDictionary(actionListener);
	}
	
	public String getSpanishWordEF() {
		return mainPanel.getSpanishWordEF();
	}
	
	public void setResultSpanishTextEF(String resultSpanishText) {
		mainPanel.setResultSpanishTextEF(resultSpanishText);
	}
	
	public void setResultFrenchTextEF(String resultFrenchText) {
		mainPanel.setResultFrenchTextEF(resultFrenchText);
	}
	
	public void setQuantityEn(int quantity) {
		mainPanel.setQuantityEn(quantity);
	}
	
	public void setQuantityFr(int quantity) {
		mainPanel.setQuantityFr(quantity);
	}
	
	public JPanelEnglishDictionary getEnglishPanel() {
		return mainPanel.getEnglishPanel();
	}
	
	public JPanelFrenchDictionary getFrenchDictionary() {
		return mainPanel.getFrenchDictionary();
	}
	
	public void createPanelAddWord(ActionListener actionListener) {
		dialogAddOrDeleteWord.createPanelAddWord(actionListener);
	}
	
	public void createPanelDeleteWord(ActionListener actionListener) {
		dialogAddOrDeleteWord.createPanelDeleteWord(actionListener);
	}
}