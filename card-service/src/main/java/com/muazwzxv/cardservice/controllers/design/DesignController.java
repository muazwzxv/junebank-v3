package com.muazwzxv.cardservice.controllers.design;

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
    @PostMapping("/v1/design")
    public ResponseEntity<Object> createDesign() {
        return null;
    }

    @PutMapping("/v1/design")
    public ResponseEntity<Object> updateDesign() {
        return null;
    }

    @GetMapping("/v1/design/{designUUID}")
    public ResponseEntity<Object> getDesign(
        @PathVariable @NotEmpty(message = "uuid cannot be empty") String designUUID
    ) {
        return null;
    }
}
