package DAO.impl;

import DAO.IAdminDAO;
import Model.Admin;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IAdminDaoImpl implements IAdminDAO {

    @Override
    public Admin findByUsername(String username) {

        String sql = "SELECT * FROM admin WHERE username = ?";

        try (
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ) {

            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {

                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));

                return admin;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}