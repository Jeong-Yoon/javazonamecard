import com.fasterxml.jackson.databind.ObjectMapper;
import dto.BusinessCard;
import dto.BusinessCardData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardDao implements BusinessCardDaoInterface {
    private BusinessCardData businessCardData;

    public BusinessCardDao() {
        businessCardData = new BusinessCardData();
    }

    public BusinessCardDao(BusinessCardData businessCardData) {
        this.businessCardData = businessCardData;
    }

    @Override
    public void inputBusinessCard(BusinessCard businessCard) {
        int id;
        if (businessCardData.getMaxNum() == 0) {
            id = 1;
        } else {
            id = businessCardData.getMaxNum();
        }
        businessCard.setId(id);
        businessCardData.add(businessCard);
        businessCardData.setMaxNum(id + 1);
    }

    @Override
    public List<BusinessCard> searchBusinessCard() {
        return businessCardData.getBusinessCardList();
    }

    @Override
    public List<BusinessCard> searchBusinessCard(int type, String keyword) {
        List<BusinessCard> blist = new ArrayList<>();

        if (type == 1) {
            for (BusinessCard bc : businessCardData.getBusinessCardList()) {
                if (bc.getName().equals(keyword)) {
                    blist.add(bc);
                }
            }
        } else if (type == 2) {
            for (BusinessCard bc : businessCardData.getBusinessCardList()) {
                if (bc.getPhone().equals(keyword)) {
                    blist.add(bc);
                }
            }
        } else if (type == 3) {
            for (BusinessCard bc : businessCardData.getBusinessCardList()) {
                if (bc.getCorporationName().equals(keyword)) {
                    blist.add(bc);
                }
            }
        }
        return blist;
    }

    public boolean idChk(int id){
        if (id >= businessCardData.getMaxNum()){
            System.out.println("존재하지 않는 id입니다.");
            return false;
        }
        return true;
    }
    @Override
    public boolean updateBusinessCard(int id, BusinessCard bc) {
        for (BusinessCard businessCard : businessCardData.getBusinessCardList()) {
            if (businessCard.getId() == id) {
                businessCard.setName(bc.getName());
                businessCard.setPhone(bc.getPhone());
                businessCard.setCorporationName(bc.getCorporationName());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBusinessCard(int id) {
        return businessCardData.delete(id);
    }

    //여기서 부터 수정하자.
    @Override
    public void saveBusinessCardData(String fileName) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("./" + fileName + ".json");
            objectMapper.writeValue(file, businessCardData);
        } catch (Exception ex) {
            System.out.println("저장오류.");
        }
    }

    @Override
    public void readBusinessCardData(String fileName) throws Exception {
        File file = new File("./" + fileName + ".json");
        if (file.exists() == false) {
            saveBusinessCardData(fileName);
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                businessCardData = objectMapper.readValue(file, BusinessCardData.class);
            } catch (Exception ex) {
                System.out.println("읽기오류");
            }
        }
    }
}
