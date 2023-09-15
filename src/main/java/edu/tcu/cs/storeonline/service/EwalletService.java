package edu.tcu.cs.storeonline.service;

import edu.tcu.cs.storeonline.domain.Ewallet;
import edu.tcu.cs.storeonline.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.tcu.cs.storeonline.dao.EwalletDao;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class EwalletService {
    private EwalletDao ewalletDao;
    private IdWorker idWorker;


    //having constructors allow for Bean injections
    public EwalletService(EwalletDao ewalletDao, IdWorker idWorker) {
        this.ewalletDao = ewalletDao;
        this.idWorker = idWorker;
    }

    public void save(Ewallet newEwallet) {
        newEwallet.setId(idWorker.nextId()+"");     //generates unique IDs if there are no preexisting artifacts/ewallets.
        ewalletDao.save(newEwallet);


    }

    public Ewallet findById(String ewalletId) {
        return ewalletDao.findById(ewalletId).get();
    }


    public void update(String ewalletId, Ewallet updatedEwallet) {      //this is what we're gonna need to create new wallets into database.

        String updatedTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        updatedEwallet.setLastModifiedTime(updatedTimeStamp);
        updatedEwallet.setId(ewalletId);


        //temp variable to save status pre-update:
        Ewallet tempStat = ewalletDao.findById(ewalletId).get();

        if(updatedEwallet.getStatus() == null){ //keep previous status bc nothing was passed into the json file
            updatedEwallet.setStatus(tempStat.getStatus());
        }
        else {
            updatedEwallet.setStatus(updatedEwallet.getStatus());
        }

        if(updatedEwallet.getBalance() == null || updatedEwallet.getStatus().contains("Freeze") || updatedEwallet.getStatus().contains("freeze")){ //keep previous status bc nothing was passed into the json file or bc frozen
            updatedEwallet.setBalance(tempStat.getBalance());
        }
        else{
            updatedEwallet.setStatus(updatedEwallet.getStatus()); //bc getting the status from json

        }

        updatedEwallet.setCreationTime(ewalletDao.findById(ewalletId).get().getCreationTime());       //getting creation time declared in local Ewallet class, not from DBD Initilization. that's why its showing from null


        ewalletDao.save(updatedEwallet);    //pulling content from JSON file
    }
}
