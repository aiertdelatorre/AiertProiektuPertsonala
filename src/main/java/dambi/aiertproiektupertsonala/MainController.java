package dambi.aiertproiektupertsonala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	DelitoRepository delitoRepository;

	@GetMapping("/select/Dena")
	public @ResponseBody List<Delito> hartuDenak() {

		List<Delito> lista = delitoRepository.eskuratuDenak();
		for (Delito i : lista) {
			i.codigos_delitos[0] = i.Crm_Cd_1;
			i.codigos_delitos[1] = i.Crm_Cd_2;
			i.codigos_delitos[2] = i.Crm_Cd_3;
			i.codigos_delitos[3] = i.Crm_Cd_4;
			i.coordenadas[0] = i.LAT;
			i.coordenadas[1] = i.LON;

		}
		return lista;
	}

	@GetMapping("/select/AukeratuBatID")
	public Delito hartuBat(@RequestParam String id) {
		Delito delito = delitoRepository.billatuId(id);
		System.out.println(delito);
		return delito;
	}

	@PutMapping("/update/EguneratuBatID")
	public void eguneratuBat(@RequestParam String id,@RequestParam String field,@RequestParam String value) {
	}

	@DeleteMapping("/delete/EzabatuBatID")
	public void ezabatuBat(@RequestParam String id) {
		delitoRepository.ezabatu(id);
	}

	@PostMapping("/insert/SartuBat")
	Delito sartuBat(@RequestParam int DR_NO,
			@RequestParam String Date_Rptd,
			@RequestParam String DATE_OCC,
			@RequestParam int TIME_OCC,
			@RequestParam int AREA,
			@RequestParam String AREA_NAME,
			@RequestParam int Rpt_Dist_No,
			@RequestParam int Part,
			@RequestParam int Crm_Cd,
			@RequestParam String Crm_Cd_Desc,
			@RequestParam int Vict_Age,
			@RequestParam String Vict_Sex,
			@RequestParam String Vict_Descent,
			@RequestParam int Premis_Cd,
			@RequestParam String Premis_Desc,
			@RequestParam int Weapon_Used_Cd,
			@RequestParam String Weapon_Desc,
			@RequestParam String Status,
			@RequestParam String Status_Desc,
			@RequestParam int Crm_Cd_1,
			@RequestParam int Crm_Cd_2,
			@RequestParam int Crm_Cd_3,
			@RequestParam int Crm_Cd_4,
			@RequestParam String LOCATION,
			@RequestParam String Cross_Street,
			@RequestParam double LAT,
			@RequestParam double LON) {

		return delitoRepository.gorde(DR_NO, Date_Rptd, DATE_OCC, TIME_OCC, AREA, AREA_NAME, Rpt_Dist_No, Part, Crm_Cd,
				Crm_Cd_Desc, Vict_Age, Vict_Sex, Vict_Descent,
				Premis_Cd, Premis_Desc, Weapon_Used_Cd, Weapon_Desc, Status, Status_Desc, Crm_Cd_1, Crm_Cd_2, Crm_Cd_3,
				Crm_Cd_4, LOCATION, null, LAT, LON);
	}
}
