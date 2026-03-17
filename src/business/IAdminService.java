package business;
import model.Admin;
public interface IAdminService {

    // đăng nhập admin
    Admin login(String username, String password);

}
