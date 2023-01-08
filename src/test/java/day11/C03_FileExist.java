package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void isExistTest(){
        String userDIR= System.getProperty("user.dir");
        System.out.println(userDIR); //C:\Users\Lenovo\IdeaProjects\com.Maven_Junit

        String userHome= System.getProperty("user.home");
        System.out.println(userHome);//C:\Users\Lenovo

        //logo.jpeg indirip MASAUSTUNE kaydedin
        //logo masaustunde : \Users\Lenovo

        String dosyaYolu= userHome+ "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist= Files.exists(Paths.get(dosyaYolu)); //dosya var ise true, yok ise false
        Assert.assertTrue(isExist);
        /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */

    }
}
