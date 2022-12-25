package lesson6.domain;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepoImpl implements Repo {

    @Override
    public List<Laptop> getListLaptops() {
        List<Laptop> listLaptops = Arrays.asList(
            new Laptop("Lenovo V15 G2 ALC 82KD008NUK", "Windows 11", 8, "AMD", 256, "Черный"),
            new Laptop("Lenovo IdeaPad 3 15.6 i3-1115G4 11 Home Almond", "Windows 11", 8, "Intel",
                    256, "Серый"),
            new Laptop("Lenovo V15 G2 ALC 82KD008NUK", "Windows 11", 8, "AMD", 256, "Черный"),
            new Laptop("Lenovo IdeaPad 3 15.6 i3-1115G4 11 Home Almond", "Windows 11", 8, "Intel",
                    256, "Серый"),
            new Laptop("Xiaomi RedmiBook 15 JYU4525RU", "Windows 11", 8, "Intel", 256, "Белый"),
            new Laptop("Digma EVE 10 C300 (ES1040EW)", "Windows 10", 2, "Intel", 32, "Черный"),
            new Laptop("Irbis NB259", "Windows 10", 4, "Intel", 64, "Серый"),
            new Laptop("ASUS R214MA-GJ373T", "Windows 10", 4, "Intel", 128, "Синий"),
            new Laptop("Haier U1520EM", "Windows 10", 4, "Intel", 64, "Серебристый"),
            new Laptop("HP 240 G7 (2V0E3ES)", "Windows 10", 4, "Intel", 128, "Черный"),
            new Laptop("Acer A315-34-C5XL (NX.HE3EM.00J)", "Без ОС", 4, "Intel", 1000, "Черный"),
            new Laptop("Prestigio SmartBook 141 C7 Metal Grey (PSB141C07CHH_MG_CIS)", "Windows 10",
                    4, "Intel", 128, "Серый"),
            new Laptop("Digma Eve 15 C423 Cel N3350 (ES5069EW)", "Windows 10", 4, "Intel", 128,
                    "Серый"),
            new Laptop("Acer Predator Helios 500 PH517-52-94RQ (NH.QCNER.003)", "Windows 10", 64,
                    "Intel", 2000, "Черный"),
            new Laptop("MSI Creator 17 A10SFS-471RU", "Windows 10", 32, "Intel", 1000, "Серый"));
        return listLaptops;
    }

    @Override
    public Map<Integer, String> getListFilters() {
        Map<Integer, String> filters = new HashMap<>();
        filters.put(1, "все"); // размер оперативной памяти
        filters.put(2, "все"); // размер жесткого диска
        filters.put(3, "все"); // операционную систему
        filters.put(4, "все"); // цвет
        return filters;
    }
}
