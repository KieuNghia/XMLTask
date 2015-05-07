import java.util.ArrayList;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/6/2015.
 */
public class Beer {
    private String name;
    private String type;
    private String al;
    private String manufacturer;
    private String ingredients;
    private double ABW;
    private String filtered;
    private int foodValue;
    private int bottleVolume;
    private String bottleType;

    public Beer(String name, String type, String al, String manufacturer, String ingredients, double ABW, String filtered, int foodValue, int bottleVolume, String bottleType) {
        this.name = name;
        this.type = type;
        this.al = al;
        this.manufacturer = manufacturer;
        this.ingredients = ingredients;
        this.ABW = ABW;
        this.filtered = filtered;
        this.foodValue = foodValue;
        this.bottleVolume = bottleVolume;
        this.bottleType = bottleType;
    }

    public Beer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getABW() {
        return ABW;
    }

    public void setABW(double ABW) {
        this.ABW = ABW;
    }

    public String getFiltered() {
        return filtered;
    }

    public void setFiltered(String filtered) {
        this.filtered = filtered;
    }

    public String getAl() {
        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(int foodValue) {
        this.foodValue = foodValue;
    }

    public int getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(int bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    public String getBottleType() {
        return bottleType;
    }

    public void setBottleType(String bottleType) {
        this.bottleType = bottleType;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", al=" + al +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", ABW=" + ABW +
                ", filtered=" + filtered +
                ", foodValue=" + foodValue +
                ", bottleVolume=" + bottleVolume +
                ", bottleType='" + bottleType + '\'' +
                '}';
    }
}
