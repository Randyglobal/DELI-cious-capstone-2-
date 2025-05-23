# DELI-cious Point of Sale (POS) Application

## ✨ Key Features & Requirements

The initial phase of the DELI-cious POS application focuses on the core sandwich customization and order management:

* **Customizable Sandwiches:**
    * Customers can order sandwiches in three sizes: 4", 8", and 12".
    * Choice of bread type: White, Wheat, Rye, or Wrap.
    * Selection of various toppings categorized as:
        * **Regular Toppings:** Standard toppings with no additional cost for "extra" requests.
        * **Premium Toppings:** Includes meats and cheeses, which incur an additional cost if "extra" is requested.
    * Option to have each sandwich toasted.
* **Order Management:**
    * Customers can place an order containing one or more sandwiches.
    * The application guides the customer through customizing each sandwich individually.
    * Ability to add `Drinks` and `Chips` to the order.
* **Order Summary & Cost:**
    * Upon completion, the application displays detailed order information, including:
        * A list of all ordered sandwiches with their chosen sizes, bread types, and all toppings.
        * The total cost of the entire order.

## UML Class Diagram (Initial Design)

Our foundational design is captured in a UML Class Diagram, which serves as the blueprint for the application's structure. This diagram highlights the core entities, their attributes, methods, and relationships, adhering to OOP principles like encapsulation, inheritance, and composition.

The diagram is a living document and may evolve as the application progresses.

**Key Classes Identified:**

* `Order`: Manages the overall customer order, including multiple sandwiches, drinks, and chips.
* `Sandwich`: Represents a single, customizable sandwich with its size, bread, toasted status, and toppings.
* `Topping` (Abstract): Base class for all toppings, ensuring polymorphic behavior.
    * `RegularTopping`: Non-premium toppings.
    * `PremiumTopping`: Premium toppings with potential extra cost.
        * `Meat`: Specific type of premium topping.
        * `Cheese`: Specific type of premium topping.
* `Drink`: Represents a beverage item on the order.
* `Chip`: Represents a bag of chips on the order.
* `SandwichSize` (Enum): Defines available sandwich sizes.
* `BreadType` (Enum): Defines available bread options.

### How to View the Class Diagram

The class diagram is generated using Mermaid syntax. To view it:

1.  **Open the Deli_cious.jpg** containing the README.md.

## 🚀 Future Enhancements

* **Online Ordering Integration:** Extend the POS to be accessible online for customer self-ordering.
* **User Authentication:** Implement user roles for staff (e.g., cashier, manager).
* **Inventory Management:** Track available ingredients and products.
* **Reporting:** Generate sales reports and other business intelligence.
* **Payment Processing:** Integrate with payment gateways.

## 🤝 Contributing

This project is currently in its initial design phase. Contributions and feedback are welcome! Please feel free to open issues or suggest improvements to the design.