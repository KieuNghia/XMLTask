import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class JDOMParser extends AbstractBuilder {
    public ArrayList xmlParse()

    {
        try {
            org.jdom2.Document file = useDOMParser("beer.xml");
            Element root = file.getRootElement();
            List<Element> beerElementList = root.getChildren("beer");

            for (Element beerElement : beerElementList) {
                Beer beer = new Beer();

                beer.setName(beerElement.getChildText("name"));
                beer.setType(beerElement.getChildText("type"));
                beer.setAl(beerElement.getChildText("al"));
                beer.setManufacturer(beerElement.getChildText("manufacturer"));
                beer.setIngredients(beerElement.getChildText("ingredients"));
                beer.setABW(Double.parseDouble(beerElement.getChild("chars").getChildText("ABW")));
                beer.setFiltered(beerElement.getChild("chars").getChildText("filtered"));
                beer.setFoodValue(Integer.parseInt(beerElement.getChild("chars").getChildText("foodValue")));
                beer.setBottleVolume(Integer.parseInt(beerElement.getChild("chars").getChild("bottleCharacteristic").getChildText("volume")));
                beer.setBottleType(beerElement.getChild("chars").getChild("bottleCharacteristic").getChildText("bottleTpe"));
                beers.add(beer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return beers;
    }


    private static org.jdom2.Document useDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);

    }
}
