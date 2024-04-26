package br.newton.av1.repository;

import br.newton.av1.model.NoticiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends MongoRepository<NoticiaEntity, String>{
}
