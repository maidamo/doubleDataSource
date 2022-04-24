package com.bobo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * 调用第三方接口测试控制类
 * yangbo
 */
@RestController
public class OaController {

    @Autowired
    private RestTemplate restTemplate;

    /***********HTTP GET method*************/
    @GetMapping("/testGetApi")
    public String getJson(){
        String url="http://missionhills.golfpartner-crm.com:8080/golfclub/sale/getSystemLoginData";
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        return json;
    }



    /**********HTTP POST method**************/
    @PostMapping(value = "/testPostApi")
    public Object testPost() {

        String json = "{\n" +
                "    \"accountIdentification\": \"\",\n" +
                "    \"accountLevel\": \"\",\n" +
                "    \"accountName\": \"测试奎1217\",\n" +
                "    \"accountNumber\": \"F342870\",\n" +
                "    \"accountOwner\": \"\",\n" +
                "    \"accountShortName\": \"测试奎1217\",\n" +
                "    \"administrativeArea\": \"华东\",\n" +
                "    \"city\": \"341200\",\n" +
                "    \"cityName\": \"\",\n" +
                "    \"contactPhone\": \"85 81 833 833\",\n" +
                "    \"copyStr\": \",\",\n" +
                "    \"country\": \"CN\",\n" +
                "    \"county\": \"\",\n" +
                "    \"countyName\": \"\",\n" +
                "    \"custAccountId\": \"23727\",\n" +
                "    \"dyAccountSiteId\": \"6491\",\n" +
                "    \"legalIdentification\": \"340823199807016511\",\n" +
                "    \"legalPerson\": \"Chang Cheng\",\n" +
                "    \"mergingArea\": \"\",\n" +
                "    \"oldAccountNumber\": \"F342862\",\n" +
                "    \"oldcustAccountId\": \"23631\",\n" +
                "    \"organizationType\": \"2\",\n" +
                "    \"province\": \"340000\",\n" +
                "    \"registrationAddress\": \"Building No. 353 Mao Tse Tong Blvd, Depo 1, ToulKork, Phnom Penh, Cambodia\",\n" +
                "    \"siteCode\": \"3433\",\n" +
                "    \"sitesAll\": {\n" +
                "        \"adjustEndDate\": \"2022-04-21\",\n" +
                "        \"adjustStartDate\": \"2022-04-21\",\n" +
                "        \"authorizationNo\": \"\",\n" +
                "        \"bankAccountName\": \"\",\n" +
                "        \"bankAccountNum\": \"\",\n" +
                "        \"bankBranchName\": \"\",\n" +
                "        \"city\": \"341200\",\n" +
                "        \"cityAddress\": \"\",\n" +
                "        \"country\": \"\",\n" +
                "        \"county\": \"341222\",\n" +
                "        \"creditAmount\": \"\",\n" +
                "        \"creditMode\": \"\",\n" +
                "        \"currencyCode\": \"\",\n" +
                "        \"isRecord\": \"\",\n" +
                "        \"joinDate\": \"2022-04-21\",\n" +
                "        \"operationStatus\": \"0\",\n" +
                "        \"province\": \"340000\",\n" +
                "        \"recordDate\": \"2022-04-21\",\n" +
                "        \"recordNumber\": \"\",\n" +
                "        \"relevance\": \"4\",\n" +
                "        \"remarks\": \"\",\n" +
                "        \"shipToAddress\": \"\",\n" +
                "        \"shipToPerson\": \"\",\n" +
                "        \"shipToPhone\": \"\",\n" +
                "        \"siteCode\": \"1\",\n" +
                "        \"statisticsAdjust\": \"1\",\n" +
                "        \"territoryId\": \"\",\n" +
                "        \"unitId\": \"10001\"\n" +
                "    },\n" +
                "    \"taxRegistrationNum\": \"0000000000000\",\n" +
                "    \"unitId\": \"10001\"\n" +
                "}";
        JSONObject postData = JSONObject.parseObject(json);
        String url = "http://10.10.19.30:8008/core/api/public/submitOAOperation?timeStamp=1650601737774&sign=f24a7d970acca5e6c5ce42f3d25fb6ce";
        JSONObject res = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
        if (Objects.nonNull(res) && !res.getBoolean("success")){
            System.out.println("接口调用结果为==============>：" + res.getBoolean("success"));
        }
        return res;
    }
}
