package arthur.dy.lee.mybatisplusdemo.reflect;

/**
 * @auther arthur.dy.lee
 * @since 2019/3/10 23:08
 */
class Account {

    public static String getType() {
        return "Personal";
    }
}

public class Customer {
    public String getAccountType() {
        return Account.getType();
    }
}
