package fr.plil.sio.jpa;

import java.util.List;
import javax.persistence.EnumType;

public interface UserService {

    /**
     * Create an user.
     *
     * @param name name of the user
     * @return the new user instance
     * @throws NullPointerException  if name is null
     * @throws IllegalStateException if an user with the same name exist in the database
     */
    User createUser(String name, String password, EnumType et);

    /**
     * Delete an user from the database and remove all attached animals.
     *
     * @param name name of the user to delete
     * @throws NullPointerException  if name is null
     * @throws IllegalStateException if user does not exist in the database.
     */
    void removeUser(String name);

    /**
     * Return all users in the database. Only one level dependencies.
     *
     * @return The list of users.
     */
    List<User> findAll();

    /**
     * Return an user instance with specified name..
     *
     * @param name the name of the user to return.
     * @return the user instance or null if not found
     * @throws NullPointerException if parameter is null
     */
    User findByName(String name);
}
