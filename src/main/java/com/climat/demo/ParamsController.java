package com.climat.demo;

import com.climat.demo.Models.ParamsModel;
import com.climat.demo.database.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParamsController {
    public ParamsModel getParams(int userId) throws SQLException {
        ResultSet rs = DBConnection.getInstance().getStatement().executeQuery("SELECT * from climat.params WHERE user_id = " + userId + ";");
        ParamsModel paramsModel = new ParamsModel();

        while (rs.next()) {
            paramsModel.setAirMax(rs.getString("air_max"));
            paramsModel.setAirMin(rs.getString("air_min"));
            paramsModel.setWetMin(rs.getString("wet_min"));
            paramsModel.setWetMax(rs.getString("wet_max"));
            paramsModel.setTempMax(rs.getString("temp_max"));
            paramsModel.setTempMin(rs.getString("temp_min"));
        }
        return paramsModel;
    }

    public void save(ParamsModel paramsModel) {
        String sql = "UPDATE climat.params " +
                "SET air_max = ?, air_min = ?, temp_max = ?, temp_min = ?, wet_max = ?, wet_min = ? " +
                "WHERE user_id = ?";

        try (PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            statement.setString(1, paramsModel.getAirMax());
            statement.setString(2, paramsModel.getAirMin());
            statement.setString(3, paramsModel.getTempMax());
            statement.setString(4, paramsModel.getTempMin());
            statement.setString(5, paramsModel.getWetMax());
            statement.setString(6, paramsModel.getWetMin());
            statement.setInt(7, paramsModel.getUserId());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
