package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javaFakerTest(){
        //1-FAKER OBJESI OLUSTUR
       Faker faker=new Faker();

       //2-FAKER OBJESI ILE FAKE DATA OLUSTUR
        //first name datasi
        String firstName = faker.name().firstName();
        System.out.println(firstName);

        //last name datasi
        String lastName= faker.name().lastName();
        System.out.println(lastName);

        //kullanici adi
        String userName= faker.name().username();
        System.out.println(userName);

        //meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //full adress
        System.out.println(faker.address().fullAddress());

        //cep tel no
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //rastgele 15 haneli numara
        System.out.println(faker.number().digits(15));

        /*
        TEST DATA : Kullanici adi,sifre, tel no, email, sehir, kredi kart no,...
        Test datalari kimden alinir?
        1. BA-Business anaylist(Accepance Criteria lari yazar)
        2. Test Lead
        3. Manual Tester
        4. Tech Lead & Team Lead & Dev Lead
        5. Developer
        6. Database
        7. API call lar
        8. Documantasyonlar. ORN API swagger documani
        9. Java Faker da fake data almak icin kullaniyoruz

        NERDEN GELMEZ : Kullanicidan , scrum master
         */


    }
}
