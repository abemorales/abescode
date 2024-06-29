public class HealthyEating {

    public static Food[] mealPrep(int numFoods) {
        Food[] foodArray = new Food[numFoods];

        for (int i = 0; i < numFoods; i++) {
            int randomFood = (int) (Math.random() * Food.values().length);
            //Food randomFood = Food.values()[random.nextInt(Food.values().length)];
            foodArray[i] = Food.values()[randomFood];
        }

        return foodArray;
    }
    public static Food[] followRecipe(String recipe) {
        String[] foods = recipe.split(", ");
        Food[] foodArray = new Food[foods.length];

        for (int i = 0; i < foods.length; i++) {
            foodArray[i] = Food.valueOf(foods[i].toUpperCase());
        }

        return foodArray;
    }

    public static void mealAnalyzer(Food[] foodArray) {
        printHeader();
        /*  if (printHeader) {
            System.out.println("The following types of food are in your meal:");
        }
        */
        int[] counts = new int[Food.values().length];
        for (Food item : foodArray) {
            counts[item.ordinal()]++;
        }
        for (Food item : Food.values()) {
            System.out.println(item + " " + counts[item.ordinal()]);
        }
    }

    private static void printHeader() {
        System.out.println("The following types of food are in your meal:");
 
    }
    public static void healthyChoice(Food[] meal1, Food[] meal2) {
        int score1 = calculateScore(meal1);
        int score2 = calculateScore(meal2);

        if (score1 > score2) {
            System.out.println("The first meal is the healthier choice with a score of " + score1 + ".");
        } else if (score2 > score1) {
            System.out.println("The second meal is the healthier choice with a score of " + score2 + ".");
        } else {
            System.out.println("The two meals are equally healthy with scores of " + score1 + ".");
        }
    }

    private static int calculateScore(Food[] meal) {
        int score = 0;
        for (Food food : meal) {
            score += food.ordinal();
        }
        return score;
    }

    public static void main(String[] args) {
        int numFoods = 4;
        Food[] meal1 = mealPrep(numFoods);
        Food[] meal2 = mealPrep(numFoods);

        Food[] recipe1 = followRecipe("PROTEIN, GRAIN, JUNK_FOOD, FRUIT, VEGETABLE");
        Food[] recipe2 = followRecipe("DAIRY, DAIRY, FRUIT, VEGETABLE, GRAIN");

        /*System.out.println("Meal 1:");
        for (Food food : meal1) {
            System.out.println(food);
        }

        System.out.println("Meal 2:");
        for (Food food : meal2) {
            System.out.println(food);
        }
        */
        System.out.println("Meal 1:");
        mealAnalyzer(meal1);
        System.out.println();
        System.out.println("Meal 2:");
        mealAnalyzer(meal2);

        healthyChoice(meal1, meal2);
    }
}