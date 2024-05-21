import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){ //1
        if (allItems == null){ //2
            throw new RuntimeException("allItems list can't be null!"); //3
        } //4
        float sum = 0; //5

        for (int i = 0; i < allItems.size(); i++){ //6
            Item item = allItems.get(i); //7
            if (item.getName() == null || item.getName().length() == 0){ //8
                item.setName("unknown"); //9
            } //10
            if (item.getBarcode() != null){ //11
                String allowed = "0123456789"; //12
                char chars[] = item.getBarcode().toCharArray(); //13
                for (int j = 0; j < item.getBarcode().length(); j++){ //14
                    char c = item.getBarcode().charAt(j); //15
                    if (allowed.indexOf(c) == -1){ //16
                        throw new RuntimeException("Invalid character in item barcode!"); //17
                    } //18
                } //19
                if (item.getDiscount() > 0){ //20
                    sum += item.getPrice()*item.getDiscount(); //21
                } //22
                else { //23
                    sum += item.getPrice(); //24
                } //25
            } //26
            else { //27
                throw new RuntimeException("No barcode!"); //28
            } //29
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){ //30
                sum -= 30; //31
            } //32
        }//33
        if (sum <= payment){ //34
            return true; //35
        } //36
        else { //37
            return false; //38
        } //39
    } //40
}