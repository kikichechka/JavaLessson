package lesson3;

public class Book {
    String name;
    String authorSurname;
    Double price;
    Integer yearPublishing;
    Integer pages;

    public Book() {
    }

    public Book(String name, String authorSurname, Double price, Integer yearPublishing, Integer pages) {
        this.name = name;
        this.authorSurname = authorSurname;
        this.price = price;
        this.yearPublishing = yearPublishing;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getYearPublishing() {
        return yearPublishing;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Название книги: " + name + ", автор: " + authorSurname + ", цена: " + price + " руб., год издания: "
                + yearPublishing + ", кол. страниц: " + pages + ".";
    }
}
