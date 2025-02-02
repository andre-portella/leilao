package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Auction;

public class AuctionDao {

    public List<Auction> getBidsByProductId(int productId) throws ClassNotFoundException {
        String SELECT_BIDS_SQL = "SELECT * FROM bids WHERE product_id = ? ORDER BY bid_value DESC";
        List<Auction> bids = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BIDS_SQL);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Auction bid = new Auction(
                    rs.getInt("bid_id"),
                    rs.getInt("product_id"),
                    rs.getInt("user_id"),
                    rs.getBigDecimal("bid_value"),
                    rs.getTimestamp("bid_time")
                );
                bids.add(bid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bids;
    }

    public boolean insertBid(Auction bid) {
        String INSERT_BID_SQL = "INSERT INTO bids (product_id, user_id, bid_value) VALUES (?, ?, ?)";
    
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT_BID_SQL);
            stmt.setInt(1, bid.getProductId());
            stmt.setInt(2, bid.getUserId());
            stmt.setBigDecimal(3, bid.getBidValue());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}