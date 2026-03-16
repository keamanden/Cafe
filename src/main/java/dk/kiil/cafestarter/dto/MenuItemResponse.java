package dk.kiil.cafestarter.dto;

import java.math.BigDecimal;

public record MenuItemResponse(
        Long id,
        String name,
        String category,
        BigDecimal price
) {

        public MenuItemResponse(Long id, String name, String category, BigDecimal price)
        {
                this.id = id;
                this.name = name;
                this.category = category;
                this.price = price;
        }
}

