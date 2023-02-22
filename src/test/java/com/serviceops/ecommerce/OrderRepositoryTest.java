package com.serviceops.ecommerce;

import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    ProductRepository productrepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository crepo;

    @Autowired
    private SubCategoryRepository subCategoryrepo;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    void orderProductRepo(){
        User save = userRepository.findByUserEmail("rohan@gmail.com");
        Category c = crepo.save(new Category("Electronics"));

        SubCategory subcat = subCategoryrepo.save(new SubCategory("Laptop",c));
        Product product = productrepo.save(new Product("HP", "Newlatest ",78890,subcat));

        Order order = new Order();
        order.setUser(save);
        order.setTotalPrice(order.getTotalPrice());
        orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setPrice(product.getProductPrice());
        orderItem.setQuantity(23);
        orderItem.setOrder(order);
        orderItemRepository.save(orderItem);
        orderRepository.save(new Order(123,save,orderItems));




    }

}
