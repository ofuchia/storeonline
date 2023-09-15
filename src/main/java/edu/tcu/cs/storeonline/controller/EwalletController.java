package edu.tcu.cs.storeonline.controller;

import edu.tcu.cs.storeonline.domain.Ewallet;
import edu.tcu.cs.storeonline.domain.Result;
import edu.tcu.cs.storeonline.domain.StatusCode;
import org.springframework.web.bind.annotation.*;
import edu.tcu.cs.storeonline.service.EwalletService;

@RestController
@RequestMapping("/artifact") //keeping as artifact bc thats interface.
public class EwalletController {

    private EwalletService ewalletService;

    public EwalletController(EwalletService ewalletService) {
        this.ewalletService = ewalletService;
    }

    @GetMapping("/{ewalletId}")
    public Result findById(@PathVariable String ewalletId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success", ewalletService.findById(ewalletId));

    }

  @PostMapping
    public Result save(@RequestBody Ewallet newEwallet){
      ewalletService.save(newEwallet);
      return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{ewalletId}")
    public Result update(@PathVariable String ewalletId, @RequestBody Ewallet updatedEwallet){ //need ID of old to combine with Updates made
        ewalletService.update(ewalletId, updatedEwallet);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

}
