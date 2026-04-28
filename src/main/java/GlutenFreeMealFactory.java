public class GlutenFreeMealFactory extends MealFactory{
    public GlutenFreeMealFactory(){}

    @Override
    public MenuItem createBurger() {
        return new GlutenFreeBurger();
    }

    @Override
    public MenuItem createSteak() {
        return new GlutenFreeSteak();
    }

    @Override
    public MenuItem createPasta() {
        return new GlutenFreePasta();
    }
}
