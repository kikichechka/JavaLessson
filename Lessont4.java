import java.util.Scanner;
import java.util.Stack;

public class Lessont4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task1(scanner);
        task2(scanner);
        scanner.close();
    }

    // 1) Вывести список на экран в перевернутом виде (без массивов)
    // Пример: 1 -> 2->3->4
    // Вывод: 4->3->2->1
    static void task1(Scanner scanner) {
        Stack<Integer> list = new Stack<>();
        System.out.println("Введите множесто:");
        int n = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                list.push(n);
            }
            list.push(scanner.nextInt());
        }

        System.out.println("Список в перевернутом виде:");
        while (!list.empty()) {
            System.out.print(list.peek().toString() + " ");
            list.pop();
        }
        System.out.println();
    }

    // 2) Определить является ли список знакочередующимся? (без массивов)
    static void task2(Scanner scanner) {
        boolean flag = true;
        System.out.println("Введите длину последовательности:");
        int n = scanner.nextInt();
        System.out.println("Введите последовательность: ");
        int num1 = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            int num2 = scanner.nextInt();
            if (!correctness(num1, num2)) {
                flag = false;
            }
            num1 = num2;
        }
        if(flag) {
            System.out.println("Список является знакочередующимся!");
        } else {
            System.out.println("Список не является знакочередующимся!");
        }
    }

    static boolean correctness(int a, int b) {
        if (a < 0 && b >= 0 || a >= 0 && b < 0) {
            return true;
        } else {
            return false;
        }
    }
}
