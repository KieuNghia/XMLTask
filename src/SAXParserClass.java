
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class SAXParserClass extends AbstractBuilder {
    public ArrayList xmlParse() {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean bBeer = false;
                boolean bName = false;
                boolean bType = false;
                boolean bAl = false;
                boolean bManufacturer = false;
                boolean bIngredients = false;
                boolean bABW = false;
                boolean bFiltered = false;
                boolean bFoodValue = false;
                boolean bBottleVolume = false;
                boolean bBbottleType = false;


                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("BEER")) {
                        bBeer = true;
                    }
                    if (qName.equalsIgnoreCase("NAME")) {
                        bName = true;
                    }
                    if (qName.equalsIgnoreCase("TYPE")) {
                        bType = true;
                    }

                    if (qName.equalsIgnoreCase("AL")) {
                        bAl = true;
                    }

                    if (qName.equalsIgnoreCase("MANUFACTURER")) {
                        bManufacturer = true;
                    }

                    if (qName.equalsIgnoreCase("INGREDIENTS")) {
                        bIngredients = true;
                    }

                    if (qName.equalsIgnoreCase("ABW")) {
                        bABW = true;
                    }

                    if (qName.equalsIgnoreCase("FILTERED")) {
                        bFiltered = true;
                    }

                    if (qName.equalsIgnoreCase("FOODVALUE")) {
                        bFoodValue = true;
                    }

                    if (qName.equalsIgnoreCase("BOTTLEVOLUME")) {
                        bBottleVolume = true;
                    }



                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("BOTTLETYPE")){
                        bBbottleType = true;
                    }
                }


                Beer b;

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bBeer) {
                        b = new Beer();

                        bBeer = false;

                    }
                    if (bName) {
                        b.setName(new String(ch, start, length));
                        bName = false;
                    }
                    if (bType) {
                        b.setType(new String(ch, start, length));
                        bType = false;
                    }
                    if (bAl) {
                        b.setAl(new String(ch, start, length));
                        bAl = false;
                    }

                    /*if (bManufacturer) { ????
                        b.setManufacturer(new String(ch, start, length));
                        bManufacturer = false;
                    }*/

                    if (bIngredients) {
                        b.setIngredients(new String(ch, start, length));
                        bIngredients = false;
                    }

                    if (bABW) {
                        b.setABW(Double.parseDouble(new String(ch, start, length)));
                        bABW = false;
                    }
                    if (bFiltered) {
                        b.setFiltered(new String(ch, start, length));
                        bFiltered = false;
                    }
                    if (bFoodValue) {
                        b.setFoodValue(Integer.parseInt(new String(ch, start, length)));
                        bFoodValue = false;
                    }
                    if (bBottleVolume) {
                        b.setBottleVolume(Integer.parseInt(new String(ch, start, length)));
                        bBottleVolume = false;
                    }
                    if (bBbottleType) {
                        b.setBottleType(new String(ch, start, length));
                        bBbottleType = false;
                        beers.add(b);


                    }




                }
            };

            saxParser.parse("beer.xml", defaultHandler);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        return beers;
    }


}
