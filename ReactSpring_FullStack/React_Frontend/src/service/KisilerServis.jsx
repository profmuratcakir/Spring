import axiosInstance from "./AxiosInstance";

const kisiEkle = (kisi) => {
  return axiosInstance.post("/ekle", kisi);
};

const tumKisileriGetir = () => {
  return axiosInstance.get("/");
};

const idIleKisiSil = (id) => {
  return axiosInstance.delete(`/sil/${id}`);
};

const idIleKisiGetir = (id) => {
  return axiosInstance.get(`/ara/${id}`);
};

//Patch işlemi
const idIleKisiGuncelle = (id, kisi) => {
  return axiosInstance.patch(`/yenile/${id}`, kisi);
};

const KisilerServis = {
  kisiEkle,
  tumKisileriGetir,
  idIleKisiSil,
  idIleKisiGetir,
  idIleKisiGuncelle,
};

export default KisilerServis;
