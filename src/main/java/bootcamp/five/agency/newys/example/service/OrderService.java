package bootcamp.five.agency.newys.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public String getProductNme() {
        return productService.getProductName();
    }
}
