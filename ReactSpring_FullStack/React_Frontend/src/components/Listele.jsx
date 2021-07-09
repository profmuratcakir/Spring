import React, { useState, useEffect } from "react";
import { Table, Container } from "react-bootstrap";
import KisilerServis from "../service/KisilerServis";
import { useHistory } from "react-router-dom";

const Listele = () => {
  const [kisiler, setKisiler] = useState([]);

  //? Listele komponenti her render edildiğinde ve kisiler hook'u her degistiginde useEffect Hook'u calisir.
  useEffect(() => {
    KisilerServis.tumKisileriGetir().then((res) => {
      setKisiler(res.data);
    });
  }, []);

  const handleSil = (id) => {
    KisilerServis.idIleKisiSil(id).then((res) => {
      setKisiler(kisiler.filter((kisi) => kisi.id !== id));
    });
  };

  const history = useHistory();

  const handleGuncelle = (id) => {
    history.push(`/guncelle/${id}`);
  };

  return (
    <Container className="mt-4">
      {kisiler.length === 0 ? (
        <h1 className="text-center">
          Veritabaninda Kayitli Kisi bulunmamaktadir.
        </h1>
      ) : (
        <div>
          <h1 className="text-center">KISILER TABLOSU</h1>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>#id</th>
                <th>Ad</th>
                <th>Soyad</th>
                <th>Yaş</th>
                <th style={{ width: "250px" }}>İşlemler</th>
              </tr>
            </thead>
            <tbody>
              {kisiler.map((kisi) => {
                const { ad, soyad, yas, id } = kisi;
                return (
                  <tr key={id}>
                    <td>{id}</td>
                    <td>{ad}</td>
                    <td>{soyad}</td>
                    <td>{yas}</td>
                    <td>
                      <button
                        className="btn btn-warning"
                        style={{ width: "100px" }}
                        onClick={() => handleGuncelle(id)}
                      >
                        Guncelle
                      </button>
                      <button
                        className="btn btn-danger"
                        onClick={() => handleSil(id)}
                        style={{ marginLeft: "10px", width: "100px" }}
                      >
                        Sil
                      </button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </Table>
        </div>
      )}
    </Container>
  );
};

export default Listele;
