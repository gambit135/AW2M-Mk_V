package aw2m.local.ui;

import aw2m.common.core.Unit;

/**
 *
 * @author Alejandro Téllez G. <java.util.fck@hotmail.com>
 * @date 25/07/2013 - 04:39:32 PM
 */
public class DeployMenu {

    DeployMenu() {
    }

    public byte printAW2BaseDeployMenu() {
        System.out.println("Printing base deploy menu");
        System.out.println("Choose an option");
        System.out.println("1. Infantry");
        System.out.println("2. Mech");
        System.out.println("3. Recon");
        System.out.println("4. Tank");
        System.out.println("5. Md. Tank");
        System.out.println("6. Neotank");
        System.out.println("7. APC");
        System.out.println("8. Artillery");
        System.out.println("9. Rockets");
        System.out.println("10. A-Air");
        System.out.println("11. Missiles");

        //Read input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int option = scanner.nextByte();

        //WHAT TO DO WITH SELECTED OPTION MUST BE PERFORMED IN OTHER FUNCTION,
        //as AI will also be able to choose without having to use a user interface.
        switch (option) {
            case 1:
                return Unit.INFANTRY;
            case 2:
                return Unit.MECH;
            case 3:
                return Unit.RECON;
            case 4:
                return Unit.TANK;
            case 5:
                return Unit.MD_TANK;
            case 6:
                return Unit.NEOTANK;
            case 7:
                return Unit.APC;
            case 8:
                return Unit.ARTILLERY;
            case 9:
                return Unit.ROCKETS;
            case 10:
                return Unit.ANTI_AIR;
            case 11:
                return Unit.MISSILES;
        }
        return -1;
    }
}
