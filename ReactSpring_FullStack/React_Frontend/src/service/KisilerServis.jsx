import axiosInstance from "./AxiosInstance";

const kisiEkle = (kisi) => {
  return axiosInstance.post("/ekle", kisi);
};

const KisilerServis = {
  kisiEkle,
};

export default KisilerServis;
