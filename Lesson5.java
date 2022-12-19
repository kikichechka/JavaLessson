import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Lesson5 {
    public static void main(String[] args) {
        String str = "Россия идет asd вперед всей планеты. Планета - это не Россия.";
        task1(str);
        task2(str);
        String[] mas1 = new String[] { "qwe", "asd", "qwe", "x" };
        String[] mas2 = new String[] { "qwe", "x" };
        task3(mas1, mas2);
    }

    // 1) Подсчитать количество вхождений каждого слова
    // Пример: Россия идет вперед всей планеты. Планета — это не Россия.
    // toLoverCase().
    static void task1(String str) {
        List<String> newStr = unsignedArray(str);
        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < newStr.size() - 1; i++) {
            int n = 1;
            for (int j = i + 1; j < newStr.size(); j++) {
                if (newStr.get(i).toLowerCase().equals(newStr.get(j).toLowerCase())) {
                    n++;
                }
            }
            words.putIfAbsent(newStr.get(i), n);
        }
        System.out.println("В строке \"" + str + "\"");
        for (Entry<String, Integer> item : words.entrySet()) {
            System.out.println("слово \"" + item.getKey() + "\" встречается " + item.getValue() + " раз(а).");
        }
    }

    static List<String> unsignedArray(String str) {
        String newStr = str.replaceAll("\\p{Punct}", "");
        return Arrays.asList(newStr.replaceAll("\\s+", " ").split(" "));
    }

    // 2) Подсчитать количество искомого слова, через map (наполнением значение, где
    // искомое слово будет являться ключом)
    static void task2(String str) {
        System.out.println("Введите слово:");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        scanner.close();
        Map<String, Integer> mapWord = new HashMap<>();
        List<String> newStr = unsignedArray(str);
        
        if (newStr.contains(word.toLowerCase())) {
            mapWord.put(word, 0);
            for (Entry<String, Integer> item : mapWord.entrySet()) {
                for (String string : newStr) {
                    if (string.toLowerCase().equals(item.getKey().toLowerCase())) {
                        mapWord.put(item.getKey(), item.getValue() + 1);
                    }
                }
            }
            System.out.println("Слово \"" + word + "\" в строке \"" + str + "\" встречается " + mapWord.get(word) + " раз(а).");
        } else {
            System.out.println("Слово \"" + word + "\" в строке \"" + str + "\" не встречается.");
        }
    }

    // 3) Найти пересечения слов в массивах и указать их общее количество.
    // Пример: mas1= [“qwe”,”asd”,”qwe”,”x”], mas2=[“qwe”,”v”]
    // Результат: qwe=3
    static void task3(String[] a, String[] b) {
        Map<String, Integer> intersections = new HashMap<>();
        if (a.length < b.length) {
            repetitionList(intersections, a, b);
        } else {
            repetitionList(intersections, b, a);
        }

        List<String> list = new ArrayList<>(Arrays.asList(a));
        Collections.addAll(list, b);

        System.out.println("Пересечения слов в массивах " + Arrays.asList(a).toString() + " и " + Arrays.asList(b).toString() + " и их общее количество:");
        for (Entry<String, Integer> item : intersections.entrySet()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item.getKey())) {
                    intersections.put(item.getKey(), item.getValue() + 1);
                }
            }
            System.out.println(item.getKey() + " = " + item.getValue());
        }
    }

    //Заполнение коллекции элементами, которые находятся в двух массивах
    static void repetitionList(Map<String, Integer> intersections, String[] one, String[] two) {
        for (String string : one) {
            if (availabilityCheck(string, two)) {
                intersections.putIfAbsent(string, 0);
            }
        }
    }

    // проверка элемента на наличие в двух массивах
    static boolean availabilityCheck(String string, String[] array) {
        if (Arrays.asList(array).contains(string)) {
            return true;
        }
        return false;
    }
}
