package com.example.hbv.tour;
import com.example.hbv.util.Database;
import java.sql.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TourDAO {
    private static final String tableName = "tour";

    private static Tour resultMapper(ResultSet rs) throws SQLException {
        return new Tour(
                rs.getString("id"),
                rs.getString("category"),
                rs.getInt("capacity"),
                LocalDate.parse(rs.getString("date")),
                rs.getString("name"),
                null, // Todo
                rs.getString("info")
        );
    }

    public static ArrayList<Tour> listTours() {
        try (Connection conn = Database.connect()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
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


}
