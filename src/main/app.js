const menuItems = [
    { id: 1, name: "Latte", category: "Drikkevarer", price: 45.0 },
    { id: 2, name: "Croissant", category: "Bagværk", price: 28.0 },
    { id: 3, name: "Espresso", category: "Drikkevarer", price: 32.0 },
    { id: 4, name: "Te", category: "Drikkevarer", price: 30.0 }
];

const orders = [
    {
        id: 1,
        customerName: "Maja",
        menuItemId: 1,
        menuItemName: "Latte",
        status: "NEW"
    },
    {
        id: 2,
        customerName: "Ali",
        menuItemId: 2,
        menuItemName: "Croissant",
        status: "READY"
    }
];

const statuses = ["NEW", "PREPARING", "READY"];
// We use these later on

function renderMenuOptions() {
    const menuItemSelect = document.querySelector("#menuItemSelect");
    menuItemSelect.innerHTML = "";

}

function renderOrders() {
    const ordersContainer = document.getElementById("ordersContainer");
    ordersContainer.innerHTML = "";

    for (const order of orders) {
        const matchingMenuItem = menuItems.find(menuItem => menuItem.id === order.menuItemId);

        const orderCard = document.createElement("div");
        orderCard.classList.add("order-card");

        const kunde = document.createElement("h3");
        kunde.textContent = order.customerName;

        const bestilling = document.createElement("p");
        bestilling.textContent = `Bestilling: ${order.menuItemName}`;

        const pris = document.createElement("p");
        pris.textContent = `Pris: ${matchingMenuItem?.price ?? "Ukendt"}`;

        const status = document.createElement("p");
        status.textContent = `Status: ${order.status}`;

        orderCard.appendChild(kunde);
        orderCard.appendChild(bestilling);
        orderCard.appendChild(pris);
        orderCard.appendChild(status);

        ordersContainer.appendChild(orderCard);
    }
}

renderMenuOptions();
renderOrders();