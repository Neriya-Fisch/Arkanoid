//ID 315558692
package assthree;

import java.util.ArrayList;
import java.util.List;

/**
 * define the GameEnvironment object- a list of collidables.
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<Collidable>();

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable we add.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * remove the given collidable to the environment.
     *
     * @param c the collidable we remove.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }


    /**
     * Assume an object moving from line.start() to line.end(). and check if this object will collide with anyone.
     * in the collision list.
     *
     * @param trajectory the movement axes of the object.
     * @return if this object will not collide with any of the collidables in this collection, return null.
     * else, return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle rectangle;
        Point closePoint;
        Point closetsPoint = null;
        int index = -1;
        double distance = trajectory.length();
        for (Collidable c : collidables) {
            rectangle = c.getCollisionRectangle();
            closePoint = trajectory.closestIntersectionToStartOfLine(rectangle);
            if (closePoint == null) {
                continue;
            }
            if ((closePoint.distance(trajectory.start()) <= distance) && trajectory.pointOnLine(closePoint)) {
                distance = closePoint.distance(trajectory.start());
                closetsPoint = closePoint;
                index = this.collidables.indexOf(c);
            }
        }
        //if not collide with anybody.
        if (index == -1) {
            return null;
        } else {
            CollisionInfo collisionInfo = new CollisionInfo(closetsPoint, collidables.get(index));
            return collisionInfo;
        }
    }
}