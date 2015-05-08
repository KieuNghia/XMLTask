import java.util.ArrayList;

public class BeerFactory {
    public static ArrayList beerBuilder(String parser) {
        switch (parser) {
            case "DOM":
                return new DOMParser().xmlParse();
            case "JDOM":
                return new JDOMParser().xmlParse();
            case "SAX":
                return new SAXParserClass().xmlParse();
            default:
               return null;
        }
    }
}