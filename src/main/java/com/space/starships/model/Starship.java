package com.space.starships.model;

public record Starship(
        String name, String model, String starship_class, String manufacturer,
        String cost_in_credits, String length,
        String crew, String passengers,
        String max_atmosphering_speed, String hyperdrive_rating,
        String MGLT, String cargo_capacity, String consumables, String[] films, String[] pilots, String url,
        String created, String edited) implements Comparable<Starship> {

    /*
     * Implement comparison so that starhip will sort in descending order based on
     * cost
     */

    @Override
    public int compareTo(Starship starship) {

        try {
            Long.valueOf(cost_in_credits);

        } catch (NumberFormatException e) {
            System.out.println("Can't find cost for ship: " + name);
            return 1;
        }

        try {
            Long.valueOf(starship.cost_in_credits);

        } catch (NumberFormatException e) {
            System.out.println("Can't find cost for ship: " + starship.name);
            return 1;
        }

        if (Long.parseLong(starship.cost_in_credits) > Long.parseLong(cost_in_credits)) {
            return 1;
        } else if ((Long.parseLong(starship.cost_in_credits) < Long.parseLong(cost_in_credits))) {
            return -1;
        } else if (cost_in_credits.equals(starship.cost_in_credits)) {
            return name.compareTo(starship.name);
        } else {
            return 0;
        }
    }

}
