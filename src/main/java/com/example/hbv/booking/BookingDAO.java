package com.example.hbv.booking;

import com.example.hbv.tour.Tour;
import com.example.hbv.user.User;
import com.example.hbv.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.hbv.user.UserDAO.getGuide;

public class BookingDAO {
    private static final String tableName = "Tours";

    private static Booking resultMapper(ResultSet rs) throws SQLException {
        return new Booking(
                rs.getInt("id"),
                rs.getInt("tourId"),
                rs.getInt("userId")
        );
    }

    public static ArrayList<Booking> listBookingsForUser(int userId) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM Bookings WHERE userId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Booking> bookings = new ArrayList<>();
            while (rs.next()) {
                bookings.add(resultMapper(rs));
            }

            return bookings;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void addBooking(int tourId, int userId) {
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO Bookings (tourId, userId) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tourId);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
