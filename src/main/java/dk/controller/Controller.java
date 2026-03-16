package dk.controller;

import dk.kiil.cafestarter.dto.MenuItemResponse;
import dk.kiil.cafestarter.dto.OrderResponse;
import dk.kiil.cafestarter.service.MenuItemService;
import dk.kiil.cafestarter.service.OrderService;
import dk.kiil.cafestarter.model.*;

import dk.kiil.cafestarter.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalBorders.MenuItemBorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class Controller {

    private final MenuItemService menuItemService;
    private final OrderService orderService;

    Controller(MenuItemService menuItemService, OrderService orderService) {
        this.menuItemService = menuItemService;
        this.orderService = orderService;
    }

    @GetMapping("/menu-items")
    public List<MenuItemResponse> getAllMenuItems() {

        List<MenuItemResponse> response = new ArrayList<>();

        for (MenuItem menuItem : menuItemService.findAll()) {

            response.add(new MenuItemResponse(
                    menuItem.getId(),
                    menuItem.getName(),
                    menuItem.getCategory(),
                    menuItem.getPrice()

            ));

        }

        return response;
    }

    @GetMapping("/orders")
    public List<OrderResponse> getOrders() {

        List<OrderResponse> response = new ArrayList<>();

        for (Order order : orderService.findAll()) {

            response.add(new OrderResponse(
                    order.getId(),
                    order.getCustomerName(),
                    order.getMenuItemId(),
                    order.getMenuItemName(),
                    order.getStatus())

            );

        }

        return response;
    }

}
