package com.company;

public class Robot {
    //Map
    //0 - nothing
    //1 - robot
    //2 - mouse
    //3 - furniture
    int[][] roomMap;
    int robotX;
    int robotY;
    int battery;

    public Robot(){
        roomMap = new int[5][5];
        battery = 100;

        //Place robot
        roomMap[0][0] = 1;
        robotX = 0;
        robotY = 0;
    }

    public void command(String comText){
        if (comText.equals("Go Sideway")) {
            goSideway();
        } else if (comText.equals("Forward")) {
            goForward();
        } else if (comText.equals("Jump")){
            jump();
        } else {
            System.out.println("ERROR: Wrong command!");
        }
    }

    void goSideway(){
        //if robot not at right edge
        if (robotX < 4){
            //check for furniture, no move
            if (roomMap[robotX + 1][robotY] == 3){
                System.out.println("Cant move furniture in the way.");
                return;
            }
            //check for mouse, no move, hit
            if (roomMap[robotX + 1][robotY] == 2){
                //if you have battery hit
                if (battery > 0) {
                    System.out.println("Mouse terminated!");
                    battery -= 20;
                    return;
                } else {
                    System.out.println("Mouse terminated!");
                    roomMap[robotX + 1][robotY] = 0;
                    return;
                }
            }
            //move
            roomMap[robotX][robotY] = 0;
            robotX++;
            roomMap[robotX][robotY] = 1;
        } else {
            //check for furniture, no move
            if (roomMap[robotX - 1][robotY] == 3){
                System.out.println("Cant move furniture in the way.");
                return;
            }
            //check for mouse
            if (roomMap[robotX - 1][robotY] == 2){
                //if you have battery hit
                if (battery > 0) {
                    System.out.println("Mouse terminated!");
                    battery -= 20;
                    return;
                } else {
                    System.out.println("Mouse terminated!");
                    roomMap[robotX - 1][robotY] = 0;
                    return;
                }
            }
            roomMap[robotX][robotY] = 0;
            robotX--;
            roomMap[robotX][robotY] = 1;
        }
    }
    void goForward(){

    }

    void jump(){

    }

    public void reChage(){
        battery = 100;
    }
}
