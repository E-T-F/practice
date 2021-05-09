package clazz;

/**
 * 字段不参与多态
 */
public class FieldHasNoPolymorphic {


    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son,  i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        //main()的最后一句通过静态类型访问到了父类中的money，输出了2
        System.out.println("This gay has $" + gay.money);
    }

}

