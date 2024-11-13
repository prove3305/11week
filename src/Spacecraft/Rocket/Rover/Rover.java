package Spacecraft.Rocket.Rover;

import Spacecraft.Spacecraft;

// 자식 클래스: Spacecraft.Rocket.Rover : 방랑자, 우주탐사 관점 -> 자유탐사로봇
public class Rover extends Spacecraft {
    public Rover(String name, double fuelLevel, double speed) {
        super(name, fuelLevel, speed);
    }

    // 탐사 메소드 오버로딩 - 탐사 대상 지정 가능
    public void explore() {
        System.out.println(name + "가 " + currentPlanet.getPlanetName() + "를 탐사 중입니다.");
    }

    public void explore(String target) {
        System.out.println(name + "가 " + currentPlanet.getPlanetName() + "에서 " + target + "을(를) 탐사 중입니다.");
    }

    // launch 메소드 오버라이딩 - 자유탐사 로봇의 특성에 맞게 수정
    @Override
    public void launch() {
        if (fuelLevel >= 5) {
            System.out.println(name + " 로버가 " + currentPlanet.getPlanetName() + "에서 탐사 지점으로 이동합니다.");
            fuelLevel -= 5;
        } else {
            System.out.println(name + " 로버의 연료가 부족합니다. 태양광 충전을 시작합니다.");
        }
    }
}
