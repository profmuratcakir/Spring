package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Kisi;

@Repository
public interface KisiRepository extends JpaRepository <Kisi, Integer> {

}
