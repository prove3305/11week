package Spacecraft.Rocket;

import Spacecraft.Spacecraft;

public class Rocket extends Spacecraft {
    public Rocket(String name, double fuelLevel, double speed) {
        super(name, fuelLevel, speed);
    }

    // launch 메소드 오버라이딩 - 로켓이 추진하는 이미지에 맞춰서 수정함
    @Override
    public void launch() {
        if (fuelLevel >= 70) {
            System.out.println(name + " 로켓이 " + currentPlanet.getPlanetName() + "에서 강력한 출발을 합니다!");
            fuelLevel -= 50;
        } else {
            System.out.println(name + " 로켓의 연료가 부족합니다.");
        }
    }

    public void launchToSpace() {
        if (fuelLevel >= 50) {
            System.out.println(name + "가 " + currentPlanet.getPlanetName() + "에서 우주로 출발합니다!");
            fuelLevel -= 50;
        } else {
            System.out.println(name + "의 연료가 우주 비행에 부족합니다.");
        }
    }

    //launch 오버로딩
    public void launchToSpace(int fuelLevel) {
        switch (fuelLevel) {
            case 70:
                launchToSpace();
                break;
            case 50:
                System.out.println("연료가 부족합니다.");
                break;
            default:
                System.out.println("출발할수없습니다.");
                break;
        }
    }
}

//변경한 점 : launch, land, explore 3개의 메소드에 오버라이드 추가