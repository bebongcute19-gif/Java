package business.impl;

import business.IAdminService;
import dao.IAdminDao;
import dao.impl.AdminDaoImpl;
import model.Admin;

public class AdminServiceImpl implements IAdminService {

    private IAdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {

        // tìm admin theo username
        Admin admin = adminDao.findByUsername(username);

        if(admin != null && admin.getPassword().equals(password)){
            return admin;

        }

        return null;
    }
}