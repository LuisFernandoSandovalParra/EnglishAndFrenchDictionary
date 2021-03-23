package models;

public class TestTraslater {

	public static void main(String[] args) {
		Traslator dic = new Traslator();
		try {
			dic.addNewTraduction("Carro", "car", Language.ENGLISH);
			dic.addNewTraduction("Pan", "bread", Language.ENGLISH);
			dic.addNewTraduction("Arroz", "riz", Language.FRENCH);
			dic.addNewTraduction("Carro", "chariot", Language.FRENCH);
			dic.addNewTraduction("Rojo", "red", Language.ENGLISH);
			dic.addNewTraduction("Amarillo", "yellow", Language.ENGLISH);
			System.out.println("la traduccion obtenida: " + dic.getTraductionWord("Pan", Language.ENGLISH));
			System.out.println("la traduccion obtenida: " + dic.getTraductionWord("carro", Language.FRENCH));
			System.out.println(dic.getCountWords(Language.ENGLISH));
			System.out.println(dic.getCountWords(Language.FRENCH));
			System.out.println("la traduccion obtenida: " + dic.getTraductionWord("Rojo", Language.ENGLISH));
			System.out.println("la traduccion obtenida: " + dic.getTraductionWord("Pan", Language.ENGLISH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
