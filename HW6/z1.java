// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
// методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации
// и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев -
// сохранить параметры фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class z1 {
    public static void main(String[] args) {
        notebook notebook1 = new notebook("Asus", "8", "1000", "Windows", "black");
        notebook notebook2 = new notebook("Acer", "4", "1000", "Lunex", "grey");
        notebook notebook3 = new notebook("MSI", "8", "1000", "Windows", "black");
        notebook notebook4 = new notebook("Razer", "16", "2000", "Windows", "black");
        notebook notebook5 = new notebook("Xiaomi", "8", "1000", "Windows", "black");

        Set<notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
                notebook3, notebook4, notebook5));

        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
            System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
            String question = scanner();
            if (question.equals("n")) {
                break;
            } else {

                System.out.println(
                        "Введите цифру, соответствующую необходимому критерию: \n 1 - Название \n 2 - ОЗУ \n 3 - Объем ЖД \n 4 - Операционная система \n 5 - Цвет");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();

                resultCriterias.put(key, value);
            }
        }
        System.out.println(resultCriterias);
        return resultCriterias;

    }

    public static void sort(Map<String, String> criterias, Set<notebook> notebooks) {

        Set<notebook> temp = new HashSet<>(notebooks);
        for (notebook notebook : notebooks) {

            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                for (Object pair1 : criterias.keySet()) {

                    if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                        temp.remove(notebook);

                    }
                    for (Object pair2 : criterias.keySet()) {

                        if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                            temp.remove(notebook);

                        }
                        for (Object pair3 : criterias.keySet()) {

                            if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                                temp.remove(notebook);

                            }
                            for (Object pair4 : criterias.keySet()) {

                                if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                                    temp.remove(notebook);

                                }
                            }
                        }
                    }
                }
            }

        }
        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы можем предложить: \n" + temp.toString());
        }

    }

}