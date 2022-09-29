package org.calm.multiThread;

import java.util.concurrent.Semaphore;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/9/27
 * @version 1.0
 * ------------------------
 */
public class TrafficLight {
    private Semaphore greenLight;
    private Boolean roadOn;

    public TrafficLight() {
        greenLight = new Semaphore(1, true);
        roadOn = true;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        try {
            greenLight.acquire();
            if(roadId == 1 && roadOn || roadId == 2 && !roadOn) crossCar.run();
            else if(roadId == 1){
                turnGreen.run();
                roadOn = true;
                crossCar.run();
            } else {
                turnGreen.run();
                roadOn = false;
                crossCar.run();
            }
            greenLight.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}