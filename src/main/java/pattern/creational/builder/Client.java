package pattern.creational.builder;

import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {
        User user=createUser();
        UserDtoBuilder builder=new UserWebDtoBuilder();

        UserDto dto=finalBuild(builder,user);
        System.out.println(dto);
    }

    //director
    private static UserDto finalBuild(UserDtoBuilder builder,User user){
       return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withBirthDay(user.getBirthday())
                .build();
    }

    public static User createUser(){
        User user=new User();
        user.setBirthday(LocalDate.of(1991,8,4));
        user.setFirstName("John");
        user.setLastName("Xavier");
        Address address=new Address();
        address.setHouseNumber("129");
        address.setStreet("6th Cross");
        address.setCity("Manhattan");
        address.setState("NYX");
        address.setZipcode("9GHH821");
        user.setAddress(address);
        return user;
    }
}
