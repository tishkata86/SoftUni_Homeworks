package Problem02_BookShop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String tittle, String author, double price) {
        super(tittle, author, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }

}
