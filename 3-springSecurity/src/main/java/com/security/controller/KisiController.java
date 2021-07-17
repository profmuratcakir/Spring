package com.security.controller;

import java.util.List;
import java.util.Optional;

import com.security.model.Kisi;
import com.security.service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RestController
@RequestMapping("/kisiler")
public class KisiController {

	public KisiService kisiService;

	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService = kisiService;
	}

	@GetMapping
	// Rolü ROLE_USER veya ROLE_ADMIN olan kullanicilar bu metoda erişebilir.
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List <Kisi> kisileriGetir() {
		return kisiService.tumKisileriGetir();
	}

	@PostMapping(path="/ekle")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Kisi yeniKisiEkle(@RequestBody Kisi kisi) {
		return kisiService.kisiEkle(kisi);
	}

	@GetMapping(path="/ara/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public Optional<Kisi> idIleKisiListele(@PathVariable Integer id) {
		return kisiService.idIleKisiGetir(id);
	}

	@DeleteMapping(path="/sil/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String idIleKisiSil(@PathVariable Integer id) {
		return kisiService.idIleKisiSil(id);
	}

	@DeleteMapping(path="/delete")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String herkesiSil() {
		return kisiService.tumKisileriSil();
	}

	@PutMapping(path="/guncelle")
	@PreAuthorize("hasAuthority('admin:write')")
	public Kisi guncelle(@RequestBody Kisi yeniKisi) {
		return kisiService.idIleKisiGuncelle(yeniKisi);
	}

	@PatchMapping(path = "/yenile/{id}")
	// Autohority'leri admin:write olan kullancılar bu metoda erişebilir.
	@PreAuthorize("hasAuthority('admin:write')")
	public Kisi idIleKismiGuncelle(@PathVariable Integer id, @Validated @RequestBody Kisi yeniKisi) {
		return kisiService.idIleKismiGuncelle(id, yeniKisi);
	}
}
