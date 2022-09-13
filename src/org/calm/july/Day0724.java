package org.calm.july;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/24
 * @version: v1.0
 * ---------------------------
 */
public class Day0724 {
    Map<String, F> map = new HashMap<>();
    public Day0724(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            F f = new F();
            f.food = foods[i];
            f.cuisine = cuisines[i];
            f.rating = ratings[i];
            map.put(foods[i], f);
        }
    }

    public void changeRating(String food, int newRating) {
        F f = map.get(food);
        f.rating = newRating;
        map.put(food, f);
    }

    public String highestRated(String cuisine) {
        List<F> list = new ArrayList<>();
        for (Map.Entry<String, F> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Map<String, List<F>> collect = list.stream().collect(Collectors.groupingBy(F::getCuisine));
        List<F> fs = collect.get(cuisine);
        F f = fs.stream().sorted(Comparator.comparing(F::getFood, (x, y) -> y.compareTo(x))
                .thenComparing(Comparator.comparing(F::getRating, (x, y) -> y.compareTo(x)))).findFirst().get();
        return f.food;

    }

    class F {
        String food;
        String cuisine;
        int rating;

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
}
