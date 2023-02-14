package com.example.pruebamicroservicioscolegio.ws.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.MateriasAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriasDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaMateriasAddDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Materias;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;
import com.example.pruebamicroservicioscolegio.ws.repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	MateriaRepository maRepo;

	public MateriasDTO consultarMat(String nombreMateria) {

		try {
			// Materias mat = maRepo.findByNombreMateria(nombreMateria);
			Map<String, Object> mat = maRepo.findByNombreMateria(nombreMateria);
			System.out.println("--- " + mat);
			if (mat != null) {
				MateriasDTO matResp = new MateriasDTO();
				matResp.setIdMateria(Integer.parseInt(mat.get("idMateria").toString()));
				matResp.setNombreMateria(mat.get("nombreMateria").toString());
				matResp.setNotaFinal(Double.parseDouble(mat.get("notaFinal").toString()));
				matResp.setIdAlumno(Integer.parseInt(mat.get("idAlumno").toString()));
				return matResp;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

		return null;

	}
	
	
	public RespuestaMateriasAddDTO crearMateria(MateriasAddDTO mateeAddDTO) {
		
		Materias mat = new Materias();
		mat.setNombreMateria(mateeAddDTO.getNombreMateria());
		mat.setIdAlumno(mateeAddDTO.getIdAlumno());
		mat.setNotaFinal(mateeAddDTO.getNotaFinal());
		maRepo.save(mat);
		RespuestaMateriasAddDTO ma= new RespuestaMateriasAddDTO();
		ma.setIdAlumno(mat.getIdAlumno());
		ma.setIdMateria(mat.getIdMateria());
		ma.setNombreMateria(mat.getNombreMateria());
		ma.setNotaFinal(mat.getNotaFinal());
		return ma;
		
	}
}
