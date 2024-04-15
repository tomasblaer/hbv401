package com.example.hbv.tour;
import com.example.hbv.user.User;
import com.example.hbv.util.Database;
import java.sql.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.hbv.user.UserDAO.getGuide;

public class TourDAO {
    private static final String tableName = "Tours";

    private static Tour resultMapper(ResultSet rs) throws SQLException {
        User guide = getGuide(rs.getInt("guideId"));
        return new Tour(
                rs.getInt("id"),
                rs.getString("category"),
                rs.getInt("capacity"),
                LocalDate.parse(rs.getString("date")),
                rs.getString("name"),
                guide,
                rs.getString("info")
        );
    }

    public static ArrayList<Tour> listAvailableTours() {
        try (Connection conn = Database.connect()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName +  " WHERE capacity > 0");
            ArrayList<Tour> tours = new ArrayList<>();

            while (rs.next()) {
                tours.add(resultMapper(rs));
            }

            return tours;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Tour> listToursByGuide(int guideId) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE guideId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, guideId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Tour> tours = new ArrayList<>();
            while (rs.next()) {
                tours.add(resultMapper(rs));
            }

            return tours;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Tour> getToursByName(String name) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE upper(name) LIKE ? OR upper(category) LIKE ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name.toUpperCase() + "%");
            pstmt.setString(2, "%" + name.toUpperCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Tour> tours = new ArrayList<>();
            while (rs.next()) {
                tours.add(resultMapper(rs));
            }

            return tours;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Tour> getToursOrderedByDate() {
        try (Connection conn = Database.connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " ORDER BY date");
            ArrayList<Tour> tours = new ArrayList<>();
            while (rs.next()) {
                tours.add(resultMapper(rs));
            }
            return tours;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Tour> listBookedToursForUser(int userId) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM " + tableName + " JOIN Bookings ON Tours.id = Bookings.tourId WHERE Bookings.userId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Tour> tours = new ArrayList<>();
            while (rs.next()) {
                tours.add(resultMapper(rs));
            }

            return tours;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void decrementTourCapacity(int tourId) {
        try (Connection conn = Database.connect()) {
            String sql = "UPDATE " + tableName + " SET capacity = capacity - 1 WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tourId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
