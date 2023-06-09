package kz.aidyninho.bitlabspringsprint2.repository;

import kz.aidyninho.bitlabspringsprint2.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByHandled(Boolean handled);

}
