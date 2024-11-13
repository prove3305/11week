package Spacecraft.SpaceExploration;

import Spacecraft.Rocket.Planet.Planet;
import Spacecraft.Rocket.Rocket;
import Spacecraft.Rocket.Rover.Rover;
import Spacecraft.Rocket.Satellite.Satellite;
import Spacecraft.Spacecraft;

import java.util.Scanner;

public class SpaceExploration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 행성 선택 및 탐사 장비 설정
        System.out.println("탐사할 행성의 이름을 입력하세요:");
        String planetName = scanner.nextLine();
        Planet planet = new Planet(planetName, 5); // 탐사 장비 최대 5개로 설정

        while (true) {
            System.out.println("\n==== 우주 탐사 시스템 메뉴 ====");
            System.out.println("1. 탐사 장비 추가");
            System.out.println("2. 장비 기능 실행");
            System.out.println("3. 탐사 장비 목록 보기");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    addSpacecraft(scanner, planet);
                    break;
                case 2:
                    executeSpacecraftFunction(scanner, planet);
                    break;
                case 3:
                    planet.showSpacecrafts();
                    break;
                case 4:
                    System.out.println("우주 탐사 시스템을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }

    private static void addSpacecraft(Scanner scanner, Planet planet) {
        System.out.println("\n===== 탐사 장비 추가 =====");
        System.out.print("장비 이름을 입력하세요 : ");
        String name = scanner.nextLine();

        System.out.print("연료량을 입력하세요 : ");
        double fuelLevel = scanner.nextDouble();

        System.out.print("속도를 입력하세요 : ");
        double speed = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("장비 유형을 선택하세요. - 1: 로켓, 2: 위성, 3: 로버 : ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Spacecraft spacecraft = null;
        switch (type) {
            case 1:
                spacecraft = new Rocket(name, fuelLevel, speed);
                break;
            case 2:
                spacecraft = new Satellite(name, fuelLevel, speed);
                break;
            case 3:
                spacecraft = new Rover(name, fuelLevel, speed);
                break;
            default:
                System.out.println("올바른 장비 유형을 선택하세요.");
                return;
        }

        // 탐사 장비 추가
        for (int i = 0; i < planet.getCapacity(); i++) {
            if (planet.addSpacecraft(spacecraft, i)) {
                System.out.println(name + "이(가) " + planet.getPlanetName() + "에 추가되었습니다.");
                break;
            }
        }
    }

    private static void executeSpacecraftFunction(Scanner scanner, Planet planet) {
        System.out.println("\n===== 장비 기능 실행 =====");
        System.out.print("실행할 장비 이름을 입력하세요 : ");
        String name = scanner.nextLine();

        Spacecraft spacecraft = planet.getSpacecraftByName(name);
        if (spacecraft == null) {
            System.out.println("해당 이름의 장비가 없습니다.");
            return;
        }

        if (spacecraft instanceof Rocket) {
            System.out.println("1: 출발 or 2: 우주 비행 시작");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            if (choice == 1) {
                spacecraft.launch();
            } else if (choice == 2) {
                ((Rocket) spacecraft).launchToSpace();
            }
            choice = scanner.nextInt();
            ((Rocket) spacecraft).launchToSpace(choice);
        } else if (spacecraft instanceof Satellite) {
            System.out.println("1: 출발 or 2: 궤도 진입");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                spacecraft.launch();
            } else if (choice == 2) {
                ((Satellite) spacecraft).orbit();
            }
        } else if (spacecraft instanceof Rover) {
            System.out.println("1: 출발 or 2: 탐사 수행");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                spacecraft.launch();
            } else if (choice == 2) {
                ((Rover) spacecraft).explore();
            }
        }
    }
}

//변경한 점 : 장비 이름, 연료량, 속도, 우주 탐사 유형, 장비 추가를 위한 length 입력 등등을 추가, 사용자가 직접 입력값을 입력 할 수 있도록 하는 시스템 설정