package lesson6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller.showLaptops();
        showMenu();
    }

    static void showMenu() {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        while (!end) {
            System.out.println("Изменить фильтр поиска? (2 - да, 1 - нет, 0 - выход)");
            int n = scanner.nextInt();
            switch (n) {
                case 2:
                    outputFilters(scanner);
                    break;
                case 1:
                    Controller.showLaptops();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    static void outputFilters(Scanner scanner) {
        int variant = 0;
        while (variant != 5) {
            System.out.println("\n########### Фильтры ###########");
            System.out.printf(
                    "1 - оперативная память(%s) ГБ\n2 - размер жесткого диска(%s) ГБ\n3 - операционная система(%s)\n4 - цвет(%s)\n5 - показать товары\nВведите номер: ",
                    Controller.getFilters(1), Controller.getFilters(2), Controller.getFilters(3), Controller.getFilters(4));
            variant = scanner.nextInt();
            changeFilter(scanner, variant);
        }
        // когда variant равен 5
        Controller.showLaptops();
    }

    static void changeFilter(Scanner scanner, int num) {
        int size;
        switch (num) {
            case 1:
                System.out.printf(
                        "Выберите размер оперативной памяти\n1 - от 2 ГБ до 8 ГБ\n2 - от 12 ГБ до 64 ГБ\n3 - Все\nВведите номер: ");
                size = scanner.nextInt();
                if (size == 1) {
                    Controller.changeFilter(1, "2-8");
                } else if (size == 2) {
                    Controller.changeFilter(1, "12-64");
                } else if (size == 3) {
                    Controller.changeFilter(1, "все");
                }
                break;
            case 2:
                System.out.printf(
                        "Выберите размер жесткого диска\n1 - от 32 ГБ до 128 ГБ\n2 - от 256 ГБ до 2 ТБ\n3 - Все\nВведите номер: ");
                size = scanner.nextInt();
                if (size == 1) {
                    Controller.changeFilter(2, "32-128");
                } else if (size == 2) {
                    Controller.changeFilter(2, "256-2000");
                } else if (size == 3) {
                    Controller.changeFilter(2, "все");
                }
                break;
            case 3:
                System.out.printf(
                        "Выберите операционную систему\n1 - Windows 10\n2 - Windows 11\n3 - Без ОС\n4 - Все\nВведите номер: ");
                size = scanner.nextInt();
                if (size == 1) {
                    Controller.changeFilter(3, "Windows 10");
                } else if (size == 2) {
                    Controller.changeFilter(3, "Windows 11");
                } else if (size == 3) {
                    Controller.changeFilter(3, "Без ОС");
                } else if (size == 4) {
                    Controller.changeFilter(3, "все");
                }
                break;
            case 4:
                System.out.printf(
                        "Выберите цвет\n1 - Черный\n2 - Серый\n3 - Белый\n4 - Синий\n5 - Серебристый\n6 - Все\nВведите номер: ");
                size = scanner.nextInt();
                if (size == 1) {
                    Controller.changeFilter(4, "Черный");
                } else if (size == 2) {
                    Controller.changeFilter(4, "Серый");
                } else if (size == 3) {
                    Controller.changeFilter(4, "Белый");
                } else if (size == 4) {
                    Controller.changeFilter(4, "Синий");
                } else if (size == 5) {
                    Controller.changeFilter(4, "Серебристый");
                } else if (size == 6) {
                    Controller.changeFilter(4, "все");
                }
                break;
            default:
                break;
        }
    }
}
