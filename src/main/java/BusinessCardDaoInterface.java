import dto.BusinessCard;

import java.util.List;

public interface BusinessCardDaoInterface {
    abstract void inputBusinessCard(BusinessCard businessCard);

    abstract List<BusinessCard> searchBusinessCard();

    abstract List<BusinessCard> searchBusinessCard(int type, String keyword);

    abstract boolean updateBusinessCard(int id, BusinessCard bc);

    abstract boolean deleteBusinessCard(int id);

    abstract void saveBusinessCardData(String fileName) throws Exception;

    abstract void readBusinessCardData(String fileName) throws Exception;
}
