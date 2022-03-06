package Threee;

import Threee.Person;

public class Main {

    public static void main(String[] args) throws IllegalStateException, IllegalAccessException {
        Person p1 = new Person(51,"Bob",1000,"911456");
        Person p2 = new Person(49,null,2,"133356700000000");
        Person p3 = new Person(52,"Mike", 3,"1234");
        Person p4 = new Person(55,"",4,"5433564");
          //Person.validateStringLength(p2); //-> error min/max length
           //Person.validateStringLength(p3); // error min/max length
         //Person.checkMax(p1); //->error max
       // Person.checkMin(p2); //min
       // Person.checkNotEmpty(p2); //notNull
        //Person.checkNotEmpty(p4);//notEmpty
    }

}
