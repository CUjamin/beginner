package cuj.tdd.login;

import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author cujamin
 * @date 2020/7/19
 */
public class LoginPresenterTest {

    @org.junit.Test
    public void login() {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);
        loginPresenter.login("xiaochuang", "xiaochuang password");
        Mockito.verify(mockUserManager).performLogin("xiaochuang", "xiaochuang password");
    }
}