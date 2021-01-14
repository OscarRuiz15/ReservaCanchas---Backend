package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.aplicacion.manejadores.reserva.ManejadorCrearReserva;
import adn.oscar.reservascanchas.aplicacion.manejadores.reserva.ManejadorObtenerReserva;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorObtenerReserva manejadorObtenerReserva;

    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorObtenerReserva manejadorObtenerReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorObtenerReserva = manejadorObtenerReserva;
    }

    @PostMapping
    public Reserva agregar(@RequestBody ComandoReserva comandoReserva) {
        return this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @GetMapping("/{codigoCancha}/{cedulaCliente}")
    public Reserva buscar(@PathVariable(name = "codigoCancha") String codigoCancha,
                          @PathVariable(name = "cedulaCliente") String cedulaCliente) {
        return this.manejadorObtenerReserva.ejecutar(codigoCancha, cedulaCliente);
    }
}