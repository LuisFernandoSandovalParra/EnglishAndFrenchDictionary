package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Event;

public class JMainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanelEnglishDictionary panelEnglishDictionary;
	private JPanelFrenchDictionary panelFrenchDictionary;

	public JMainPanel(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		createFirstPanel(actionListener);
	}

	public void createFirstPanel(ActionListener actionListener) {
		removeAll();
		createTitlePanel();
		createMainImage();
		createDictionariesBtn(actionListener);
		revalidate();
		repaint();
	}

	private void createTitlePanel() {
		JLabel titleFirstPanel = new JLabel(ConstantsGUI.GENERAL_TITLE, JLabel.CENTER);
		titleFirstPanel.setFont(ConstantsGUI.TITLES_FONT);
		titleFirstPanel.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		titleFirstPanel.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		titleFirstPanel.setOpaque(true);
		add(titleFirstPanel, BorderLayout.NORTH);
	}

	private void createMainImage() {
		JLabel mainImage = new JLabel(new ImageIcon(getClass().getResource(ConstantsGUI.IMG_MAIN_IMAGE_PATH)), JLabel.CENTER);
		add(mainImage, BorderLayout.CENTER);
	}
	
	private void createDictionariesBtn(ActionListener actionListener) {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		buttonsPanel.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		buttonsPanel.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		
		JButton spanishToEnglishBtn = new JButton(ConstantsGUI.TEXT_SPANISH_TO_ENGLISH);
		spanishToEnglishBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		spanishToEnglishBtn.addActionListener(actionListener);
		spanishToEnglishBtn.setFocusable(false);
		spanishToEnglishBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		spanishToEnglishBtn.setActionCommand(Event.SPA_TO_ENG_BTN.name());
		buttonsPanel.add(spanishToEnglishBtn);
		
		JButton spanishToFrenchBtn = new JButton(ConstantsGUI.TEXT_SPANISH_TO_FRENCH);
		spanishToFrenchBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		spanishToFrenchBtn.addActionListener(actionListener);
		spanishToFrenchBtn.setFocusable(false);
		spanishToFrenchBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		spanishToFrenchBtn.setActionCommand(Event.SPA_TO_FRN_BTN.name());
		buttonsPanel.add(spanishToFrenchBtn);
		
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void createPanelEnglishDictionary(ActionListener actionListener) {
		removeAll();
		panelEnglishDictionary = new JPanelEnglishDictionary(actionListener);
		add(panelEnglishDictionary);
		revalidate();
		repaint();
	}
	
	public void createPanelFrenchDictionary(ActionListener actionListener) {
		removeAll();
		panelFrenchDictionary = new JPanelFrenchDictionary(actionListener);
		add(panelFrenchDictionary);
		revalidate();
		repaint();
	}
	
	public String getSpanishWordED() {
		return panelEnglishDictionary.getSpanishWordED();
	}
	
	public void setResultSpanishTextED(String resultSpanishText) {
		panelEnglishDictionary.setResultSpanishText(resultSpanishText);
	}
	
	public void setResultEnglishTextED(String resultEnglishText) {
		panelEnglishDictionary.setResultEnglishText(resultEnglishText);
	}
	
	public String getSpanishWordEF() {
		return panelFrenchDictionary.getSpanishWordEF();
	}
	
	public void setResultSpanishTextEF(String resultSpanishText) {
		panelFrenchDictionary.setResultSpanishText(resultSpanishText);
	}
	
	public void setResultFrenchTextEF(String resultFrenchText) {
		panelFrenchDictionary.setResultFrenchText(resultFrenchText);
	}
	
	public void setQuantityEn(int quantity) {
		panelEnglishDictionary.setQuantityEn(quantity);
	}
	
	public void setQuantityFr(int quantity) {
		panelFrenchDictionary.setQuantityFr(quantity);
	}
	
	public JPanelEnglishDictionary getEnglishPanel() {
		return panelEnglishDictionary;
	}
	
	public JPanelFrenchDictionary getFrenchDictionary() {
		return panelFrenchDictionary;
	}
}