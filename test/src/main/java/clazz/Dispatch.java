package clazz;

public class Dispatch {


    //方法的接收者与方法的参数统称为方法的宗量
    //单分派是根据一个宗量对目标方法进行选择，多分派则是根据多于一个宗量对目标方法进行选择。



    static class QQ {}

    static class _360 {}

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }


    //编译阶段中编译器的选择过程，也就是静态分派的过程
    //  这时候选择目标方法的依据有两点：一是静态类型是Father还是Son，二是方法参数是QQ还是360。
    //  这次选择结果的最终产物是产生了两条invokevirtual指令，两条指令的参数分别为常量池中
    //  指向Father::hardChoice(360)及Father::hardChoice(QQ)方法的符号引用。
    //  因为是根据两个宗量进行选择，所以Java语言的静态分派属于多分派类型。


    //运行阶段中虚拟机的选择，也就是动态分派的过程。在执行“son.hardChoice(new QQ())”这行代码时，
    // 更准确地说，是在执行这行代码所对应的invokevirtual指令时，
    // 由于编译期已经决定目标方法的签名必须为hardChoice(QQ)，
    // 虚拟机此时不会关心传递过来的参数“QQ”到底是“腾讯QQ”还是“奇瑞QQ”，
    // 因为这时候参数的静态类型、实际类型都对方法的选择不会构成任何影响，
    // 唯一可以影响虚拟机选择的因素只有该方法的接受者的实际类型是Father还是Son。
    // 因为只有一个宗量作为选择依据，所以Java语言的动态分派属于单分派类型。

    //如今 Java语言是一门静态多分派、动态单分派的语言
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
