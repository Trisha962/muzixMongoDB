package com.example.muzix.repository;

import com.example.muzix.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track,Integer> {
    @Query("{'Artist.artistName':{$in:[?0]}}")
    public List<Track> findByArtist(String artistName);
    @Query("{'trackRating':{$gte:4}}")
    public List<Track> findByRating(Integer trackRating);
}
