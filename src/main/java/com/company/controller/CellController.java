package com.company.controller;

import com.company.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CellController {

    @FXML
    private Label txtTitle;
    @FXML
    private Label txtDescription;
    @FXML
    private ImageView imageView;

    Product product = new Product();
    public void setItems(Product product){
        txtTitle.setText(product.getTitle());
        txtDescription.setText(product.getDescription());
        imageView.setImage(new Image("\\"+product.getMainImagePath()));
    }
}
