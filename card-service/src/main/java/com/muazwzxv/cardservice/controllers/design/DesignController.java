package com.muazwzxv.cardservice.controllers.design;

import com.muazwzxv.cardservice.controllers.design.Http.CreateDesignReqHttp;
import com.muazwzxv.cardservice.dto.DesignDto;
import com.muazwzxv.cardservice.services.design.IDesignService;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignRequest;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DesignController {
    private IDesignService designService;

    @PostMapping("/v1/design")
    public ResponseEntity<DesignDto> createDesign(
        @Valid @RequestBody CreateDesignReqHttp req
    ) {
        CreateDesignRequest arg = CreateDesignRequest.builder()
            .name(req.getName())
            .description(req.getDescription())
            .build();
        CreateDesignResponse resp = this.designService.createDesign(arg);
        return ResponseEntity.ok(resp.getDesign());
    }

    @GetMapping("/v1/design/{designUUID}")
    public ResponseEntity<DesignDto> getDesign(
        @PathVariable @NotEmpty(message = "uuid cannot be empty") String designUUID
    ) {
        DesignDto design = this.designService.getDesignByDesignUUID(designUUID);
        return ResponseEntity.ok(design);
    }

    @PutMapping("/v1/design")
    public ResponseEntity<Object> updateDesign() {
        return null;
    }
}
