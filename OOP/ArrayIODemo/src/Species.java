import java.io.Serializable;
import java.util.Scanner;

public class Species implements Serializable {
    private String name;
    private int population;
    private double growthRate;

    public Species(String name, int population, double growthRate) {
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }

    @Override
    public String toString() {
        return "Name = " + name + "\n" +
                "Population = " + population + "\n" +
                "Growth rate = " + growthRate + "%";
    }

    public int predictPopulation(int years) {
        int result = 0;
        double populationAmount = population;
        int count = years;
        while ((count > 0) && (populationAmount > 0)) {
            populationAmount = (populationAmount + (growthRate / 100) * populationAmount);
            count--;
        }
        if (populationAmount > 0) {
            result = (int) populationAmount;
        }
        return result;
    }

    public void setSpecies(String newName, int newPopulation, double newGrowthRate) {
        name = newName;
        if (newPopulation >= 0) {
            population = newPopulation;
        } else {
            System.out.println("ERROR: using a negative population.");
            System.exit(0);
        }
        growthRate = newGrowthRate;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public boolean equals(Species otherObject) {
        return (this.name.equalsIgnoreCase(otherObject.name)) &&
                (this.population == otherObject.population) &&
                (this.growthRate == otherObject.growthRate);
    }
}
