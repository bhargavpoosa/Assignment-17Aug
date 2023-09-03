import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
class Employee1{
    private int emp_id;

    private String emp_name;

    public Employee1(int emp_id, String emp_name){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee1) {
            Employee1 e = (Employee1) obj;
            return emp_id == e.emp_id && emp_name.equals(e.emp_name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return emp_id + emp_name.hashCode();
    }


    @Override
    public String toString() {
        return emp_id + " " + emp_name;
    }
}

class Address{
    private int flat_no;
    private String street;

    public Address(int flat_no,String street) {
        this.flat_no = flat_no;
        this.street = street;
    }

    @Override
    public String toString() {
        return flat_no + " " + street;
    }
}

public class mainmethod {
    public static void main(String args[]){

        HashMap<Employee1,Address> m2 = new HashMap<>();
        Employee1 e1 = new Employee1(1,"bhargav");
        Employee1 e2 = new Employee1(1, "bhargav");
        Employee1 e3 = new Employee1(2, "sasuke");
        m2.put(e1,new Address(12,"hyd"));
        m2.put(e2, new Address(13,"mumbai"));
        m2.put(e3, new Address(13,"mumbai"));
        m2.put(e1, new Address(13,"mumbai"));

        //Deque
        Deque<Address> deque = new ArrayDeque<>();
        deque.addFirst(new Address(2,"mumbai"));
        deque.addFirst(new Address(1,"delhi"));
        System.out.println(deque.removeLast());

        //IntegerArrayIterator
        IntegerArray array = new IntegerArray(10);
        for(int i=0;i<10;i++)
            array.setElement(i,new Integer(100));

        for(int i=0;i<10;i++)
            System.out.println(array.getElement(i));

        IntegerArray.IntegerArrayIterator itr = array.getIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
