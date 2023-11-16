package O3_behavioral_design_patterns.strategy;

// Strategy interface
interface MovementStrategy {
    void move();
}

// Concrete Strategies
class WalkStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Walking...");
    }
}

class RunStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Running...");
    }
}

class SprintStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Sprinting!!");
    }
}

// Context
class Player {
    private MovementStrategy movementStrategy;

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void moveCharacter() {
        movementStrategy.move();
    }
}


//////////////////////////////////////////////////
class StrategyTest {
     public static void main(String[] args) {
        Player player = new Player();

        // Initial movement strategy: walking
        player.setMovementStrategy(new WalkStrategy());
        player.moveCharacter(); // Output: Walking...

        // Change movement strategy: running
        player.setMovementStrategy(new RunStrategy());
        player.moveCharacter(); // Output: Running...

        // Change movement strategy: sprinting
        player.setMovementStrategy(new SprintStrategy());
        player.moveCharacter(); // Output: Sprinting!!
    }
}
