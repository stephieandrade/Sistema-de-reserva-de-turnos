package com.example.ahorasi.service;


import com.example.ahorasi.entities.Odontologo;
import com.example.ahorasi.entities.OdontologoDTO;

import java.util.Collection;

public interface IOdontologoService {
    Odontologo guardarOdontologo(OdontologoDTO odo);
    Collection<OdontologoDTO> obtenerUsuarios();
    OdontologoDTO buscar(Long id);
    void eliminarOdontologo(Long id);
    Odontologo actualizar(OdontologoDTO odo);



}
