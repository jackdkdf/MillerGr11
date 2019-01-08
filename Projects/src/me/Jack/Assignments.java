package me.Jack;

public class Assignments {

    public void Assignment24(){
        boolean[] Doors = new boolean[101];

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (i % j == 0) {
                    if(Doors[i]){
                        Doors[i] = false;
                    } else {
                        Doors[i] = true;
                    }
                }
            }
            if(Doors[i]){
                System.out.println("Door " + i + " is open.");
            }
        }

    }

}
