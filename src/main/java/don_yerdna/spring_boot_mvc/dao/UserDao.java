package don_yerdna.spring_boot_mvc.dao;


import don_yerdna.spring_boot_mvc.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);
    void removeUserById(Long id);

}
