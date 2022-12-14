package com.ssafy.api.controller;

import com.ssafy.api.request.WcReq;
import com.ssafy.api.service.WorldCupService;
import com.ssafy.common.model.response.BaseResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "WC API", tags = {"WorldCup"})
@RestController
@RequestMapping("/api/wc")
public class WorldCupController {
    @Autowired
    WorldCupService worldCupService;

    @PostMapping()
    @ApiOperation(value = "wc 정보 전달", notes = "wc의 모든 정보를 제공한다.")
    public ResponseEntity<List> getWcs() {
        return ResponseEntity.status(200).body(worldCupService.getAllWcInfo());
    }

    @PostMapping("/result")
    @ApiOperation(value = "wc 결과 저장", notes = "월드컵 결과를 저장한다")
    public ResponseEntity<? extends BaseResponseBody> getInfoByNo(
            @RequestBody @ApiParam(value = "wcReq", required = true) WcReq wcReq) {
        worldCupService.createWcResult(wcReq);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }


}
