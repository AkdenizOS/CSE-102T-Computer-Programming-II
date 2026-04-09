

abstract class ClassA{
    ClassA(){
        super();
    }
abstract int b();
    int a = 1;
}

interface InterfaceF{

   void orneklem();
}

abstract class ClassB extends ClassA {

    ClassB(){
        super();
    }

}

class ClassC extends ClassA implements InterfaceF{

    @Override
    int b() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'b'");
    }

    @Override
    public void orneklem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orneklem'");
    }}

class ClassD extends ClassB{

    int c = 2;

    @Override
    int b() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'b'");
    }}


    

class ClassE extends ClassC{}

class ClassEfe{



ClassC classC = new ClassC();

ClassA ccc = new ClassA() {

    @Override
    int b() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'b'");
    }
    
};

}


/**
 * Quiz02
 */
public class Quiz02 {


    public static void main(String[] args) {
    ClassB myObject = new ClassD();

    InterfaceF mton = new InterfaceF() {

        @Override
        public void orneklem() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'orneklem'");
        }
        
    };
        
    
    }
}

interface a {

    static int v(){
return 5;
    }
}