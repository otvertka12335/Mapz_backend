package com.mapz.repo;

import com.mapz.model.Usr;
import org.springframework.data.repository.CrudRepository;

public interface UsrRepo extends CrudRepository<Usr, Integer> {
}
