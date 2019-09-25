package com.NTT.controller;

import com.NTT.message.OrderSender;
import com.NTT.vo.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.NTT.message.OrderReceiver;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductController {

    @Autowired
    private OrderSender sender;

    @Autowired
    private OrderReceiver receiver;

    @PostMapping("/send")
    public HttpStatus orderProduct(@RequestBody Product product) throws Exception {
        sender.send(product.toString());
        String response = receiver.receiveMessage();
        if (StringUtils.isNotEmpty(response))
            return HttpStatus.OK;
        else
            return HttpStatus.BAD_REQUEST;
    }

}
