package me.Jack;

import java.util.HashMap;

public class Assignments {

    public void Assignment22(){
        HashMap<Integer, Boolean> Doors = new HashMap<>();

        for (int i = 1; i < 101; i++) {
            Doors.put(i, false);
        }

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (i % j == 0) {
                    if(Doors.get(i)){
                        Doors.put(i, false);
                    } else {
                        Doors.put(i, true);
                    }
                }
            }
        }

        for(int i=1; i< 101; i++){
            if(Doors.get(i)){
                System.out.println("Door " + i + " is open.");
            }
        }
    }

}
