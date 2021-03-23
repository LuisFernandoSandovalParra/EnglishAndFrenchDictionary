package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ConstantsGUI {

//	JMainFrame:
	public static final String TEXT_ADD_WORD = "A�adir palabra";
	public static final String TEXT_ADMIN_OPTION = "Opciones admintrador";
	public static final int HEIGHT_FRAME = 500;
	public static final int WIDTH_FRAME = 600;
	public static final String TITLE_FRAME = "Diccionarios LFSP";

//	JMainPanel:
	public static final Font FONT_GENERAL_BTNS = new Font("Arial Narrow", Font.BOLD, 14);
	public static final Color COLOR_YELLOW_BASE = Color.decode("#FCE6AD");
	public static final String TEXT_SPANISH_TO_FRENCH = "Espa�ol - Frances";
	public static final String TEXT_SPANISH_TO_ENGLISH = "Espa�ol - Ingles";
	public static final String IMG_MAIN_IMAGE_PATH = "/img/secondImage.png";
	public static final String GENERAL_TITLE = "DICCIONARIOS LFSP";
	public static final Color COLOR_GENERAL_BTNS = Color.decode("#CCDFE4");

//	JDialogAddOrDeleteWord:
	public static final int HEIGHT_ADD_WORD_DIALOG = 400;
	public static final int WIDTH_ADD_WORD_DIALOG = 500;
	public static final String ADMIN_OPTIONS_TITLE = "Opciones administrador";
	
//	JPanelsDialog:
	public static final String TEXT_ACCEPT = "Aceptar";
	public static final String TEXT_CANCEL = "Cancelar";
	public static final EmptyBorder BORDER_BTN_CANCEL_ACCEPT = new EmptyBorder(25, 0, 25, 0);
	public static final String TEXT_FRENCH = "Frances";
	public static final String TEXT_ENGLISH = "Ingles";
	public static final String TEXT_SELECT_DICTIONARY_OPTION = "A�adir en diccionario de: ";
	public static final String TEXT_WRITE_TRADUCT_WORD = "Palabra traducida: ";
	public static final String TEXT_WRITE_SPANISH_WORD = "Palabra en espa�ol: ";
	public static final EmptyBorder BORDER_ADD_WORD_FORM = new EmptyBorder(40, 40, 40, 40);
	public static final Font TITLES_FONT = new Font("Arial Narrow", Font.BOLD, 25);
	public static final String TITLE_ADD_NEW_WORD = "A�ADIR NUEVA PALABRA";
	public static final String TEXT_DELETE_WORD_TITLE = "ELIMINAR PALABRA";
	
//	JPanelEnglishDictionary
	public static final CompoundBorder BORDER_SPANISH_WORD_SPACE = BorderFactory.createCompoundBorder(new EmptyBorder(10, 0, 10, 0),
			BorderFactory.createLineBorder(Color.BLACK));
	public static final String TEXT_SEARCH = "Buscar";
	public static final Color COLOR_BLUE_BASE = Color.decode("#4D8FCC");
	public static final String TEXT_SPANISH = "Espa�ol";
	public static final EmptyBorder BORDER_FORM_SPA_TO_ENG = new EmptyBorder(40, 60, 40, 60);
	public static final String TEXT_SPANISH_TO_ENGLISH_BTN = "Espa�ol - Ingles";
	public static final String TEXT_BACK_BTN = "Volver";
	public static final String TEXT_WRITE_SPANISH_WORD_BTN = "Ingrese la palabra en espa�ol: ";

//	JPanelFrenchDictionary
	public static final String TEXT_SPA_TO_FRC_BTN = "Espa�ol - Frances";
}
