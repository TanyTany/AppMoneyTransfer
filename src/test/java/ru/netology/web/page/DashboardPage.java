package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");

  public DashboardPage() {
    heading.shouldBe(Condition.visible);
  }

  private ElementsCollection cards = $$(".list__item");
  private final String balanceStar = "баланс: ";
  private final String balanceFinish = " р.";

  public int getFirstCardBalance() {
    val text = cards.first().text();
    return extractBalance(text);
  }

  public int getSecondCardBalance() {
    val text = cards.last().text();
    return extractBalance(text);
  }

  private int extractBalance(String text) {
    val start = text.indexOf(balanceStar);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStar.length(), finish);
    return Integer.parseInt(value);
  }

  private SelenideElement addToFirst = $$(".list__item .button__text").first();
  private SelenideElement addToSecond = $$(".list__item .button__text").last();

  public MoneyTransferPage addToFirstCard() {
    addToFirst.click();
    return new MoneyTransferPage();
  }

  public MoneyTransferPage addToSecondCard() {
    addToSecond.click();
    return new MoneyTransferPage();
  }

}
