import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;



public class DOMParser extends AbstractBuilder{
    @Override
    public ArrayList xmlParse() {
        try {
            File xmlFile = new File("beer.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList beerNodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
            System.out.println("--------------------");
            for (int tmp = 0; tmp < beerNodeList.getLength(); tmp++) {
                Node node = beerNodeList.item(tmp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Beer beer = new Beer();

                    beer.setName(element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
                    beer.setType(element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue());
                    beer.setAl(element.getElementsByTagName("al").item(0).getChildNodes().item(0).getNodeValue());
                    beer.setManufacturer(element.getElementsByTagName("manufacturer").item(0).getChildNodes().item(0).getNodeValue());
                    beer.setIngredients(element.getElementsByTagName("ingredients").item(0).getChildNodes().item(0).getNodeValue());
                    beer.setABW(Double.parseDouble(element.getElementsByTagName("ABW").item(0).getChildNodes().item(0).getNodeValue()));
                    beer.setFiltered(element.getElementsByTagName("filtered").item(0).getChildNodes().item(0).getNodeValue());
                    beer.setFoodValue(Integer.parseInt(element.getElementsByTagName("foodValue").item(0).getChildNodes().item(0).getNodeValue()));
                    beer.setBottleVolume(Integer.parseInt(element.getElementsByTagName("filtered").item(0).getChildNodes().item(0).getNodeValue()));
                    beer.setBottleType(element.getElementsByTagName("bottleType").item(0).getChildNodes().item(0).getNodeValue());
                    beers.add(beer);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return beers;//toDo
    }
}


