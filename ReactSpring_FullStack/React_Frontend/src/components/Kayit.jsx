import React, { useState } from "react";
import { Container, Form, Button } from "react-bootstrap";
import KisilerServis from "../service/KisilerServis";

const Kayit = () => {
  const [kisi, setKisi] = useState({ ad: "", soyad: "", yas: "" });
  const { ad, soyad, yas } = kisi;

  const degistir = (event) => {
    const { name, value } = event.target;
    setKisi(() => {
      return {
        ...kisi,
        [name]: value,
      };
    });
  };

  const handleSubmit = () => {
    KisilerServis.kisiEkle(kisi).then((res) => console.log(res));
  };

  return (
    <Container>
      <Form className="m-4">
        <Form.Group controlId="ad">
          <Form.Label>Ad</Form.Label>
          <Form.Control
            type="text"
            placeholder="Ad giriniz"
            value={ad}
            name="ad"
            onChange={degistir}
          />
        </Form.Group>

        <Form.Group controlId="soyad">
          <Form.Label>Soyad</Form.Label>
          <Form.Control
            type="text"
            placeholder="Soyad giriniz"
            value={soyad}
            name="soyad"
            onChange={degistir}
          />
        </Form.Group>

        <Form.Group controlId="yas">
          <Form.Label>Yaş</Form.Label>
          <Form.Control
            type="number"
            placeholder="Yaş giriniz"
            value={yas}
            name="yas"
            onChange={degistir}
          />
        </Form.Group>
        <div className="mt-3 text-center">
          <Button variant="primary" type="submit" onClick={handleSubmit}>
            Kaydet
          </Button>
          <Button variant="danger" type="reset" className="ms-2">
            Temizle
          </Button>
        </div>
      </Form>
    </Container>
  );
};

export default Kayit;
