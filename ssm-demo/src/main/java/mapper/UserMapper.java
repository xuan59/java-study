package mapper;

import api.User;

public interface UserMapper {

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer id);

}
