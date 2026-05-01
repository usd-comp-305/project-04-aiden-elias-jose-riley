package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public abstract class MenuItem {

    String description;

    List<Ingredient> ingredients;

    double cost;


    String getDescription(){
        return "";
    }

    double getCost(){
        return 0.0;
    }
}
