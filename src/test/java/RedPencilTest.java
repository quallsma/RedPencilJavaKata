import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by marsalisqualls on 7/12/17.
 */
public class RedPencilTest {

    private RedPencil redPencil;
    private RedPencil redPencil1;

    @Before
    public void setup(){
        redPencil = new RedPencil(100.0d, LocalDate.of(2017, 05, 10) );
        //redPencil1 = new RedPencil(100.0d, LocalDate.of(2017, 07, 10) );
    }

    @Test
    public void redPencil_ReturnsOriginalPriceWhenNoPromotion(){
        assertEquals(100.0d, redPencil.getPrice(), 0);
    }

    @Test
    public void redPencil_ReturnsReducedPriceWhenReductionIsAdded(){
        redPencil.reducePriceByPercentage(10);

        assertEquals(90.0d, redPencil.getPrice(), 0);
    }

    @Test
    public void redPencil_ReturnOriginalPriceIfReductionIsNotBetween5And30(){
        redPencil.reducePriceByPercentage(4);

        assertEquals(100.0d, redPencil.getPrice(), 0);

        redPencil.reducePriceByPercentage(31);

        assertEquals(100.0d, redPencil.getPrice(), 0);
    }

    @Test
    public void redPencil_ReturnsOrignalPriceIfDateLessThan30Days(){
        redPencil1 = new RedPencil(100.0d, LocalDate.now() );
        redPencil1.reducePriceByPercentage(5);

        assertEquals(100.0d, redPencil1.getPrice(), 0);
    }

    @Test
    public void redPencil_ReturnsReducedPriceWhenStartDateIsGreaterThan30DaysFromToday(){
        redPencil1 = new RedPencil(100.0d, LocalDate.of(2016, 10,28));
        redPencil1.reducePriceByPercentage(5);

        assertEquals(95.0d, redPencil1.getPrice(), 0);
    }
}
