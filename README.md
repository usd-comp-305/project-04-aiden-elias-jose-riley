# Restaurant POS System

## Project Description

The Restaurant POS System is a JavaFX-based point of sale application for managing restaurant orders, staff roles, kitchen tickets, payments, receipts, and inventory.

The system allows staff members to log in as either a server or chef. Servers can create active orders, add menu items, and process payments. Chefs can view kitchen tickets and update order statuses. The project also supports different types of meals, including regular, vegan, and gluten-free options.

This project uses object-oriented programming concepts and includes design patterns such as the Factory Pattern for meal creation and the Strategy Pattern for payment processing.

## Prerequisites

Before running this project, make sure you have the following installed:

- Java JDK 23
- IntelliJ IDEA
- Gradle
- JavaFX
- Git

The project also uses the following dependencies:

- JUnit 5
- Mockito
- Checkstyle
- SpotBugs
- JavaFX Controls and FXML

## Installation

1. Clone the repository: https://github.com/usd-comp-305/Project4-PointOfSale.git

2. Open the project in IntelliJ IDEA.

3. Link the Gradle project if IntelliJ does not do it automatically.

4. Make sure the correct JDK is selected in IntelliJ for both Gradle
   (Project Structure) and the default JDK for the project.

5. Build the project

## javafx Troubleshooting 

If not working (likely possible), verify that JDK 23 is being used by 
Gradle and IntelliJ. Also, the JavaFX library may need to be replaced 
by an older version which can be found at the following link:
https://www.oracle.com/java/technologies/downloads/javafx/#javafx21-mac
Only version 21 of JavaFX will work properly, as all newer versions aren't backwards compatible with JDK 23.

Testing of if the program is working properly is by building the project through the gradle elephant on the 
right hand side, then running the HelloApplication file, which should be designated as the main class, with a 
special run configuration. To edit run configurations:

    1. Click the dropdown next to the run buttons and hit "Edit Configurations"

    2. Under "Build and Run" select the dropdown menu to the right of the title that says "Modify options"

    3. In the VM options line put the following:

    4. "--module-path "/YOUR_DIRECTORY/javafx-sdk-21.0.11/lib" --add-modules javafx.controls,javafx.fxml,
       javafx.media,javafx.web,javafx.swing"

    5. Make sure that it was not copied in with the quotation marks on the very outside and change the 
       directory to wherever you downloaded JavaFX SDK 21 (also make sure it is specifically to the "lib" folder 
       of the unzipped download)

