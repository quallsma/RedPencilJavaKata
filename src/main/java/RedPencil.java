import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * Created by marsalisqualls on 7/12/17.
 */
public class RedPencil extends Item {

    private double reducedPercentage = 0.0d;

    public RedPencil(double price, LocalDate date){
        super(price, date);
    }


    public void reducePriceByPercentage(int percentage) {
        this.reducedPercentage = (percentage / 100.0d) + this.reducedPercentage;
    }

    @Override
    public double getPrice(){
        if (isPercentageValid() && isDateValid())
            return super.getPrice() * (1 - reducedPercentage);
        return super.getPrice();
    }

    private boolean isPercentageValid(){
        return (reducedPercentage >= 0.05d && reducedPercentage <= 0.3d);
    }

    private boolean isDateValid(){
        LocalDate newDate = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(super.getDate(), newDate);
        return daysBetween >= 30;
    }
}
