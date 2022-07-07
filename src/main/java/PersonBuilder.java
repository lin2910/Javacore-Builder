public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100)
            throw new IllegalStateException("Недопустимый возраст: " + age);
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null)
            throw new IllegalStateException("Попытка создать человека без имени");
        if (surname == null)
            throw new IllegalStateException("Попытка создать человека без фамилии");
        Person person;

        if (age != -1)
            person = new Person(name, surname, age);
        else
            person = new Person(name, surname);
        if (address != null)
            person.setAddress(address);
        return person;
    }
}