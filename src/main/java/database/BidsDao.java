package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Bids;

public class BidsDao {

    public List<Bids> getBidsByProductId(int productId) throws ClassNotFoundException {
        String SELECT_BIDS_SQL = "SELECT * FROM bids WHERE product_id = ? ORDER BY bid_value DESC";
        List<Bids> bids = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BIDS_SQL);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Bids bid = new Bids();
                
                bid.setBidId(rs.getInt("bid_id"));
                bid.setProductId(rs.getInt("product_id"));
                bid.setUserId(rs.getInt("user_id"));
                bid.setBidValue(rs.getBigDecimal("bid_value"));
                bid.setBidTime(rs.getTimestamp("bid_time"));

                bids.add(bid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bids;
    }

    public boolean insertBid(Bids bid) {
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