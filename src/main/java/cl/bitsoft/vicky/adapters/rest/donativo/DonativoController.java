package cl.bitsoft.vicky.adapters.rest.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/donativos")
public class DonativoController {

    @GetMapping("")
    public ResponseEntity<Object> getList() {
        ResponseEntity responseEntity = ResponseEntity.ok(new Donativo());
        return responseEntity;
    }

}
