package dk.kiil.cafestarter.service;

import dk.kiil.cafestarter.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>(List.of(
                new Order(1L, "Maja", 1L, "Latte", "NEW"),
                new Order(2L, "Ali", 2L, "Croissant", "READY")
        ));
    }

    public List<Order> findAll() {
        return List.copyOf(orders);
    }



    


}
