package com.example.battleships.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ships")
public class ShipController {

    @GetMapping("/add")
    public String addShip(){
        return "ship-add";
    }


    @PostMapping("/add")
    public String addShipConfirm(){


    }

}
