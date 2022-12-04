import java.util.Comparator;

public class RatingComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return Double.compare(o1.rating, o2.rating);
    }
}
