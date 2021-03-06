package adn.oscar.reservascanchas.dominio.modelo;

import static adn.oscar.reservascanchas.dominio.Validaciones.*;

public class Cliente {

    public static final String EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO = "El nombre del cliente no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO = "El numero de telefono no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO = "El numero de telefono debe ser numerico.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO = "El numero de telefono no es correcto.";
    public static final String EL_NUMERO_DE_CEDULA_NO_PUEDE_ESTAR_VACIO = "El numero de cedula no puede estar vacio.";
    public static final String EL_NUMERO_DE_CEDULA_DEBE_SER_NUMERICO = "El numero de cedula debe ser numerico.";
    public static final String EL_NUMERO_DE_CEDULA_NO_ES_CORRECTO = "El numero de cedula no es correcto.";

    private final Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private final String cedula;

    public Cliente(Long id, String nombre, String correo, String telefono, String cedula) {
        validarCadenaVacia(nombre, EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO);
        validarCadenaVacia(telefono, EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(telefono, EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO);
        validarPositivo(telefono, EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO);
        validarCadenaVacia(cedula, EL_NUMERO_DE_CEDULA_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(cedula, EL_NUMERO_DE_CEDULA_DEBE_SER_NUMERICO);
        validarPositivo(cedula, EL_NUMERO_DE_CEDULA_NO_ES_CORRECTO);

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
