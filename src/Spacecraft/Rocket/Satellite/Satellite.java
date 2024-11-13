package Spacecraft.Rocket.Satellite;

import Spacecraft.Spacecraft;

// 자식 클래스: Spacecraft.Rocket.Satellite : 위성
public class Satellite extends Spacecraft {
    public Satellite(String name, double fuelLevel, double speed) {
        super(name, fuelLevel, speed);
    }

    // 착륙 메소드 오버라이딩 - 위성 착륙 불가 상황
    @Override
    public void land() {
        System.out.println(name + "는 착륙할 수 없습니다. 궤도에서 계속 운행 중입니다.");
    }

    public void orbit() {
        System.out.println(name + "가 " + currentPlanet.getPlanetName() + " 궤도에 진입했습니다.");
    }
}
