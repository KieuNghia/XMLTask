import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONParserClass{

    public ArrayList JSONtoObj() {
        ArrayList<Beer> beers = new ArrayList<Beer>();

        try {

            FileReader reader = new FileReader("beer.json");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray beer = (JSONArray) jsonObject.get("Beer");


            Iterator i = beer.iterator();

            while (i.hasNext()) {

                Beer b = new Beer();
                JSONObject beerElement = (JSONObject) i.next();
                b.setName((String) beerElement.get("name"));
                b.setType((String) beerElement.get("type"));
                b.setIngredients((String) beerElement.get("ingredients"));
                b.setABW((Integer) beerElement.get("ABW"));

                JSONObject chars = (JSONObject) beerElement.get("chars");
                b.setFiltered((String) chars.get("filtered"));
                b.setFoodValue((Integer) chars.get("foodValue"));

                JSONObject bottleChars = (JSONObject) chars.get("bottleCharacteristic");
                b.setBottleVolume((Integer) bottleChars.get("volume"));
                b.setBottleType((String) bottleChars.get("volume"));


                beers.add(b);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return beers;
    }
}
