package dk.kiil.cafestarter.dto;


public record OrderResponse( 
    Long id,
    String customerName,
    Long menuItemId,
    String menuItemName,
    String status
){}



