package org.sawaklaudia;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class HomeOffice {

    public static void main(String[] args) {
        AppLaunchType springInsertedData = new SpringInsertedData();
        AppLaunchType manuallyInsertedData = new ManuallyInsertedData();
        DataInsertion dataInsertion = new DataInsertion(springInsertedData);
        dataInsertion.runApp();
    }
}