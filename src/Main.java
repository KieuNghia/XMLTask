import sun.plugin.javascript.JSClassLoader;

import java.io.IOException;

/**
 * Created by nghia on 07.05.2015.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("DOM PARSER");
       System.out.println(BeerFactory.beerBuilder("DOM"));
        System.out.println("JDOM PARSER");
       System.out.println(BeerFactory.beerBuilder("JDOM"));
        System.out.println("SAX PARSER");
       System.out.println(BeerFactory.beerBuilder("SAX"));

        //JSONParserClass jsonParserClass = new JSONParserClass();

       // System.out.println(jsonParserClass.JSONtoObj());

    }
}
