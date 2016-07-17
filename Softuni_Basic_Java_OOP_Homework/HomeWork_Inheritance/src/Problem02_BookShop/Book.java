package Problem02_BookShop;

public class Book {
    private String tittle;
    private String author;
    private double price;

    public Book(String author, String tittle, double price) {
        setAuthor(author);
        setTittle(tittle);
        setPrice(price);
    }

    public String getTittle() {
        return tittle;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    private void setTittle(String tittle) {
        if (tittle.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.tittle = tittle;
    }

    private void setAuthor(String author) {
        for (int i = 0; i < author.length(); i++) {
            if (Character.isDigit(author.charAt(i))){
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if (price <= 0.0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTittle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());

        return sb.toString();

    }
}
