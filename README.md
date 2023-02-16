# Inventory Management System

This is a Java desktop application designed to help a small manufacturing organization manage its inventory system. It provides a user-friendly interface to add, modify, and delete parts and products, as well as search for existing inventory items.

![main_form](https://github.com/mallen13/java-inventory-management-app/blob/master/main_app.png)

## Getting Started

To get started with the application, you will need to have the following software installed:

JDK and JavaFX SDK or Module (the latest long term support - LTS - version)
Scene Builder (the latest version)
NetBeans 11.1 or later or IntelliJ IDEA (Community Edition)
You can download these tools from the web links section of the assessment.

## Using the Application

To run the application, open the project in NetBeans or IntelliJ IDEA and run the Main.java file. This will launch the main form, which shows a table with all the existing parts and products in the inventory.

To add a new part or product, click on the "Add" button and fill in the required information in the form that pops up. You can also modify or delete an existing part or product by selecting it in the table and clicking on the "Modify" or "Delete" buttons.

![part_form](https://github.com/mallen13/java-inventory-management-app/blob/master/add_part.png)

![product_form](https://github.com/mallen13/java-inventory-management-app/blob/master/add_product.png)

The application also allows you to search for parts and products by ID or name. Simply type the search query in the text field at the top of the main form and press the "Search" button.

## Code Structure

The application follows the Model-View-Controller (MVC) architecture and includes the following packages:

model: contains the classes that represent the data and logic of the application, including the Part and Product classes.
view: contains the JavaFX classes that define the user interface of the application, including the main form and the add/modify forms.
controller: contains the classes that handle the user interactions with the application, including the MainController and the AddPartController and AddProductController.
The code also demonstrates the use of inheritance, abstract and concrete classes, instance and static variables and methods, and other concepts.

## Javadoc Comments

The code includes Javadoc comments for each class member, as well as detailed descriptions of the following:

a logical or runtime error that was corrected in the code and how it was corrected
a future enhancement that would extend the functionality of the application if it were to be updated
Please refer to the Javadoc comments for more information.

## Future Enhancements

Some possible future enhancements to the application could include:

Adding a feature to export the inventory data to a CSV or Excel file.
Implementing a user authentication system to restrict access to the application.
Providing more advanced search options, such as filtering by price range or quantity in stock.
Adding a graphical visualization of the inventory data, such as a pie chart or a bar chart.

