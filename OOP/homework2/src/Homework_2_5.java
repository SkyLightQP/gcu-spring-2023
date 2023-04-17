import java.util.Scanner;

/**
 * Homework 2-5
 */

public class Homework_2_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the amount of fuel in the tank:");
        double f = scan.nextDouble();
        System.out.println("Enter the current speed:");
        double s = scan.nextDouble();
        System.out.println("Enter the efficiency of the boat's motor:");
        double e = scan.nextDouble();
        System.out.println("Enter the current time:");
        int time = scan.nextInt();

        HiddenTank tank = new HiddenTank();
        tank.setFuel(f);
        tank.setCurrentSpeed(s);
        tank.setMotorEfficiency(e);

        System.out.println("Fuel: " + tank.getFuel() + ", Speed: " + tank.getCurrentSpeed() + ", Efficiency of motor: " + tank.getMotorEfficiency());
        System.out.println("Current amount of fuel (when s is max speed): " + tank.getFuelByMaxSpeed(time));
        System.out.println("Current amount of fuel (when s is current speed): " + tank.getFuelByCurrentSpeed(time));
        System.out.println("Travel distance: " + tank.getMovingDistance(time));
        System.out.println("Travel distance (when knowing current speed and fuel amount): " + tank.getCanMovingDistance());
    }
}

class HiddenTank {
    public static final double TANK_CAPACITY = 60.0;
    public static final double MAX_SPEED = 100;
    private double fuel;
    private double currentSpeed;
    private double motorEfficiency;

    public HiddenTank() {}

    public HiddenTank(double fuel, double currentSpeed, double motorEfficiency) {
        this.fuel = fuel;
        this.currentSpeed = currentSpeed;
        this.motorEfficiency = motorEfficiency;
    }

    public void setFuel(double fuel) {
        if (fuel > TANK_CAPACITY) {
            System.out.println("ERROR: Can NOT set the fuel exceeds the capacity.");
            System.exit(0);
        }
        this.fuel = fuel;
    }

    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > MAX_SPEED) {
            System.out.println("ERROR: Can NOT set the current speed exceeds the max speed.");
            System.exit(0);
        }
        this.currentSpeed = currentSpeed;
    }

    public void setMotorEfficiency(double motorEfficiency) {
        this.motorEfficiency = motorEfficiency;
    }

    public double getFuel() {
        return fuel;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getMotorEfficiency() {
        return motorEfficiency;
    }

    public double getFuelByCurrentSpeed(int time) {
        return (this.currentSpeed * time) / (this.motorEfficiency * this.currentSpeed);
    }

    public double getFuelByMaxSpeed(int time) {
        return (MAX_SPEED * time) / (this.motorEfficiency * MAX_SPEED);
    }

    public double getMovingDistance(int time) {
        return time * this.currentSpeed;
    }

    public double getCanMovingDistance() {
        return this.fuel * (this.currentSpeed * this.motorEfficiency);
    }
}
