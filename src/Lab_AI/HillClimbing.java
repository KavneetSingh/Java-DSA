package Lab_AI;

import java.util.*;

public class HillClimbing {

    //This code is an example of Hill Climb algorithm, which is used to get the local maxima or minima.
    // It works on the principle of finding the most effective solution possible in the given conditions
    // and  not the best one overall.
    //Here we are using a function (objectiveFunction) which is y= -x*x; this code here tries to get
    // the least negative or the maximum solution possible for the given initial value of X and on the basis of
    // step size (we can move at max that much of distance at once).
    // This step size ensures that we check all the closer neighbours and their values.
    //When we find a higher value than the previous highest, we change the maxima for the equation.
    // We can move at max maxSteps count of steps and not more. This adds up a limitation to the algorithm.
    //This limitation is both important and not.
    // maybe coz we have some resources to manage and we can't go out of our limits.

    // Example: Minimize the negative of a quadratic function
    public static double objectiveFunction(double x) {
        return -(x * x);   //y=-x*x;
    }

    public static double hillClimbing(double initialX, double stepSize, int maxSteps) {
        double currX = initialX;
        double currObjectiveValue = objectiveFunction(currX);
        System.out.println("initial value for x: " + currObjectiveValue);

        for (int i = 0; i < maxSteps; i++) {
            double newX = currX + (stepSize * (new Random().nextDouble() - 0.5)); // Small random step
            //Step could be positive or negative
            double newObjectiveValue = objectiveFunction(newX);

            if (newObjectiveValue > currObjectiveValue) {
                currX = newX;
                currObjectiveValue = newObjectiveValue;
            }
        }

        return currX;
    }


    public static void main(String[] args){
        double initialX = 4.0;  // Initial guess or start point
        double stepSize = 0.1; // Step size for random movement
        int maxSteps = 100; // Maximum number of steps we can travel

//        System.out.println("Random value: "+ new Random().nextDouble());
        double result = hillClimbing(initialX, stepSize, maxSteps);

        System.out.println("Optimal x: " + result);
        System.out.println("Optimal objective value: " + objectiveFunction(result));
    }
}
