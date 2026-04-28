public class VeganMealFactory extends MealFactory{
    public VeganMealFactory(){}

    @Override
    public MenuItem createBurger() {
        return new VeganBurger();
    }

    @Override
    public MenuItem createSteak() {
        return new VeganSteak();
    }

    @Override
    public MenuItem createPasta() {
        return new VeganPasta();
    }
}
