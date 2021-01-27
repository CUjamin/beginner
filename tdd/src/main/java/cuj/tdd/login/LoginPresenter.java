package cuj.tdd.login;

/**
 * @author cujamin
 * @date 2020/7/19
 */
public class LoginPresenter {
    private UserManager mUserManager = new UserManager();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) {
            return;
        }
        if (password == null || password.length() < 6) {
            return;
        }

        mUserManager.performLogin(username, password);
    }

    public void setUserManager(UserManager userManager) {  //<==
        this.mUserManager = userManager;
    }
}
