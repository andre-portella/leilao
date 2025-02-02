package model;

import java.util.List;
import database.AuctionDao;

public class AuctionService {
    private AuctionDao auctionDao = new AuctionDao();

    public List<Auction> getBidsByProductId(int productId) {
        try {
            return auctionDao.getBidsByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean placeBid(Auction bid) {
        try {
            return auctionDao.insertBid(bid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}