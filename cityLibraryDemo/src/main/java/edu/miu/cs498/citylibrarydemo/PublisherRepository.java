package edu.miu.cs498.citylibrarydemo;

import edu.miu.cs498.citylibrarydemo.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
}


