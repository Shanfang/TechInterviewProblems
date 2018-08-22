/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, new HashSet<String>());
    }

    private void dfs(Robot robot, int i, int j, Set<String> visited) {
        String position = String.valueOf(i) + " " + String.valueOf(j);
        if (visited.contains(position)) {
            return;
        }

        visited.add(position);
        robot.clean();

        // try 4 different directions
        if (moveUp(robot)) {
            dfs(robot, i - 1, j, visited);
            moveDown(robot);
        }
        if (moveLeft(robot)) {
            dfs(robot, i, j - 1, visited);
            moveRight(robot);
        }
        if (moveDown(robot)) {
            dfs(robot, i + 1, j, visited);
            moveUp(robot);
        }
        if (moveRight(robot)) {
            dfs(robot, i, j + 1, visited);
            moveLeft(robot);
        }
    }

    private boolean moveUp (Robot robot) {
        return robot.move();
    }

    private boolean moveLeft(Robot robot) {
        robot.turnLeft();
        boolean moveable = robot.move();
        robot.turnRight(); // now robot is facing up again
        return moveable;
    }
    private boolean moveDown(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        boolean moveable = robot.move();
        robot.turnRight();
        robot.turnRight();
        return moveable;
    }

    private boolean moveRight(Robot robot) {
        robot.turnRight();
        boolean moveable = robot.move();
        robot.turnLeft();
        return moveable;
    }
}
