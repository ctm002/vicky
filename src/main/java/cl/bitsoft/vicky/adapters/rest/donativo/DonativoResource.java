package cl.bitsoft.vicky.adapters.rest.donativo;

import cl.bitsoft.vicky.adapters.rest.LexicalAnalyzer;
import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.models.donativo.Postulante;
import cl.bitsoft.vicky.domain.models.usuario.Usuario;
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

    @GetMapping("search-donante")
    public ResponseEntity<Object> searchByDonante(@RequestParam String q) {
        Long donante = new LexicalAnalyzer().extractWithAssure(q, "donante", Long::parseLong);
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.findDonativosByDonante(donante));
        return responseEntity;
    }

    @GetMapping("search-beneficiario")
    public ResponseEntity<Object> searchByBeneficiario(@RequestParam String q) {
        Long beneficiario = new LexicalAnalyzer().extractWithAssure(q, "beneficiario", Long::parseLong);
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.findDonativosByBeneficiario(beneficiario));
        return responseEntity;
    }

    @PutMapping("/{id}/postulantes")
    public ResponseEntity<Object> create(@RequestParam String id, @RequestBody String usuario) {
        ResponseEntity responseEntity = ResponseEntity.ok(this.donativoService.create(id, usuario));
//        return responseEntity;
        return null;
    }
}
