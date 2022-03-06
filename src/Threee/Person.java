package Threee;

import java.lang.reflect.Field;
import java.util.Objects;

public class Person {

    @Min(50)
    private int age;

    @NotEmpty
    @NotNull
    private String name;


    @Max(100)
    private int id;

    @Length(min = 5, max = 10)
    private String PhoneNumber;

    public Person(int age, String name, int id, String phoneNumber) {
        this.age = age;
        this.name = name;
        this.id = id;
        PhoneNumber = phoneNumber;
    }


    //////////////////////////////////////////////////////////////////////////////


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", id=" + id +
            ", PhoneNumber=" + PhoneNumber +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && id == person.id && PhoneNumber == person.PhoneNumber && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, id, PhoneNumber);
    }
    ///////////////////////////////////////////////////////////////////////////////////////


    public static void validateStringLength(Person person) throws  IllegalAccessException {
        Class<?> clazz = person.getClass();
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(Length.class)) {
                Length an =field.getAnnotation(Length.class);
                int min =an.min();
                int max = an.max();

                field.setAccessible(true);
                String value = field.get(person).toString();
                if((value.length()<min) || (value.length()>max)){
                    throw new IllegalStateException(field.getName()
                        + "length should be between " + min + "and" + max);

                }
            }
        }
    }

    public static void checkMax(Person person) throws IllegalAccessException {
        for(Field field : person.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Max.class)){
                Max an = field.getAnnotation(Max.class);
                int maxSize = an.value();
                field.setAccessible(true);
                Integer value = (Integer) field.get(person);
                if(value > maxSize){
                    throw new RuntimeException("error");

                }
            }
        }
    }
    public static void checkMin(Person person) throws IllegalAccessException {
        for(Field field : person.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Min.class)){
                Min an = field.getAnnotation(Min.class);
                int minSize = an.value();
                field.setAccessible(true);
                Integer value = (Integer) field.get(person);
                if(value < minSize){
                    throw new RuntimeException("error");

                }
            }
        }
    }

    public static void checkNotEmpty(Object person) throws  IllegalAccessException {
        Class<?> clazz = person.getClass();
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(NotEmpty.class)) {
                NotEmpty an =field.getAnnotation(NotEmpty.class);
                field.setAccessible(true);
                String value = field.get(person).toString();
                if( value.equals("")){
                    throw new RuntimeException("error");

                }
            }
        }
    }


    public static void checkNotNull(Object person) throws  IllegalAccessException {
        Class<?> clazz = person.getClass();
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(NotNull.class)) {
                NotNull an =field.getAnnotation(NotNull.class);
                field.setAccessible(true);
                String value = field.get(person).toString();
                if(value==null){
                    throw new RuntimeException("error");

                }
            }
        }
    }









}
