package com.example.WebSiteCoursework.services;

import com.example.WebSiteCoursework.entities.Product;
import com.example.WebSiteCoursework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProduct(Integer id) {
        Optional<Product> products = productRepository.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        products.ifPresent(res::add);
        return res;
    }

    public List<Product> getProductsByType(Integer id) {
        return productRepository.findByType_Id(id);
    }

    public List<Product> getProductsByCustomer(Integer id) {
        return productRepository.findByMyOrders_Customer_Id(id);
    }

    public void addProduct(Integer p_id, String img_address, String name, String price, String text_about) {
        Product product = getProduct(p_id).get(0);

        product.setImg_address(img_address);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setText_about(text_about);

        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
