package don_yerdna.spring_boot_mvc.service;


import don_yerdna.spring_boot_mvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);

    User getUserById(Long id);
    void removeUserById(Long id);
}
