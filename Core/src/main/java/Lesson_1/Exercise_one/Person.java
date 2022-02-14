package main.java.Lesson_1.Exercise_one;

public class Person {
    public final String firstName;
    public final String lastName;
    public final String middleName;
    public final String country;
    public final String address;
    public final String phone;
    public final int age;
    public final String gender;


    public static class Builder {
        public String firstName;
        public String lastName;
        public String middleName;
        public String country = "Null";
        public String address = "Null";
        public String phone = "Null";
        public int age = 0;
        public String gender = "Null";

        public Builder(String firstName, String lastName, String middleName) {
            this.firstName = firstName;
            this.lastName = lastName;

            this.middleName = middleName;
        }

        public Builder addCountry(String countryParam) {
            country = countryParam;
            return this;
        }

        public Builder addAddress(String addressParam) {
            address = addressParam;
            return this;
        }

        public Builder addPhone(String phoneParam) {
            phone = phoneParam;
            return this;
        }

        public Builder addAge(int ageParam) {
            age = ageParam;
            return this;
        }

        public Builder addGender(String genderParam) {
            gender = genderParam;
            return this;
        }

        public Person buildPerson() {
            return new Person(this);
        }
    }


    private Person (Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
        country = builder.country;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
        gender = builder.gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
