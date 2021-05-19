package concurrent;

public class PTEst {

    private  long arr[] = new long[2000];
    private  boolean[] flags = new boolean[1000] ;
    private  volatile boolean ff = true;
    void  chang() {
        while (true) {
            for (int i = 0; i < 1000; i ++) {
                flags[i] = ff;
            }
            ff = !ff;
        }

    }

    void show1() {

        while (true) {
            boolean p = ff;

            if ( flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9]
                    && flags[10] && flags[11] && flags[12] && flags[13] && flags[14] && flags[15] && flags[16] && flags[17] &&
                    flags[111] && flags[119]  && flags[116] && flags[117] && flags[118]
                    && flags[101] && flags[112] && flags[113] && flags[114] && flags[115]) {
                System.out.println("show1");

            }
        }

    }
    void show2() {
        boolean p = ff;

        while (true) {
            if ( flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9]
                    && flags[10] && flags[11] && flags[12] && flags[13] && flags[14] && flags[15] & flags[16] && flags[17] &&
                    flags[111] && flags[119]  && flags[116] && flags[117] && flags[118]
                    && flags[101] && flags[112] && flags[113] && flags[114] && flags[115] )  {
                System.out.println("show2");

            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        PTEst ptEst = new PTEst();
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ptEst.chang();
        });
        Thread thread3 = new Thread(() -> {

            ptEst.show1();
        });

        Thread thread2 = new Thread(() -> {

            ptEst.show2();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }

}
