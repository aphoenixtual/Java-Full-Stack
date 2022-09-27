package com.example.web;

import com.example.web.payload.Status;
import com.example.web.payload.TransferRequest;
import com.example.web.payload.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.service.TransferService;

@RestController
public class TransferController {


    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }



    @RequestMapping(
            value = "/transfer",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public TransferResponse doTransfer(@RequestBody TransferRequest request) {
        transferService.transfer(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
        TransferResponse response = new TransferResponse();
        response.setStatus(Status.SUCCESS);
        return response;
    }

}
