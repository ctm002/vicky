package cl.bitsoft.vicky.adapters.rest.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.services.donativo.DonativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/donativos")
public class DonativoController {

    private final DonativoService donativoService;

    @Autowired
    public DonativoController(DonativoService donativoService) {
        this.donativoService = donativoService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getList() {
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.findAll());
        return responseEntity;
    }

}
