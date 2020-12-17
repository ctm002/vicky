package cl.bitsoft.vicky.adapters.rest.donativo;

import cl.bitsoft.vicky.adapters.rest.LexicalAnalyzer;
import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.services.donativo.DonativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/donativos")
public class DonativoResource {

    private final DonativoService donativoService;

    @Autowired
    public DonativoResource(DonativoService donativoService) {
        this.donativoService = donativoService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.readAll());
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Donativo donativo) {
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.create(donativo));
        return responseEntity;
    }

    @GetMapping("search")
    public ResponseEntity<Object> search(@RequestParam String q) {
        Long donante = new LexicalAnalyzer().extractWithAssure(q, "donante", Long::parseLong);
        Long beneficiario = new LexicalAnalyzer().extractWithAssure(q, "beneficiario", Long::parseLong);
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.findDonativosByIdDonante(donante));
        return responseEntity;
    }
}
