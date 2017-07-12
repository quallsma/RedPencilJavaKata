import java.time.LocalDate;

/**
 * Created by marsalisqualls on 7/12/17.
 */
public class Item {
    private double price;
    private LocalDate date;

    public Item(double price, LocalDate date){
        this.price = price;
        this.date = date;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public LocalDate getDate(){
        return date;
    }
}
