package Spacecraft;

import Spacecraft.Rocket.Planet.Planet;

public class Spacecraft {
    public String name;
    protected double fuelLevel;
    protected double speed;
    protected Planet currentPlanet;

    public Spacecraft(String name, double fuelLevel, double speed) {
        this.name = name;
        this.fuelLevel = fuelLevel;
        this.speed = speed;
    }

    public void setCurrentPlanet(Planet planet) {
        this.currentPlanet = planet;
        System.out.println(name + "가 " + planet.getPlanetName() + "에 배치되었습니다.");
    }

    // 출발 메소드 (오버라이딩 가능)
    public void launch() {
        if (fuelLevel > 0) {
            System.out.println(name + "가 " + currentPlanet.getPlanetName() + "에서 출발했습니다.");
            fuelLevel -= 10;
        } else {
            System.out.println(name + "의 연료가 부족합니다.");
        }
    }

    // 착륙 메소드 (오버라이딩 가능)
    public void land() {
        System.out.println(name + "가 " + currentPlanet.getPlanetName() + "에 착륙했습니다.");
    }

    // 연료 보충 메소드 (오버로딩)
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(name + "가 연료를 " + amount + "만큼 보충했습니다.");
    }

    public void refuel(double amount, String fuelType) {
        fuelLevel += amount;
        System.out.println(name + "가 " + fuelType + " 연료를 " + amount + "만큼 보충했습니다.");
    }
}