import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public boolean hasAge() {
        return !(age < 0);
    }

    public boolean hasAddress() {
        return !address.equals("");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (this.hasAge())
            return OptionalInt.of(age);
        return OptionalInt.empty();
    }

    public String getAddress() {
        if (this.hasAddress())
            return address;
        return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        String toString = name + " " + surname;
        if (this.hasAge())
            toString += ", возраст " + this.age;
        if (this.hasAddress())
            toString += ", город " + this.address;
        return toString;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().
                setSurname(this.surname).
                setAddress(this.address).
                setAge(0);  // Если возраст ребенка не указывается при вызове build,
                            // считаем, что ребенок новорожденный
    }
}
