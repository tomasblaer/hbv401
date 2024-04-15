package com.example.hbv.user;

import com.example.hbv.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final static String tableName = "Users";

    private static User resultMapper(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone_nr"),
                rs.getString("isGuide").equals("1")
        );
    }

    public static User getUser(String username) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE name = ?";
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

    public static User getGuide(int id) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User potentialGuide = resultMapper(rs);
                if (potentialGuide.isGuide()) {
                    return potentialGuide;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
