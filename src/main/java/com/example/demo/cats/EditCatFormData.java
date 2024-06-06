package com.example.demo.cats;



public class EditCatFormData extends CreateCatFormData {

    private String id;

    private long version;

    public static EditCatFormData fromCat(Cat cat) {
        EditCatFormData result = new EditCatFormData();
        result.setId(cat.getId().asString());
        result.setCatName(cat.getCatName());
        result.setGender(cat.getGender());
        result.setBirthday(cat.getBirthday());
        result.setSpecies(cat.getSpecies());
        return result;
    }

    public EditCatParameters toParameters()

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
