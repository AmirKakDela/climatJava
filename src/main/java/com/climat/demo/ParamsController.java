package com.climat.demo;

import com.climat.demo.Models.ParamsModel;
import com.climat.demo.database.DBConnection;

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
//        ResultSet rs = DBConnection.getInstance().getStatement().executeQuery(
//                "INSERT INTO table_name (param_id, air_max, air_min, wet_min, wet_max, temp_max, temp_min)\n" +
//                "VALUES (1, '', 'value2', ...)\n" +
//                "ON DUPLICATE KEY UPDATE\n" +
//                "    air_max = VALUES(air_max),\n" +
//                "    air_min = VALUES(column2),\n" +
//                "    wet_min = VALUES(wet_min),\n" +
//                "    air_min = VALUES(column2),\n" +
//                "    air_min = VALUES(column2),\n" +
//                "    air_min = VALUES(column2),\n");
    }
}
