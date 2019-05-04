package com.shutl.controller;

import com.shutl.model.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class QuoteController {

    @RequestMapping(value = "/quote", method = POST)
    public
    String quote( Quote quote, Model model) {
        model.addAttribute("quote" , new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), quote.calc_delivery_cost()));
        return "response";
    }

    @RequestMapping(value = "/quote", method = GET)
    public String redirect(Model model) {
        model.addAttribute("index", new Quote());
        return "index";
    }

    @RequestMapping(value = "/", method = GET)
    public String welcome(Model model) {
        model.addAttribute("index", new Quote());
        return "index";
    }
}
