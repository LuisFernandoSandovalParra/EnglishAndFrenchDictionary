package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Event;
import models.Language;

public class JPanelAddDialog extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private ButtonGroup buttonGroup;
	private JRadioButton englishBtn, frenchBtn;
	private JTextField spanishWordSpace, traductionWordSpace;
	private Language language;

	public JPanelAddDialog(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createTitleAddWord();
		createFormularyAddWord();
		createButtons(actionListener);
	}

	private void createTitleAddWord() {
		JLabel titleDialog = new JLabel(ConstantsGUI.TITLE_ADD_NEW_WORD, JLabel.CENTER);
		titleDialog.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		titleDialog.setOpaque(true);
		titleDialog.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		titleDialog.setFont(ConstantsGUI.TITLES_FONT);
		add(titleDialog, BorderLayout.NORTH);
	}

	private void createFormularyAddWord() {
		JPanel formPanel = new JPanel();
		formPanel.setBackground(Color.WHITE);
		formPanel.setBorder(ConstantsGUI.BORDER_ADD_WORD_FORM);
		formPanel.setLayout(new GridLayout(3, 2, 0, 10));

		JLabel textSpanishWord = new JLabel(ConstantsGUI.TEXT_WRITE_SPANISH_WORD);
		formPanel.add(textSpanishWord);

		spanishWordSpace = new JTextField();
		formPanel.add(spanishWordSpace);

		JLabel textTraductionWord = new JLabel(ConstantsGUI.TEXT_WRITE_TRADUCT_WORD);
		formPanel.add(textTraductionWord);

		traductionWordSpace = new JTextField();
		formPanel.add(traductionWordSpace);

		JLabel instructionSelect = new JLabel(ConstantsGUI.TEXT_SELECT_DICTIONARY_OPTION);
		formPanel.add(instructionSelect);

		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(1, 2));

		buttonGroup = new ButtonGroup();
		englishBtn = new JRadioButton(ConstantsGUI.TEXT_ENGLISH);
		englishBtn.setBackground(Color.WHITE);
		englishBtn.addChangeListener(this);
		optionPanel.add(englishBtn);
		buttonGroup.add(englishBtn);

		frenchBtn = new JRadioButton(ConstantsGUI.TEXT_FRENCH);
		frenchBtn.setBackground(Color.white);
		frenchBtn.addChangeListener(this);
		optionPanel.add(frenchBtn);
		buttonGroup.add(frenchBtn);

		formPanel.add(optionPanel);

		add(formPanel, BorderLayout.CENTER);
	}

	public void createButtons(ActionListener actionListener) {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(ConstantsGUI.COLOR_YELLOW_BASE);
		buttonsPanel.setBorder(ConstantsGUI.BORDER_BTN_CANCEL_ACCEPT);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton cancelBtn = new JButton(ConstantsGUI.TEXT_CANCEL);
		cancelBtn.setFocusable(false);
		cancelBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		cancelBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		cancelBtn.addActionListener(actionListener);
		cancelBtn.setActionCommand(Event.CANCEL_ADD_OR_DELETE_WORD.name());
		buttonsPanel.add(cancelBtn);

		JButton acceptBtn = new JButton(ConstantsGUI.TEXT_ACCEPT);
		acceptBtn.setFocusable(false);
		acceptBtn.setBackground(ConstantsGUI.COLOR_GENERAL_BTNS);
		acceptBtn.setFont(ConstantsGUI.FONT_GENERAL_BTNS);
		acceptBtn.addActionListener(actionListener);
		acceptBtn.setActionCommand(Event.ADD_WORD.name());
		buttonsPanel.add(acceptBtn);

		add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (englishBtn.isSelected()) {
			setLanguageRadioBtn(Language.ENGLISH);
		} else if (frenchBtn.isSelected()) {
			setLanguageRadioBtn(Language.FRENCH);
		}
	}

	public void setLanguageRadioBtn(Language language) {
		this.language = language;
	}

	public Language getLanguageRadioBtn() {
		return language;
	}

	public String getSpanishWordPD() {
		return spanishWordSpace.getText();
	}

	public String getTraductionWordPD() {
		return traductionWordSpace.getText();
	}
}
