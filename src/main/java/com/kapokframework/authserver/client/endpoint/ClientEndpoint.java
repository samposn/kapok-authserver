package com.kapokframework.authserver.client.endpoint;

import com.kapokframework.authserver.client.model.ClientDetailsEntity;
import com.kapokframework.authserver.client.service.ClientDetailsEntityService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Will WM. Zhang
 * @since 2020-03-18 12:50
 */
@Controller
@RequestMapping("/client")
public class ClientEndpoint {

    private final ClientDetailsEntityService clientDetailsEntityService;

    public ClientEndpoint(ClientDetailsEntityService clientDetailsEntityService) {
        this.clientDetailsEntityService = clientDetailsEntityService;
    }

    /**
     * 创建
     *
     * @param clientDetailsEntity 将要创建的客户端数据
     */
    @PostMapping
    public String create(@ModelAttribute ClientDetailsEntity clientDetailsEntity) {
        this.clientDetailsEntityService.create(clientDetailsEntity);
        return "redirect:views/client";
    }

    /**
     * 获取
     *
     * @param clientId 根据 clientId 获取客户端数据
     * @return 返回获取到的客户端数据
     */
    @GetMapping("/{clientId}")
    @ResponseBody
    public ClientDetails retrieve(@PathVariable("clientId") String clientId) {
        return this.clientDetailsEntityService.retrieve(clientId);
    }

    /**
     * 搜索
     *
     * @return 列表 TODO
     */
    @GetMapping
    @ResponseBody
    public List<ClientDetailsEntity> list() {
        return this.clientDetailsEntityService.list();
    }
}
