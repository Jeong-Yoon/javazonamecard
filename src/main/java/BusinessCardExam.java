import dto.BusinessCard;

public class BusinessCardExam {
    public static void main(String args[]) {
        BusinessCardUI businessCardUI = new BusinessCardUI();
        BusinessCardDao businessCardDao = new BusinessCardDao();
        String fileName = businessCardUI.fileName();
        try {
            businessCardDao.readBusinessCardData(fileName);
        } catch (Exception e) {
            System.out.println("파일 명이 잘못되었습니다.");
        }
        while (true) {
            int menu = businessCardUI.start();
            if (menu == 1) {
                businessCardDao.inputBusinessCard(businessCardUI.input());
            } else if (menu == 2) {
                int smenu = businessCardUI.searchMenu();
                if (smenu == 1) {
                    System.out.println(businessCardDao.searchBusinessCard());
                } else if (smenu == 2) {
                    int type = businessCardUI.keywordSearch();
                    String keyword = businessCardUI.keywordValue();
                    System.out.println(businessCardDao.searchBusinessCard(type, keyword));
                }
            } else if (menu == 3) {
                int id = 0;
                do {
                    id = businessCardUI.updateId();
                } while (!businessCardDao.idChk(id));
                BusinessCard businessCard = businessCardUI.updateValue();
                businessCardDao.updateBusinessCard(id, businessCard);

            } else if (menu == 4) {
                int id = 0;
                do {
                    id = businessCardUI.delete();
                } while (!businessCardDao.idChk(id));
                businessCardDao.deleteBusinessCard(id);
            }
            if (businessCardUI.continued().equalsIgnoreCase("n")) {
                try {
                    businessCardDao.saveBusinessCardData(fileName);
                } catch (Exception e) {
                    System.out.println("파일 명이 잘못되었습니다.");
                }
                break;
            }
        }
    }
}
