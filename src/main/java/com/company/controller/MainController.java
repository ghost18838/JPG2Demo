package com.company.controller;

import com.company.dao.DAO;
import com.company.model.Product;
import com.company.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class MainController {

    @FXML
    private ScrollPane scrolpane;

    @FXML
    private TilePane tilePane;

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Product> list = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException {
        DAO<Product, Integer> dao = new ProductService(factory);
        list.addAll(dao.readByAll());

        scrolpane.widthProperty().addListener(((observableValue, number, t1) ->
                tilePane.setPrefWidth(t1.doubleValue())));

        for (Product product : list) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cell.fxml"));
            AnchorPane anchorPane = loader.load();
            CellController controller = loader.getController();
            controller.setItems(product);
            tilePane.getChildren().add(anchorPane);

        }
    }

}
