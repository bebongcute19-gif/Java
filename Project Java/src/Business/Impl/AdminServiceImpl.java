package Business.Impl;

import Business.IAdminService;
import Dao.IAdminDAO;
import Dao.impl.IAdminDaoImpl;
import Model.Admin;

public class AdminServiceImpl implements IAdminService {

    private IAdminDAO adminDao = new IAdminDaoImpl();

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