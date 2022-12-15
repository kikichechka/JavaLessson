package lesson3;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        System.out.println("\nЗадача №1:");
        Product[] list = new Product[] { new Product("Картофель. Высший сорт", 109.90, 1),
        new Product("Шоколад бельгийский. Высший сорт", 280.15, 2),
        new Product("Чай гранулированный", 380.0, 1),
        new Product("Зефир фруктовый", 190.0, 3)
        };
        System.out.println("Наибольшая цена товаров 1-го и 2-го сорта, название которых содержит слово \"высший\" = "
        + task1(list) + " руб.");

        Product[] list2 = new Product[] { new Product("Картофель", "Россия", 5.100, 109.90, 2),
        new Product("Шоколад бельгийский", "Бельгия", 0.200, 350.0, 2),
        new Product("Чай гранулированный", "Индия", 290.0, 380.0, 1),
        new Product("Зефир фруктовый, высшей категории", "Беларусь", 260.5, 190.0,3),
        new Product("Кофе зерновой", "Колумбия", 0.800, 350.0, 2),
        new Product("Конфеты. Ириска золотая", "Россия", 0.100, 109.90, 2)
        };
        System.out.println("\nЗадача №2:");
        task2(list2);

        Book[] books = new Book[] { new Book("Фантастика", "Акунин", 346.0, 2005, 462),
        new Book("Убить пересмешника", "Харпер", 1200.0, 1960, 460),
        new Book("Гордость и предубеждение", "Остен", 620.50, 1813, 490),
        new Book("Книжный вор", "Зусак", 430.0, 2005, 290),
        new Book("Реквием", "Ахматова", 329.0, 1963, 313),
        new Book("Граф Монте-Кристо", "Дюма", 690.0, 1844, 431),
        new Book("Дюймовочка", "Андерсен", 780.0, 1835, 109),
        new Book("Пятьдесят оттенков серого", "Джеймс", 670.90, 2011, 425)
        };
        System.out.println("\nЗадача №3:");
        task3(books);

        System.out.println("\nЗадача №4:");
        int[] number = new int[] { 1, 2, 3 };
        System.out.println(Arrays.deepToString(task4(number)));
    }

    // 1. Дан массив записей: наименование товара, цена, сорт.
    // Найти наибольшую цену товаров 1го или 2го сорта среди товаров, название которых содержит «высший».
    static Double task1(Product[] list) {
        Double topPrice = 0.0;
        String str = "высший";
        for (int i = 0; i < list.length; i++) {
            if (list[i].name.toLowerCase().contains(str) && list[i].variety < 3) {
                if (list[i].price > topPrice) {
                    topPrice = list[i].price;
                }
            }
        }
        return topPrice;
    }

    // 2. Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта.
    // Получить наименования товаров заданного сорта с наименьшей ценой.
    static void task2(Product[] list) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите сорт товара (от 1 до 3):");
            Integer variety = scanner.nextInt();
            if (variety >= 1 && variety <= 3) {
                scanner.close();
        
                ArrayList<Product> listSpecifiedVariety = new ArrayList<>();
        
                for (int i = 0; i < list.length; i++) {
                    if (list[i].variety == variety) {
                        listSpecifiedVariety.add(list[i]);
                    }
                }
        
                Product[] sortListSpecifiedVariety = listSpecifiedVariety.toArray(new Product[listSpecifiedVariety.size()]);
                Arrays.sort(sortListSpecifiedVariety);
                Double minPrice = sortListSpecifiedVariety[0].price;
        
                System.out.println("Товары " + variety + " сорта с наименьшей ценой:");
                for (int i = 0; i < sortListSpecifiedVariety.length; i++) {
                    if (Math.abs(sortListSpecifiedVariety[i].price - minPrice) <= 0.00001) {
                        System.out.println(sortListSpecifiedVariety[i].toString());
                    } else {
                        break;
                    }
                }
                break;
            }
        } 
    }

    // 3. Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц.
    // Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания не позднее 2010 г.
    static void task3(Book[] books) {
        String letter = "А";
        Integer year = 2010;
        System.out.println(
                "Названия книг, в которых простое количество страниц, фамилия автора содержит \"А\" и год издания не позднее 2010 г.: ");
        for (int i = 0; i < books.length; i++) {
            if (books[i].authorSurname.contains(letter) && books[i].yearPublishing < year) {
                boolean flag = true;
                for (int j = 2; j < books[i].pages / 2; j++) {
                    if (books[i].pages % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    System.out.println(books[i].toString());
            }
        }
    }

    // 4. при входном массиве, вернуть массив массивов со всеми перестановками его элементов. (со звездочкой)
    // Пример входных данных: [1,2,3]
    // Пример выходных данных: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    static int[][] task4(int[] numbers) {
        int result = 1;

        for (int i = 1; i <= numbers.length; i++) {
            result = result * i;
        }

        int[][] listCombinations = new int [result][1];
        listCombinations[0] = numbers;

        for (int i = 1; i < listCombinations.length; i++) {
            listCombinations[i] = uniqueСombination(numbers, listCombinations, i);
        }    
        return listCombinations;
    }    

    // метод для подбора уникальной комбинации
    static int[] uniqueСombination(int [] numbers, int[][] listCombinations, int i) {
        while (true) { 
            int[] combination = formCombination(numbers);
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (Arrays.equals(listCombinations[j], combination)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return combination;
            }
        }
    }

    //метод для подбора комбинации без повторения чисел
    static int[] formCombination(int[] numbers) {
        Random random = new SecureRandom();
        int[] combination = new int[numbers.length];
        for (int j = 0; j < combination.length; j++) {
            while (true) {
                int elementRandom = numbers[random.nextInt(numbers.length)];
                if (Arrays.stream(combination).anyMatch(x -> x == elementRandom) == false) {
                    combination[j] = elementRandom;
                    break;
                }
            }
        } 
        return combination;
    }
}
