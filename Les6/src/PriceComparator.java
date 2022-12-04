import java.util.Comparator;

public class PriceComparator implements Comparator<Notebook> {


    @Override
    public int compare(Notebook o1, Notebook o2) {
        return Integer.compare(o1.price, o2.price);
    }
}
