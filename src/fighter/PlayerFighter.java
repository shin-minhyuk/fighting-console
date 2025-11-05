package fighter;

import java.util.Scanner;

public class PlayerFighter extends Fighter {

    // FR-030, ACT-01
    private final Scanner scanner;

    public PlayerFighter(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    public String chooseAction() {
        while (true) {
            System.out.print("액션을 선택하세요 (1 : 주먹 \n 2 : 발차기 \n 3 : 어퍼컷 \n 4 : 로우킥 \n 5 : 피하기 ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                scanner.nextLine();

                switch (choice) {
                    case 1: return "주먹";
                    case 2: return "발차기";
                    case 3: return "어퍼컷";
                    case 4: return "로우킷";
                    case 5: return "피하기";
                    default:
                        System.out.println("1 부터 5 사이의 숫자를 입력해주세요!");
                        break;
                }
            }else {
                System.out.println("잘못된 입력입니다! 1 부터 5 사이의 숫자를 입력해주세요!");
                scanner.nextLine();
            }
        }
    }
}
