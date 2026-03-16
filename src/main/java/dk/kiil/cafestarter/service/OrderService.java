package dk.kiil.cafestarter.service;

import dk.kiil.cafestarter.dto.CreateOrderRequest;
import dk.kiil.cafestarter.model.Order;
import org.springframework.stereotype.Service;
import dk.kiil.cafestarter.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final MenuItemService menuItemService;
    private final List<Order> orders;

    public OrderService(MenuItemService menuItemService) {
        this.orders = new ArrayList<>(List.of(
                new Order(1L, "Maja", 1L, "Latte", "NEW"),
                new Order(2L, "Ali", 2L, "Croissant", "READY")
        ));
        this.menuItemService = menuItemService;
    }

    public List<Order> findAll() {
        return List.copyOf(orders);
    }

    private Long nextOrderOId = 3L;

    public Order createOrder(CreateOrderRequest request){
        MenuItem selectedMenuItem = null;

        for (MenuItem menuItem : menuItemService.findAll()){
            if(menuItem.getId().equals(request.menuItemId())){
                selectedMenuItem = menuItem;
                break;
            }
        }

        if (selectedMenuItem == null) {
            throw new IllegalArgumentException("unknown menu item id");

        }
    

        Order newOrder = new Order(
            nextOrderOId,
            request.customerName(), 
            request.menuItemId(), 
            selectedMenuItem.getName(), 
            "NEW");

            nextOrderOId++;
        
        return newOrder;
    }


    


}
