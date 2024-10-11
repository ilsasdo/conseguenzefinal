package modenadevfest.slide_021;

import java.util.logging.Logger;

public class LoginAuth {

    private final UserRepository userRepository;

    public LoginAuth(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String loginPage(String username) {
        User user = userRepository.findByUsername(username);

        String page = null;
        if (user != null) {
            user.loadGrants();

            if (user.isNotAdmin()) {
                page = "/user.html";
            } else {
                if (!user.switchedUser()) {
                    page = "/home.html";
                } else {
                    page = "/switchuser.html";
                }
            }
        } else {
            page = "/404.html";
        }

        return page;
    }

    private class Login2 {
        public String loginPage(String username) {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                return "/404.html";
            }

            user.loadGrants();

            if (user.isBasicUser()) {
                return "/user.html";
            }

            if (user.isSwitchedAdmin()) {
                return "/admin.html";
            }

            return "/switchuser.html";
        }
    }
}
