package lesson6.domain;
import java.util.List;
import java.util.Map;

public interface Repo {
    abstract List<Laptop> getListLaptops();
    abstract Map<Integer, String> getListFilters();
}
