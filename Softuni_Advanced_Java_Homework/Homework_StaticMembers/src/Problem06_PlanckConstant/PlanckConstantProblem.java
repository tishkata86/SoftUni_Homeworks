package Problem06_PlanckConstant;

public class PlanckConstantProblem {
    public static void main(String[] args) {
        System.out.println(Calculator.ReducedPlanck());
    }
}

class Calculator{
    private static double planckConstant = 6.62606896e-34;;
    private static double pi = 3.14159;

    static double ReducedPlanck(){
        return (planckConstant / (2 * pi));
    }
}