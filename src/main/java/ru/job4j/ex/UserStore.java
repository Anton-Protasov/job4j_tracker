package ru.job4j.ex;

/**
 * 0.5. Иерархия исключений и множественный catch. [#395230]
 * findUser - если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.
 * validate - если пользователь не валидный или если имя пользователя состоит из менее трех символов,
 * то кинуть исключение UserInvalidException
 */

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if(login.equals(users[i].getUsername())) {
                user = users[i];
                break;
            } else if (user == null) {
                throw new UserNotFoundException("User not found");
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}
