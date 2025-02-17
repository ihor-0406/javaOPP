package dictionary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dictionary dictionary = new Dictionary("dict.txt");
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.println("Выбери действие : 1- Добавить слово; 2- перевод слова; 3- Сохранить; 4-Показать словарь; 5- Выйти");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println("Введите слово на английском: ");
				String eng = capitalizeFistLetter(sc.nextLine());
				System.out.println("Введите слово на украинском: ");
				String ukr = capitalizeFistLetter(sc.nextLine());
				dictionary.addWord(eng, ukr);
				break;
			case 2:
				System.out.println("Введите слово для поиска: ");
				String search = capitalizeFistLetter(sc.nextLine());
				System.out.println(dictionary.translate(search));
				break;
			case 3:
				dictionary.savaDictionary();
				System.out.println("Сохранено!");
				break;
			case 4:
				dictionary.showAllWords();
				break;
			case 5:
				dictionary.savaDictionary();
				System.out.println("Выход...");
				return;
			default:
				System.out.println("Неверный ввод данных!");
			}
		}
	}

	public static String capitalizeFistLetter(String word) {
		if(word == null || word.isEmpty()) {
			return word;
		}
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}
}