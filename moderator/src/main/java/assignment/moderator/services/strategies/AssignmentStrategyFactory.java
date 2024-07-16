package assignment.moderator.services.strategies;

public class AssignmentStrategyFactory {

    public static AssignmentStrategy getStartegy(AssignmentStrategyEnum startegy) {
        switch (startegy){
            case PERFORMANCE_BASED:
                return new PerformanceBasedAssignment();
            case ROUND_ROBIN:
                return new RoundRobinAssignment();
            case WEIGHTED_ROUND_ROBIN:
                return new WeightedRoundRobinAssignment();
        }
        throw new RuntimeException("Invalid assignment strategy");
    }
}
