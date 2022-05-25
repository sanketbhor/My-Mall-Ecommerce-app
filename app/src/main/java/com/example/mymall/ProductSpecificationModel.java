package com.example.mymall;

public class ProductSpecificationModel {

    public static final int SPECIFICATION_TITLE = 0;
    public static final int SPECIFICATION_BODY = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /////////// Specification title
    private String title;

    public ProductSpecificationModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /////////// Specification title

    /////////// Specification body

    private String feautureName;
    private String featureValue;

    public ProductSpecificationModel(int type, String feautureName, String featureValue) {
        this.type = type;
        this.feautureName = feautureName;
        this.featureValue = featureValue;
    }

    public String getFeautureName() {
        return feautureName;
    }

    public void setFeautureName(String feautureName) {
        this.feautureName = feautureName;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
    /////////// Specification body

}
