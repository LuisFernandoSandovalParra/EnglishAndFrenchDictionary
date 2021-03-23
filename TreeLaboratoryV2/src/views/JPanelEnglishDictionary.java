package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Event;

public class JPanelEnglishDictionary extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField spanishWordSpace;
	private JLabel resultSpanish, resultEnglish, messageQuantityEn, quantityEn;

	public JPanelEnglishDictionary(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createBackBtnAndTitle(actionListener);
		createFormSpaToEng(actionListener);
		createSearchBtn(actionListener);
	}

	private void createBackBtnAndTitle(ActionListener actionListener) {
		JPanel backBtnAndTitle = new JPanel();
		backBtnAndTitle.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		backBtnAndTitle.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		backBtnAndTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 160, 0));

		JButton backBtn = new JButton(ConstantsGUI.TEXT_BACK_BTN);
		backBtn.setFocusable(false);
		backBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		backBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		backBtn.addActionListener(actionListener);
		backBtn.setActionCommand(Event.BACK_BTN.name());
		backBtnAndTitle.add(backBtn);

		JLabel titlePanel = new JLabel(ConstantsGUI.TEXT_SPANISH_TO_ENGLISH_BTN);
		titlePanel.setFont(ConstantsGUI.TITLES_FONT);
		backBtnAndTitle.add(titlePanel);

		add(backBtnAndTitle, BorderLayout.NORTH);
	}

	private void createFormSpaToEng(ActionListener actionListener) {
		JPanel formSpaToEng = new JPanel();
		formSpaToEng.setBorder(ConstantsGUI.BORDER_FORM_SPA_TO_ENG);
		formSpaToEng.setBackground(Color.WHITE);
		formSpaToEng.setLayout(new GridLayout(3, 2, 0, 10));

		JLabel textSpanishWord = new JLabel(ConstantsGUI.TEXT_WRITE_SPANISH_WORD_BTN, JLabel.CENTER);
		formSpaToEng.add(textSpanishWord);

		spanishWordSpace = new JTextField();
		spanishWordSpace.setBorder(ConstantsGUI.BORDER_SPANISH_WORD_SPACE);
		formSpaToEng.add(spanishWordSpace);

		JLabel subtitleSpanish = new JLabel(ConstantsGUI.TEXT_SPANISH, JLabel.CENTER);
		subtitleSpanish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		subtitleSpanish.setOpaque(true);
		subtitleSpanish.setBackground(ConstantsGUI.COLOR_BLUE_BASE);
		formSpaToEng.add(subtitleSpanish);

		resultSpanish = new JLabel();
		resultSpanish.setHorizontalAlignment(JLabel.CENTER);
		resultSpanish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resultSpanish.setOpaque(true);
		resultSpanish.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		formSpaToEng.add(resultSpanish);

		JLabel subtitleEnglish = new JLabel(ConstantsGUI.TEXT_ENGLISH, JLabel.CENTER);
		subtitleEnglish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		subtitleEnglish.setOpaque(true);
		subtitleEnglish.setBackground(ConstantsGUI.COLOR_BLUE_BASE);
		formSpaToEng.add(subtitleEnglish);

		resultEnglish = new JLabel();
		resultEnglish.setHorizontalAlignment(JLabel.CENTER);
		resultEnglish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resultEnglish.setOpaque(true);
		resultEnglish.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		formSpaToEng.add(resultEnglish);

		add(formSpaToEng, BorderLayout.CENTER);
	}

	private void createSearchBtn(ActionListener actionListener) {
		JPanel searchBtnPanel = new JPanel();
		searchBtnPanel.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		searchBtnPanel.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		searchBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		messageQuantityEn = new JLabel("Cantidad de palabras: ");
		searchBtnPanel.add(messageQuantityEn);

		quantityEn = new JLabel("0");
		quantityEn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));
		searchBtnPanel.add(quantityEn);
		
		JButton searchBtn = new JButton(ConstantsGUI.TEXT_SEARCH);
		searchBtn.setFocusable(false);
		searchBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		searchBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		searchBtn.addActionListener(actionListener);
		searchBtn.setActionCommand(Event.SEARCH_ENG_WORD.name());
		searchBtnPanel.add(searchBtn);

		add(searchBtnPanel, BorderLayout.SOUTH);
	}
	
	public String getSpanishWordED() {
		return spanishWordSpace.getText();
	}
	
	public void setQuantityEn(int quantity) {
		quantityEn.setText(String.valueOf(quantity));
		revalidate();
		repaint();
	}

	public void setResultSpanishText(String resultSpanishText) {
		resultSpanish.setText(resultSpanishText);
		revalidate();
		repaint();
	}

	public void setResultEnglishText(String resultEnglishText) {
		resultEnglish.setText(resultEnglishText);
		revalidate();
		repaint();
	}
}