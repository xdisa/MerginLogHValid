package Onee;



import java.lang.reflect.Field;
import java.util.*;


public class UserData {
    private int id;
    private String password;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserData(int id, String password, String lastName) {
        this.id = id;
        this.password = password;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id && Objects.equals(password, userData.password) && Objects.equals(lastName, userData.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, lastName);
    }

    @Override
    public String toString() {
        return "UserData{" +
            "id=" + id +
            ", password='" + password + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }

    public UserData() {
    }


    public static void copyMatchingFields( Object fromObj, Object toObj ) {
        if ( fromObj == null || toObj == null )
            throw new NullPointerException("не ноль");

        Class fromClass = fromObj.getClass();
        Class toClass = toObj.getClass();

        Field[] fields = fromClass.getDeclaredFields();
        for ( Field f : fields ) {
            try {
                Field t = toClass.getDeclaredField( f.getName() );

                if ( t.getType() == f.getType() ) {

                    if ( t.getType() == String.class
                            || t.getType() == int.class || t.getType() == Integer.class
                            || t.getType() == char.class || t.getType() == Character.class) {
                        f.setAccessible(true);
                        t.setAccessible(true);
                        t.set( toObj, f.get(fromObj) );
                    } else if ( t.getType() == Date.class  ) {

                        Date d = (Date)f.get(fromObj);
                        f.setAccessible(true);
                        t.setAccessible(true);
                        t.set( toObj, d != null ? d.clone() : null );
                    }
                }
            } catch (NoSuchFieldException ex) {
            } catch (IllegalAccessException ex) {
                System.out.println("error");
            }
        }
    }
}
