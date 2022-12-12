package lesson2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        int[] arr = new int[] {155, -123, 255, 80, 40, -323, 80, 99, 408, 655, -8, -4, 1008};
        
        Scanner scanner = new Scanner(System.in);
        task1(scanner);
        task2(scanner);
        task3(scanner);
        System.out.println("4) " + task4(scanner));
        scanner.close();

        System.out.println("\nИсходный массив: " + Arrays.toString(arr));
        task5(arr);
        System.out.printf("2) %s\n", task6(arr));
        task7(arr);

    System.out.println();
    double celsiusDegrees = 10;
    System.out.println(celsiusDegrees + "(°C) градусов по Цельсию это:");
    KelvinDegrees kelvinDegrees = new KelvinDegrees(celsiusDegrees);
    FahrenheitDegrees fahrenheitDegrees = new FahrenheitDegrees(celsiusDegrees);
    System.out.println(kelvinDegrees);
    System.out.println(fahrenheitDegrees);

    }

    // 1) Дана последовательность N целых чисел. Найти количество положительных чисел, после которых следует отрицательное число.
    static void task1(Scanner scanner) {
        int amount = 0, num1, num2, n;
        System.out.println("Введите длину последовательности: ");
        n = scanner.nextInt();
        System.out.println("Введите числа: ");
        num1 = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            num2 = scanner.nextInt();

            if (num1 > 0 && num2 < 0) {
                amount += 1;
            }
            num1 = num2;
        }
        System.out.printf("1) Количество положительных чисел, после которых следует отрицательное число: %s\n", amount);
    }

    // 2) Дана последовательность целых чисел, оканчивающаяся нулем. Найти сумму положительных чисел, после которых следует отрицательное число.
    static void task2(Scanner scanner) {
        int amount = 0, num1, num2, n;
        System.out.println("Введите длину последовательности: ");
        n = scanner.nextInt();
        System.out.println("Введите числа: ");
        num1 = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            num2 = scanner.nextInt();

            if (num1 > 0 && num2 < 0) {
                amount += num1;
            }
            num1 = num2;
        }
        System.out.printf("2) Сумма положительных чисел, после которых следует отрицательное число: %s\n", amount);
    }

    // 3) Дана последовательность N целых чисел. Найти сумму простых чисел.
    static void task3(Scanner scanner) {
        int amount = 0, num1, n;
        System.out.println("Введите длину последовательности: ");
        n = scanner.nextInt();
        System.out.println("Введите числа: ");
        for (int i = 0; i < n; i++) {
            num1 = scanner.nextInt();
            boolean flag = true;
            for (int j = 2; j < num1; j ++) {
                if (num1 % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) amount += num1;
        }
        System.out.printf("3) Сумма простых чисел: %s\n", amount);
    }

    // 4) Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.
    static String task4(Scanner scanner) {
        int num1, num2, n;
        String answer = "Последовательность является возрастающей";
        System.out.println("Введите длину последовательности: ");
        n = scanner.nextInt();
        System.out.println("Введите числа: ");
        num1 = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            num2 = scanner.nextInt();

            if (num2 > num1) {
                num1 = num2;
            }
            else {
                answer = "Последовательность не является возрастающей";
            }
        }
        return answer;
    }

    //5)Дан массив целых чисел. Найти сумму элементов, у которых последняя и предпоследняя цифры равны.
    static void task5(int[] arr) {
        int sum = 0;
         for (int num : arr) {
            if (num > 100 || num < -100) {
                if ((num % 100) % 10 == (num % 100) / 10) {
                    sum += num;
                }
            }
        }
        System.out.println("5) Cумма элементов, у которых последняя и предпоследняя цифры равны: " + sum);

        // Ниже решение, в котором у всех элементов сравниваются последние и предпоследние цифры, например 108 и 508

        // ArrayList<Integer> new_arr = new ArrayList<>();
        // for (int num : arr) {
        //     new_arr.add(num);
        // }
        // int sum = 0;
        // for (int i = 0; i <= new_arr.size() - 1; i++) {
        //     int new_sum = sum;
        //     if(new_arr.get(i) % 100 > 1 || new_arr.get(i) % 100 < -1) {
        //         for (int j = i + 1; j < new_arr.size(); j++) {
        //             if (new_arr.get(j) % 100 > 1 && new_arr.get(i) % 100 == new_arr.get(j) % 100 
        //             || new_arr.get(j) % 100 < -1 && new_arr.get(i) % 100 == new_arr.get(j) % 100 ) {
        //                 sum += new_arr.get(j);
        //                 new_arr.remove(j);
        //             }
        //         }
        //     }
        //     if (sum != new_sum) sum += new_arr.get(i);
        // }
    }

    //6)Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.
    static String task6(int[] arr) {
        ArrayList<Integer> new_arr = new ArrayList<>();
        int sumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] / 100 < 1) {
                sumIndex += i;
            }
        }

        for (int element : arr) {
            if (element > 0) {
                new_arr.add(element);
            }
            if (element < 0) {
                new_arr.add(sumIndex);
            }
        }
        return "Замена отрицательных элементов на сумму индексов двузначных элементов:\n" + String.valueOf(new_arr);
    }

    // 7)Дан массив целых чисел. Найти количество пар соседних элементов, где первый элемент вдвое больше второго.
    static void task7(int[] arr) {
        int amountPair = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] / arr[i + 1] == 2) {
                amountPair += 1;
            }
        }
        System.out.println("7) Количество пар соседних элементов, где первый элемент вдвое больше второго: " + amountPair);
    }

    
}
