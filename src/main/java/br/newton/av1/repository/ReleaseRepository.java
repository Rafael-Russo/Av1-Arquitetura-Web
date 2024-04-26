package br.newton.av1.repository;

import br.newton.av1.model.ReleaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends MongoRepository<ReleaseEntity, String>{
}
