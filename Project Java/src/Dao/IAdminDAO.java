package Dao;

import Model.Admin;

public interface IAdminDAO {

    // tìm admin theo username
    Admin findByUsername(String username);

}