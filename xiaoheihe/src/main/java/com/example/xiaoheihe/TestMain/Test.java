package com.example.xiaoheihe.TestMain;

class Test {
    public static void main(String[] args) {
        //当子类覆盖有父类的方法时，优先调用子类方法
        //finally中的代码不会改变基本数据类型的try代码块的return值
        //finally中return语句会覆盖try中的return语句
        System.out.println(new B().getValue());
    }
    static class A{
        protected int value;
        public A(int v){
            setValue(v);
            sayHello();
        }
        public int getValue() {
            try{
                value++;
                return value;
            }catch (Exception e){
                System.out.println(e.toString());
            }finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void sayHello(){
            System.out.println("A");
        }
    }
    static class B extends A{
        public B(){
            super(5);
            int b = getValue();
            setValue(b - 3);
            System.out.println(value);
        }

        @Override
        public void setValue(int value){
            super.setValue(2 * value);
        }

        public void sayHello(){
            System.out.println("hello");
        }
    }

}

