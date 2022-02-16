package com.kapokframework.authserver.client.controller;

import com.kapokframework.authserver.client.service.ClientDetailsEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Will WM. Zhang
 * @since 2020-03-22 10:32
 */
@Controller
@RequestMapping("/views/client")
public class ClientController {

    private final ClientDetailsEntityService clientDetailsEntityService;

    public ClientController(ClientDetailsEntityService clientDetailsEntityService) {
        this.clientDetailsEntityService = clientDetailsEntityService;
    }


    @RequestMapping
    public String index(Model model) {
        model.addAttribute("clients", this.clientDetailsEntityService.list());
        return "client/client";
    }

}
