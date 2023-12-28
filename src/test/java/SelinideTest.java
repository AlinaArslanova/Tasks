import org.junit.Test;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
public class SelinideTest {

    @Test
    public void openPage() {
       open("http://vsfadev1:9080/prweb/PRServlet/");
        $(byId("txtUserID")).setValue("AMArslanova@alfabank.ru");
        $(byId("txtPassword")).setValue("rules");
        $(byClassName("loginButton")).click();
        $("[data-test-id='switch-wks']").shouldHave(text("DEV STUDIO"));
    }
}

