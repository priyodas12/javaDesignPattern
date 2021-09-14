package pattern.creational.builder;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDtoBuilder implements  UserDtoBuilder{

    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserWebDto dto;

    @Override
    public UserDtoBuilder withFirstName(String fname) {
        this.firstName=fname;
        return this;
    }

    @Override
    public UserDtoBuilder withLastName(String lname) {
        this.lastName=lname;
        return this;
    }

    @Override
    public UserDtoBuilder withBirthDay(LocalDate date) {
        Period ageInYears=Period.between(date,LocalDate.now());
        age=Integer.toString(ageInYears.getYears());
        return this;
    }

    @Override
    public UserDtoBuilder withAddress(Address address) {
        this.address=address.getHouseNumber()
                +"\n"+address.getStreet()
                +"\n"+address.getCity()
                +"\n"+address.getState()
                +"\n"+address.getZipcode();

        return this;
    }

    @Override
    public UserDto build() {
        dto=new UserWebDto(firstName+" "+lastName,address,age);
        return dto;
    }

    @Override
    public UserDto getUserDto() {
        return dto;
    }
}
