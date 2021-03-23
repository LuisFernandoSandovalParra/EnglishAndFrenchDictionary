package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import models.Language;

public class JDialogAddOrDeleteWord extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelAddDialog panelAddDialog;
	private JPanelDeleteDialog panelDeleteDialog;

	public JDialogAddOrDeleteWord(ActionListener actionListener) {
		setTitle(ConstantsGUI.ADMIN_OPTIONS_TITLE);
		setSize(new Dimension(ConstantsGUI.WIDTH_ADD_WORD_DIALOG, ConstantsGUI.HEIGHT_ADD_WORD_DIALOG));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	public void createPanelAddWord(ActionListener actionListener) {
		panelAddDialog = new JPanelAddDialog(actionListener);
		add(panelAddDialog);
		revalidate();
		repaint();
	}
	
	public void createPanelDeleteWord(ActionListener actionListener) {
		panelDeleteDialog = new JPanelDeleteDialog(actionListener);
		add(panelDeleteDialog);
		revalidate();
		repaint();
	}
	
	public Language getLanguagePD() {
		return panelAddDialog.getLanguageRadioBtn();
	}
	
	public String getSpanishWordPD() {
		return panelAddDialog.getSpanishWordPD();
	}
	
	public String getTraductionWordPD() {
		return panelAddDialog.getTraductionWordPD();
	}
	
	public Language getLanguageDD() {
		return panelDeleteDialog.getLanguageRadioBtn();
	}
	
	public String getSpanisWordDD() {
		return panelDeleteDialog.getSpanishWordPD();
	}
}