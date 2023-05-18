import exceptions.WrongAccountException;
import exceptions.WrongCurrencyException;
import exceptions.WrongOperationException;

/*
1. Створити новий IntelliJ-проект
2. Скопіювати у папку src проекту з пункту 1 все, що лежить у папці lection 16 exceptions/src (link).
   У проекті має лежати 6 класів: WrongAccountException, WrongCurrencyException, 
   WrongOperationException,Account, BankApplication, Main
3. У Main методі main класу створити обєкт типу BankApplication
4. Викликати метод process з наступними параметрами:
    4.1 id = accountId000, amount 50, currency USD
    4.2 id = accountId003, amount 250, currency HRV
    4.3 id = accountId001, amount 50, currency EUR
    4.4 id = accountId001, amount 50, currency USD
    4.4 id = accountId001, amount 50, currency USD
5. Кожен метод огорнути в try catch finally структуру і для кожного з WrongAccountException,
   WrongCurrencyException, WrongOperationException, Exception виводити в консоль змістовне повідомлення:
Такого акаунту не існує
Акаунт має рахунок в іншій валюті
Акаунт не має достатньо коштів
Сталася помилка при процесінгу, спробуйте ще раз
У finally потрібно виводити повідомлення:

Дякуємо, що скористалися нашим сервісом
 */
public class Main {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        process(bankApplication, "accountId000", 50, "USD");
        process(bankApplication, "accountId003", 250, "HRV");
        process(bankApplication, "accountId001", 50, "EUR");
        process(bankApplication, "accountId001", 50, "USD");
        process(bankApplication, "accountId001", 50, "USD");

        process(bankApplication, "accountId004", 1500, "USD");

    }

    private static void process(BankApplication bankApplication, String accountId, int amount, String currency) {
        try {
            bankApplication.process(accountId,amount,currency);
        } catch (WrongAccountException e) {
            System.out.printf("%s - %s\n","Такого акаунту не існує", accountId);
        } catch (WrongCurrencyException e) {
            System.out.printf("%s, ваша спроба - %s\n","Акаунт має рахунок в іншій валюті", currency);
        } catch (WrongOperationException e) {
            System.out.printf("%s для зняття %d %s\n","Акаунт не має достатньо коштів", amount, currency);
        } catch (Exception e) {
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}
