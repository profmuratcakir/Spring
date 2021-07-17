
package com.security.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kisiler")
public class Kisi {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String ad;
	private String soyad;
	private int yas;
	public Kisi(String ad, String soyad, int yas) {
		this.ad = ad;
		this.soyad = soyad;
		this.yas = yas;
	}
	public Kisi() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", yas=" + yas + "]";
	}
}