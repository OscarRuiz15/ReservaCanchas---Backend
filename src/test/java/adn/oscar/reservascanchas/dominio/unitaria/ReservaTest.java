package adn.oscar.reservascanchas.dominio.unitaria;

import adn.oscar.reservascanchas.dominio.excepcion.FormatoFechaException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorObligatorioException;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
import adn.oscar.reservascanchas.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReservaTest {

    private static final String FORMATO_FECHA = "yyyy-MM-dd H:m";
    private static final Cliente CLIENTE = new ClienteTestDataBuilder().build();
    private static final Cancha CANCHA = new CanchaTestDataBuilder().build();
    private static final double VALOR_PAGO = CANCHA.getPrecioReserva();
    private static final String FECHA_INICIO_RESERVA = "2021-01-13 15:30";
    private static final String FECHA_INICIO_RESERVA_ERRONEO = "2021/01/13-15:30";
    private static final String PARAMETRO_VACIO = "";

    @Test
    public void crearReservaTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
                .conCancha(CANCHA)
                .conCliente(CLIENTE)
                .conFechaInicioReserva(FECHA_INICIO_RESERVA);

        // act
        Reserva reserva = reservaTestDataBuilder.build();
        DateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
        String fechaInicioReserva = dateFormat.format(reserva.getFechaInicioReserva());

        // assert
        assertEquals(CANCHA, reserva.getCancha());
        assertEquals(CLIENTE, reserva.getCliente());
        assertEquals(FECHA_INICIO_RESERVA, fechaInicioReserva);
        assertEquals(VALOR_PAGO, reserva.getValorPago(), 0);
    }

    @Test
    public void crearReservaSinCanchaTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
                .conCancha(null);

        try {
            // act
            Reserva reserva = reservaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Reserva.NO_HA_ELEGIDO_CANCHA_A_RESERVAR, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearReservaSinClienteTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
                .conCliente(null);

        try {
            // act
            Reserva reserva = reservaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Reserva.NO_HAY_CLIENTE_A_REALIZAR_RESERVA, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearReservaSinFechaInicioTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
                .conFechaInicioReserva(PARAMETRO_VACIO);

        try {
            // act
            Reserva reserva = reservaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Reserva.LA_FECHA_DE_INICIO_RESERVA_ES_OBLIGATORIA, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void formatoFechasReservaErroneoTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
                .conFechaInicioReserva(FECHA_INICIO_RESERVA_ERRONEO);

        try {
            // act
            Reserva reserva = reservaTestDataBuilder.build();
            fail();
        } catch (FormatoFechaException formatoFechaException) {
            // assert
            assertEquals(Reserva.ERROR_PARSEANDO_FECHAS, formatoFechaException.getMessage());
        }
    }
}
