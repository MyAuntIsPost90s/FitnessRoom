package fitnessroom.base.model;

public class Foods {
    private String foodid;

    private String foodname;

    private String foodcontent;

    private String foodimgurl;

    private Float foodprice;

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodcontent() {
        return foodcontent;
    }

    public void setFoodcontent(String foodcontent) {
        this.foodcontent = foodcontent;
    }

    public String getFoodimgurl() {
        return foodimgurl;
    }

    public void setFoodimgurl(String foodimgurl) {
        this.foodimgurl = foodimgurl;
    }

    public Float getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Float foodprice) {
        this.foodprice = foodprice;
    }
}