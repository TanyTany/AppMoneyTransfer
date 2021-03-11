package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoneyTransferPage {
    private SelenideElement codeField = $(withText("Пополнение карты"));
    private SelenideElement amount = $$(".input__control[type=text]").first();;
    private SelenideElement fromCard = $(".input__control[type=tel]");
    private SelenideElement buttonAdd = $(withText("Пополнить"));
    private SelenideElement buttonCancel = $(withText("Отмена"));

    public MoneyTransferPage() {
        codeField.shouldBe(Condition.visible);
    }

    public DashboardPage addToFirstCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberCard2());
        buttonAdd.click();
        return new DashboardPage();
    }

    public DashboardPage addSecondCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberCard1());
        buttonAdd.click();
        return new DashboardPage();
    }

    public DashboardPage cancelToFirstCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberCard2());
        buttonCancel.click();
        return new DashboardPage();
    }

    public DashboardPage cancelToSecondCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberCard1());
        buttonCancel.click();
        return new DashboardPage();
    }

}
