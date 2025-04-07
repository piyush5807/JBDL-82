public class Calculator {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        MyThread t1 = new MyThread('+', a, b);
        t1.start();

        MyThread t2 = new MyThread('-', a, b);
        t2.start();

        MyThread t3 = new MyThread('*', a, b);
        t3.start();

        MyThread t4 = new MyThread('/', a, b);
        t4.start();

    }
    private static class MyThread extends Thread {

        private char operation;
        private int result;

        private int a;

        private int b;

        MyThread(char operation, int a, int b){
            this.operation = operation;
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            calculate();
        }

        public void calculate(){
            switch (this.operation){
//                case '+':
//                    this.result =
            }
        }
    }
}
