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

public class JPanelFrenchDictionary extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField spanishWordSpace;
	private JLabel resultSpanish, resultFrench, messageQuantityFr, quantityFr;

	public JPanelFrenchDictionary(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createBackBtnAndTitle(actionListener);
		createFormSpaToFrn(actionListener);
		createSearchBtn(actionListener);
	}

	private void createBackBtnAndTitle(ActionListener actionListener) {
		JPanel backBtnAndTitle = new JPanel();
		backBtnAndTitle.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		backBtnAndTitle.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		backBtnAndTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 0));

		JButton backBtn = new JButton(ConstantsGUI.TEXT_BACK_BTN);
		backBtn.setFocusable(false);
		backBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		backBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		backBtn.addActionListener(actionListener);
		backBtn.setActionCommand(Event.BACK_BTN.name());
		backBtnAndTitle.add(backBtn);

		JLabel titlePanel = new JLabel(ConstantsGUI.TEXT_SPA_TO_FRC_BTN);
		titlePanel.setFont(ConstantsGUI.TITLES_FONT);
		backBtnAndTitle.add(titlePanel);

		add(backBtnAndTitle, BorderLayout.NORTH);
	}

	private void createFormSpaToFrn(ActionListener actionListener) {
		JPanel formSpaToFrn = new JPanel();
		formSpaToFrn.setBorder(ConstantsGUI.BORDER_FORM_SPA_TO_ENG);
		formSpaToFrn.setBackground(Color.WHITE);
		formSpaToFrn.setLayout(new GridLayout(3, 2, 0, 10));

		JLabel textSpanishWord = new JLabel(ConstantsGUI.TEXT_WRITE_SPANISH_WORD_BTN, JLabel.CENTER);
		formSpaToFrn.add(textSpanishWord);

		spanishWordSpace = new JTextField();
		spanishWordSpace.setBorder(ConstantsGUI.BORDER_SPANISH_WORD_SPACE);
		formSpaToFrn.add(spanishWordSpace);

		JLabel subtitleSpanish = new JLabel(ConstantsGUI.TEXT_SPANISH, JLabel.CENTER);
		subtitleSpanish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		subtitleSpanish.setOpaque(true);
		subtitleSpanish.setBackground(ConstantsGUI.COLOR_BLUE_BASE);
		formSpaToFrn.add(subtitleSpanish);

		resultSpanish = new JLabel();
		resultSpanish.setHorizontalAlignment(JLabel.CENTER);
		resultSpanish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resultSpanish.setOpaque(true);
		resultSpanish.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		formSpaToFrn.add(resultSpanish);

		JLabel subtitleFrench = new JLabel(ConstantsGUI.TEXT_FRENCH, JLabel.CENTER);
		subtitleFrench.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		subtitleFrench.setOpaque(true);
		subtitleFrench.setBackground(ConstantsGUI.COLOR_BLUE_BASE);
		formSpaToFrn.add(subtitleFrench);

		resultFrench = new JLabel();
		resultFrench.setHorizontalAlignment(JLabel.CENTER);
		resultFrench.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resultFrench.setOpaque(true);
		resultFrench.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		formSpaToFrn.add(resultFrench);

		add(formSpaToFrn, BorderLayout.CENTER);
	}

	private void createSearchBtn(ActionListener actionListener) {
		JPanel searchBtnPanel = new JPanel();
		searchBtnPanel.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		searchBtnPanel.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		searchBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		messageQuantityFr = new JLabel("Cantidad de palabras: ");
		searchBtnPanel.add(messageQuantityFr);

		quantityFr = new JLabel("0");
		quantityFr.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));
		searchBtnPanel.add(quantityFr);

		JButton searchBtn = new JButton(ConstantsGUI.TEXT_SEARCH);
		searchBtn.setFocusable(false);
		searchBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		searchBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		searchBtn.addActionListener(actionListener);
		searchBtn.setActionCommand(Event.SEARCH_FRN_WORD.name());
		searchBtnPanel.add(searchBtn);

		add(searchBtnPanel, BorderLayout.SOUTH);
	}

	public void setQuantityFr(int quantity) {
		quantityFr.setText(String.valueOf(quantity));
		revalidate();
		repaint();
	}

	public String getSpanishWordEF() {
		return spanishWordSpace.getText();
	}

	public void setResultSpanishText(String resultSpanishText) {
		resultSpanish.setText(resultSpanishText);
		revalidate();
		repaint();
	}

	public void setResultFrenchText(String resultEnglishText) {
		resultFrench.setText(resultEnglishText);
		revalidate();
		repaint();
	}
}