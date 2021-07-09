package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Kisi;
import service.KisiService;

@RestController
@RequestMapping("/kisiler")
@CrossOrigin(origins = "http://localhost:8081")
public class KisiController {
	
	public KisiService kisiService;
	
	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService = kisiService;
	}
	
	@GetMapping
	public List <Kisi> kisileriGetir() {
		return kisiService.tumKisileriGetir();
	}
	@PostMapping(path="/ekle")
	public Kisi yeniKisiEkle(@RequestBody Kisi kisi) {
		return kisiService.kisiEkle(kisi);
	}
	
	@GetMapping(path="/ara/{id}")
	public Optional<Kisi> idIleKisiListele(@PathVariable Integer id) {
		return kisiService.idIleKisiGetir(id);
	}
	
	@DeleteMapping(path="/sil/{id}")
	public String idIleKisiSil(@PathVariable Integer id) {
		return kisiService.idIleKisiSil(id);
	}
	
	@PutMapping(path="/guncelle")
	public Kisi guncelle(@RequestBody Kisi yeniKisi) {
		return kisiService.idIleKisiGuncelle(yeniKisi);
	}
	
	@PatchMapping(path = "/yenile/{id}")
	public Kisi idIleKismiGuncelle(@PathVariable Integer id, @Validated @RequestBody Kisi yeniKisi) {
		return kisiService.idIleKismiGuncelle(id, yeniKisi);
	}
	
	
	
}
