public class RegularMealFactory extends MealFactory{
    public RegularMealFactory(){}

    @Override
    public MenuItem createBurger() {
        return new RegularBurger();
    }

    @Override
    public MenuItem createSteak() {
        return new RegularSteak();
    }

    @Override
    public MenuItem createPasta() {
        return new RegularPasta();
    }
}
