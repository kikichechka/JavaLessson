package lesson6.domain;

public class Laptop {
    String name;
    String operatingSystem; // операционная система
    int ram; // оперативная память
    String processor; // производитель процессора
    int storageCapacity; // объем жесткого диска
    String color;

    public Laptop() {
    }

    public Laptop(String name, String operatingSystem, int ram, String processor, int storageCapacity, String color) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.processor = processor;
        this.storageCapacity = storageCapacity;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (storageCapacity < 1000) {
            return "Ноутбук " + name + "\nОперационная система: " + operatingSystem + "\nПроизводитель процессора: "
                    + processor + "\nОбъем оперативной памяти: " + ram + " ГБ\nОбъем накопителя: " + storageCapacity
                    + " ГБ\nЦвет: " + color;
        } else {
            return "Ноутбук " + name + "\nОперационная система: " + operatingSystem + "\nПроизводитель процессора: "
                    + processor + "\nОбъем оперативной памяти: " + ram + " ГБ\nОбъем накопителя: "
                    + storageCapacity / 1000 + " ТБ\nЦвет: " + color;
        }
    }
}
