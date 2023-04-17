import java.util.Scanner;

/**
 * Homework 2-4
 */

public class Homework_2_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the capacity of fuel tank:");
        double C = scan.nextDouble();
        System.out.println("Enter the amount of fuel in the tank:");
        double f = scan.nextDouble();
        System.out.println("Enter the Maximum speed and current speed:");
        double M = scan.nextDouble();
        double s = scan.nextDouble();
        System.out.println("Enter the efficiency of the boat's motor:");
        double e = scan.nextDouble();

        System.out.println("Enter the current time:");
        int time = scan.nextInt();

        Tank tank = new Tank(C, f, M, s, e);
        System.out.println("Current amount of fuel (when s is max speed): " + tank.getFuelByMaxSpeed(time));
        System.out.println("Current amount of fuel (when s is current speed): " + tank.getFuelByCurrentSpeed(time));
        System.out.println("Travel distance: " + tank.getMovingDistance(time));
        System.out.println("Travel distance (when knowing current speed and fuel amount): " + tank.getCanMovingDistance());
    }
}

class Tank {
    public double capacityOfFuel;
    public double fuel;
    public double maxSpeed;
    public double currentSpeed;
    public double motorEfficiency;

    public Tank(double capacityOfFuel, double fuel, double maxSpeed, double currentSpeed, double motorEfficiency) {
        this.capacityOfFuel = capacityOfFuel;
        this.fuel = fuel;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.motorEfficiency = motorEfficiency;
    }

    public double getFuelByCurrentSpeed(int time) {
        return (this.currentSpeed * time) / (this.motorEfficiency * this.currentSpeed);
    }

    public double getFuelByMaxSpeed(int time) {
        return (this.maxSpeed * time) / (this.motorEfficiency * this.maxSpeed);
    }

    public double getMovingDistance(int time) {
        return time * this.currentSpeed;
    }

    public double getCanMovingDistance() {
        return this.fuel * (this.currentSpeed * this.motorEfficiency);
    }
}