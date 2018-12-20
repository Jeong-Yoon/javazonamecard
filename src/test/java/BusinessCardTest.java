import com.fasterxml.jackson.databind.ObjectMapper;
import dto.BusinessCard;
import dto.BusinessCardData;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BusinessCardTest {
    private BusinessCard businessCard1;
    private BusinessCard businessCard2;
    private BusinessCard businessCard3;
    private List<BusinessCard> businessCardList;
    private BusinessCardData businessCardData;
    private BusinessCard businessCard;

    @Before
    public void init() {
        businessCardData = new BusinessCardData();
        businessCard = new BusinessCard();
        businessCardList = new ArrayList<>();
        businessCard1 = new BusinessCard("kim", "010-1234-1234","fast");
        businessCard2 = new BusinessCard("lee", "010-5678-5678", "campus");
        businessCard3 = new BusinessCard("Jang","010-9999-1111","gad");

        businessCardList.add(businessCard1);
        businessCardList.add(businessCard2);
        businessCardList.add(businessCard3);

        businessCardData = new BusinessCardData();
        businessCardData.setMaxNum(3);
        businessCardData.setBusinessCardList(businessCardList);
    }

    @Test
    public void inputBusinessCard() {
        int id = businessCardData.getMaxNum();
        String name = "Jang";
        String phone = "010-5555-7777";
        String copartionName = "paik";
        businessCard = new BusinessCard(name, phone, copartionName);
        businessCard.setId(id);
        businessCardData.getBusinessCardList().add(businessCard);
        businessCardData.setMaxNum(id + 1);

        //System.out.println(businessCardData.getBusinessCardList());
        //System.out.println(businessCardData.getMaxNum());
    }

//    @Test
//    public void searchBusinessCard(){
//        System.out.println(businessCardData.getBusinessCardList());
//    }

    @Test
    public void searchBusinessCard(){
        List<BusinessCard> blist = new ArrayList<>();
        int id = businessCardData.getMaxNum();
        String name = "Jang";
        String phone = "010-5555-7777";
        String copartionName = "paik";
        businessCard = new BusinessCard(name, phone, copartionName);
        businessCard.setId(id);
        businessCardData.getBusinessCardList().add(businessCard);
        businessCardData.setMaxNum(id + 1);

        int type = 1;
        String keyword = "Jang";
        if (type == 1){
            for (BusinessCard bc : businessCardList){
                if (bc.getName() == keyword){
                    blist.add(bc);
                }
            }
        }else if (type == 2){
            for (BusinessCard bc : businessCardList){
                if (bc.getPhone() == keyword){
                    blist.add(bc);
                }
            }
        }else if(type == 3){
            for (BusinessCard bc : businessCardList){
                if (bc.getCorporationName() == keyword){
                    blist.add(bc);
                }
            }
        }

        //System.out.println(blist);
    }

    @Test
    public void deleteBusinessCard(){
        String name = "Jang";
        String phone = "010-5555-7777";
        String copartionName = "paik";
        businessCard = new BusinessCard(name, phone, copartionName);
        businessCard.setId(businessCardData.getMaxNum());
        businessCardData.getBusinessCardList().add(businessCard);
        List<BusinessCard> list = businessCardData.getBusinessCardList();

        //System.out.println(list);
        int id = 3;
        for (BusinessCard bbc : list){
            if (bbc.getId() == id){
                businessCardData.getBusinessCardList().remove(businessCard);
                break;
            }
        }
        //System.out.println(list);
    }
    @Test
    public void updateBusinessCard(){
        int id = businessCardData.getMaxNum();
        String name = "Jang";
        String phone = "010-5555-7777";
        String copartionName = "paik";
        businessCard = new BusinessCard(name, phone, copartionName);
        businessCard.setId(id);
        businessCardData.getBusinessCardList().add(businessCard);
        businessCardData.setMaxNum(id + 1);

        id = 3;
        name = "Lim";
        for (BusinessCard businessCard : businessCardData.getBusinessCardList()) {
            if (businessCard.getId() == id){
                businessCard.setName(name);
                businessCard.setPhone(phone);
                businessCard.setCorporationName(copartionName);
            }

        }
        //System.out.println(businessCardData.getBusinessCardList());
    }

    @Test
    public void readBusinessCardData(){
        String fileName = "businesscard";
        File file = new File("./" + fileName + ".json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            businessCardData = objectMapper.readValue(file, BusinessCardData.class);
        } catch (Exception ex) {
            System.out.println("읽기오류");
        }
        System.out.println(businessCardData);
    }

}
