package Business;
import Model.Admin;
public interface IAdminService {

    // đăng nhập admin
    Admin login(String username, String password);

}
