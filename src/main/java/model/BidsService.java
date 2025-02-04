package model;

import java.util.List;
import database.BidsDao;

public class BidsService {
    private BidsDao bidsDao = new BidsDao();

    public List<Bids> getBidsByProductId(int productId) {
        try {
            return bidsDao.getBidsByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean placeBid(Bids bid) {
        try {
            return bidsDao.insertBid(bid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}