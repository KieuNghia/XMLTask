import java.util.ArrayList;


public abstract class AbstractBuilder {
    ArrayList<Beer> beers = new ArrayList<Beer>();

    public abstract ArrayList xmlParse();
}
