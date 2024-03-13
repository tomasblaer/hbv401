package com.example.hbv.user;

import com.example.hbv.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final static String tableName = "user";

    private static User resultMapper(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("phoneNumber"),
                rs.getString("email"),
                rs.getString("isAgent").equals("1")
        );
    }

    public static User getUser(String username) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return resultMapper(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
