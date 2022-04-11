package com.kruger.inventariovacunacionempleado.service;

import com.kruger.inventariovacunacionempleado.Dto.EmpleadoDTO;
import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.entity.Usuario;
import com.kruger.inventariovacunacionempleado.repository.EmpleadoRepository;
import com.kruger.inventariovacunacionempleado.repository.EstadoVacunacionRepository;
import com.kruger.inventariovacunacionempleado.repository.RolRepository;
import com.kruger.inventariovacunacionempleado.repository.UsuarioRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository,UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.empleadoRepository = empleadoRepository;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public List<Empleado> lista() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    public Empleado findbyId(Integer id) {
        return empleadoRepository.findById(id).get();
    }

    public EmpleadoDTO guardarEmpleado(Empleado empleado) {
        String s = validarInformacion(empleado);
        if (StringUtils.isBlank(s)) {
            generarUsuario(empleado);
            empleado = empleadoRepository.save(empleado);
            return convertEmpleadoADTO(empleado, true, "Empleado guardado con exito");
        } else {
            return convertEmpleadoADTO(empleado, false, s);
        }
    }

    public EmpleadoDTO actualizarEmpleado(Empleado empleado) {
        empleado = empleadoRepository.save(empleado);
        return convertEmpleadoADTO(empleado, true, "Empleado actualizado con exito");
    }

    private Empleado generarUsuario(Empleado empleado) {
        int ROL_EMPLEADO = 2;

        char c = empleado.getApellidos().charAt(0);
        Usuario usuario = new Usuario();
        usuario.setUsuario(c + empleado.getCedula());
        usuario.setPassword(c + empleado.getCedula());
        usuario.setEstado(true);
        usuario.setIdRol(rolRepository.findById(ROL_EMPLEADO).get());

        Usuario save = usuarioRepository.save(usuario);
        empleado.setIdUsuario(save);

        return empleado;
    }

    public void delete(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    private EmpleadoDTO convertEmpleadoADTO(Empleado empleado, Boolean estado, String mensaje) {
        return EmpleadoDTO.builder()
                .idEmpleado(empleado.getIdEmpleado())
                .nombres(empleado.getNombres())
                .apellidos(empleado.getApellidos())
                .cedula(empleado.getCedula())
                .correo(empleado.getCorreo())
                .direccion_domicilio(empleado.getDireccion_domicilio())
                .estadoVacunacion(empleado.getIdEstadoVacunacion().getNombreEstado())
                .fecha_nacimiento(empleado.getFecha_nacimiento())
                .telefono(empleado.getTelefono())
                .mensaje(mensaje)
                .guardado(estado)
                .rol(empleado.getIdUsuario().getIdRol().getNombreRol())
                .usuario(empleado.getIdUsuario().getUsuario())
                .password(empleado.getIdUsuario().getPassword())
                .build();
    }

    private String validarInformacion(Empleado empleado) {
        String msgs = "";

        if (StringUtils.isBlank(empleado.getCedula())) {
            msgs = msgs.concat(" La cedula  no puede estar vacia -");
        } else {
            if (empleado.getCedula().length() != 10) {
                msgs = msgs.concat(" La cedula debe contener 10 Digitos -");
            } else if (!StringUtils.isNumeric(empleado.getCedula())) {
                msgs = msgs.concat(" La cedula  no puede estar vacia -");
            }
        }

        if (StringUtils.isBlank(empleado.getNombres())) {
            msgs = msgs.concat(" Los nombres no pueden estar vacios -");
        } else {
            if (!contieneSoloLetras(empleado.getNombres())) {
                msgs = msgs.concat(" Los nombres no deben conterner numeros ni caracteres especiales");
            }
        }

        if (StringUtils.isBlank(empleado.getApellidos())) {
            msgs = msgs.concat(" Los apellidos no pueden estar vacios -");
        } else {
            if (!contieneSoloLetras(empleado.getApellidos())) {
                msgs = msgs.concat(" Los apellidos no deben conterner numeros ni caracteres especiales");
            }
        }

        if (StringUtils.isBlank(empleado.getCorreo())) {
            msgs = msgs.concat(" El correo no puede estar vacio -");
        } else {
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            Matcher mather = pattern.matcher(empleado.getCorreo());

            if (!mather.find()) {
                msgs = msgs.concat("El correo no es Valido");
            }
        }
        return msgs;
    }

    public static boolean contieneSoloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
}