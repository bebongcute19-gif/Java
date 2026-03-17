package dao;

import model.Admin;

public interface IAdminDao {

    // tìm admin theo username
    Admin findByUsername(String username);

}