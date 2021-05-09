package java.lang;

//尝试去写一个与rt.jar类库中已有类重名的Java类，将会发现它可以正常编译，但永远无法被加载运行
public class Byte {
    public static void main(String[] args) {
        new Byte();
    }



}
