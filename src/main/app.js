let menuItems =
    [];

let orders = [];

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

async function loadMenuItems(){

    const response = await fetch("http://localhost:8080/api/menu-items")
    menuItems = await response.json();

}

async function loadOrders() {

    const response = await fetch("http://localhost:8080/api/orders")
    orders = await response.json();
    
}

async function loadAllData(){

await loadMenuItems();
await loadOrders();

renderMenuOptions();
renderOrders();

}

loadAllData();