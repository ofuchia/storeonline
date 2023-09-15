package edu.tcu.cs.storeonline.datainitializer;

import edu.tcu.cs.storeonline.dao.EwalletDao;
import edu.tcu.cs.storeonline.domain.Ewallet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private EwalletDao ewalletDao;

    public DBDataInitializer(EwalletDao ewalletDao) {
        this.ewalletDao = ewalletDao;
    }

    @Override
    public void run(String... args) throws Exception {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Ewallet e1 = new Ewallet();
        e1.setId("00");   //calling on util with snowflake to create ID..in service tab?
        e1.setBalance("0");
        e1.setCreationTime(timeStamp);
        e1.setLastModifiedTime(e1.getCreationTime());   //same at time of creation, but different when accessed afterwards
        e1.setStatus("Normal");     //im making Normal the default

        Ewallet e2 = new Ewallet();
        e2.setId("01");   //calling on util with snowflake to create ID..in service tab?
        e2.setBalance("0");
        e2.setCreationTime(timeStamp);
        e2.setLastModifiedTime(e1.getCreationTime()); //setting last modified to creation time at boot
        e2.setStatus("Normal");     //im making Normal the default

        Ewallet e3 = new Ewallet();
        e3.setId("02");   //calling on util with snowflake to create ID..in service tab?
        e3.setBalance("0");
        e3.setCreationTime(timeStamp);
        e3.setLastModifiedTime(e3.getCreationTime());  //same at time of creation, but different when accessed afterwards
        e3.setStatus("Normal");     //im making Normal the default

        Ewallet e4 = new Ewallet();
        e4.setId("03");   //calling on util with snowflake to create ID..in service tab?
        e4.setBalance("0");
        e4.setCreationTime(timeStamp);
        e4.setLastModifiedTime(e4.getCreationTime());  //same at time of creation, but different when accessed afterwards
        e4.setStatus("Normal");     //im making Normal the default

        ewalletDao.save(e1);
        ewalletDao.save(e2);
        ewalletDao.save(e3);
        ewalletDao.save(e4);

    }
}
