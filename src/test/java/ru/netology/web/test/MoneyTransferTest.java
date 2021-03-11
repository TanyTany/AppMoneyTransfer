package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {


    @Test

    void shouldTransferMoneyFromFirstToSecondCard() {
        open("http://0.0.0.0:9999/");

        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceCard1 = dashboardPage.getFirstCardBalance();
        val balanceCard2 = dashboardPage.getSecondCardBalance();
        Integer transfer = 200;

        val moneyTransferPage = dashboardPage.addToFirstCard();
        moneyTransferPage.addToFirstCard(transfer);

        val expectedBalanceCard1 = balanceCard1 + transfer;
        val expectedBalanceCard2 = balanceCard2 - transfer;
        assertEquals(expectedBalanceCard1, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceCard2, dashboardPage.getSecondCardBalance());


    }

    @Test
    void shouldCancelTransferFromFirstToSecondCard() {
        open("http://0.0.0.0:9999/");

        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceCard1 = dashboardPage.getFirstCardBalance();
        val balanceCard2 = dashboardPage.getSecondCardBalance();
        Integer transfer = 200;

        val moneyTransferPage = dashboardPage.addToSecondCard();
        moneyTransferPage.cancelToSecondCard(transfer);

        val expectedBalanceCard1 = balanceCard1;
        val expectedBalanceCard2 = balanceCard2;
        assertEquals(expectedBalanceCard1, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceCard2, dashboardPage.getSecondCardBalance());


    }

    @Test
    void shouldNotTransferMoneyFromFirstToSecondCard() {
        open("http://0.0.0.0:9999/");

        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceCard1 = dashboardPage.getFirstCardBalance();
        val balanceCard2 = dashboardPage.getSecondCardBalance();
        Integer transfer = 10500;

        val moneyTransferPage = dashboardPage.addToFirstCard();
        moneyTransferPage.addToFirstCard(transfer);

        val expectedBalanceCard1 = balanceCard1;
        val expectedBalanceCard2 = balanceCard2;
        assertEquals(expectedBalanceCard1, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceCard2, dashboardPage.getSecondCardBalance());


    }

    @Test

    void shouldTransferMoneyFromSecondToFirstCard() {
        open("http://0.0.0.0:9999/");

        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceCard1 = dashboardPage.getFirstCardBalance();
        val balanceCard2 = dashboardPage.getSecondCardBalance();
        Integer transfer = 200;

        val moneyTransferPage = dashboardPage.addToSecondCard();
        moneyTransferPage.addSecondCard(transfer);

        val expectedBalanceCard1 = balanceCard1 - transfer;
        val expectedBalanceCard2 = balanceCard2 + transfer;
        assertEquals(expectedBalanceCard1, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceCard2, dashboardPage.getSecondCardBalance());


    }

    @Test
    void shouldCancelTransferFromSecondToFirstCard() {
        open("http://0.0.0.0:9999/");

        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceCard1 = dashboardPage.getFirstCardBalance();
        val balanceCard2 = dashboardPage.getSecondCardBalance();
        Integer transfer = 200;

        val moneyTransferPage = dashboardPage.addToFirstCard();
        moneyTransferPage.cancelToFirstCard(transfer);

        val expectedBalanceCard1 = balanceCard1;
        val expectedBalanceCard2 = balanceCard2;
        assertEquals(expectedBalanceCard1, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceCard2, dashboardPage.getSecondCardBalance());


    }

    @Test
    void shouldNotTransferMoneyFromSecondToFirstCard() {
        open("http://0.0.0.0:9999/");

        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceCard1 = dashboardPage.getFirstCardBalance();
        val balanceCard2 = dashboardPage.getSecondCardBalance();
        Integer transfer = 10500;

        val moneyTransferPage = dashboardPage.addToSecondCard();
        moneyTransferPage.addSecondCard(transfer);

        val expectedBalanceCard1 = balanceCard1;
        val expectedBalanceCard2 = balanceCard2;
        assertEquals(expectedBalanceCard1, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceCard2, dashboardPage.getSecondCardBalance());


    }

}
