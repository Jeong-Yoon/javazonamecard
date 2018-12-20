import dto.BusinessCard;
import dto.BusinessCardData;

import java.util.Scanner;

public class BusinessCardUI {
    Scanner scanner = new Scanner(System.in);
    public String fileName(){
        System.out.println("파일 이름을 입력하세요.");
        String name = scanner.nextLine();
        return name;
    }

    public int start(){
        System.out.println("---------------------------------");
        System.out.println("1.입력 | 2.조회 | 3.수정 | 4.삭제");
        System.out.println("---------------------------------");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public BusinessCard input(){
        System.out.println("이름을 입력하세요.");
        String name = scanner.nextLine();
        System.out.println("전화번호를 입력하세요.");
        String phone = scanner.nextLine();
        System.out.println("회사 이름을 입력하세요.");
        String corporation = scanner.nextLine();
        BusinessCard bc = new BusinessCard(name, phone, corporation);
        return bc;
    }

    public int searchMenu(){
        System.out.println("1. 전체보기 | 2. 검색해서 보기");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public int keywordSearch(){
        System.out.println("무엇으로 검색하시겠습니까?");
        System.out.println("1. 이름 | 2. 전화번호 | 3. 회사이름");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public String keywordValue(){
        System.out.println("검색하려는 값을 입력해주세요.");
        String keyword = scanner.nextLine();
        return keyword;
    }

    public int updateId(){
        System.out.println("수정하려는 명함의 id를 입력해주세요.");
        int sId = scanner.nextInt();
        scanner.nextLine();
        return sId;
    }

    public BusinessCard updateValue(){
        System.out.println("수정할 이름을 입력해주세요.");
        String name = scanner.nextLine();
        System.out.println("수정할 전화번호를 입력해주세요.");
        String phone = scanner.nextLine();
        System.out.println("수정할 회사이름을 입력해주세요.");
        String corporation = scanner.nextLine();
        BusinessCard businessCard = new BusinessCard(name, phone, corporation);
        return businessCard;
    }

    public int delete(){
        System.out.println("삭제하려는 명함의 id를 입력해주세요");
        int sId = scanner.nextInt();
        scanner.nextLine();
        return sId;
    }

    public String continued(){
        System.out.println("계속 하시겠습니까? ( Y | N )");
        String answer = scanner.nextLine();
        return answer;
    }
}
