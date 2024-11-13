package Spacecraft.Rocket.Planet;

import Spacecraft.Spacecraft;

// 포함 관계: Spacecraft.Rocket.Planet 클래스에 탐사 장비 추가 및 관리가 포함
public class Planet {
    private String planetName;
    private Spacecraft[] spacecrafts;

    public Planet(String planetName, int capacity) {
        this.planetName = planetName;
        this.spacecrafts = new Spacecraft[capacity];
    }

    public String getPlanetName() {
        return planetName;
    }

    public boolean addSpacecraft(Spacecraft spacecraft, int index) {
        if (index < spacecrafts.length) {
            spacecrafts[index] = spacecraft;
            spacecraft.setCurrentPlanet(this);
            return true;
        } else {
            System.out.println("탐사 장비의 수용 능력을 초과했습니다.");
            return false;
        }
    }

    public void showSpacecrafts() {
        System.out.println(planetName + "의 탐사 장비 목록:");
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft != null) {
                System.out.println("- " + spacecraft.name);
            }
        }
    }

    public Spacecraft getSpacecraftByName(String name) {
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft != null && spacecraft.name.equals(name)) {
                return spacecraft;
            }
        }
        return null;
    }

    public int getCapacity() {
        return spacecrafts.length;
    }
}
