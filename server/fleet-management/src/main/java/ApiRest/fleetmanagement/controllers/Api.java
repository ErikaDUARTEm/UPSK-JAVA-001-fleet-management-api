package fleetmanagement.controllers;
import org.springframework.web.bind.annotation.RestController;
@RestController
@ResquetMapping("api")
public class Api {
    @GetMapping("/saludar")
    public String saludar(){
        return "Hola desde spring boot";
    }
}
