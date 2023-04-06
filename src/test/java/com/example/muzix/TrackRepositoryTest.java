package com.example.muzix;

import com.example.muzix.domain.Artist;
import com.example.muzix.domain.Track;
import com.example.muzix.repository.TrackRepository;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TrackRepositoryTest
{
    @Autowired
    private TrackRepository trackRepository;
    private Track track;
    private Artist artist;
    @BeforeEach
    public void setUp(){
     trackRepository.deleteAll();
        track= new Track(10,"hii","5",artist);
        artist= new Artist(1,"Shankar");

    }
    @AfterEach
    public void remove(){
        track= null;
        artist= null;
    // trackRepository.deleteAll();
    }
    @Test
    public void testInsert(){
        Track insertedTrack=trackRepository.insert(track);
        assertEquals(insertedTrack,track);
    }
    @Test
    public void testFindAll(){
        trackRepository.insert(track);
        track.setTrackId(56);
        trackRepository.insert(track);
        track.setTrackId(58);
        trackRepository.insert(track);
        track.setTrackId(59);
        List<Track> tracks=trackRepository.findAll();
        assertEquals(3,tracks.size());
    }
    @Test
    public void testDeleteTrack(){
        trackRepository.insert(track);
        trackRepository.deleteById(track.getTrackId());
       List<Track>  tracks=trackRepository.findAll();
       assertEquals(0,tracks.size());
    }
    @Test
    @DisplayName("Testing Find by id")
    public void testFindById(){
        trackRepository.insert(track);
       Track retrievedTrack= trackRepository.findById(track.getTrackId()).get();
       assertEquals(retrievedTrack,track);
        System.out.println(track.equals(retrievedTrack));
        System.out.println(track);

    }
    @Test
    public void testDuplicateData() {
        trackRepository.insert(track);//success
       // trackRepository.insert(track);//exception
        assertThrows(DuplicateKeyException.class,()->trackRepository.insert(track));


    }
    @Test
    public void getTracks(){

        this.track = new Track(3,"Woee","7",this.artist);
        this.artist = new Artist(3,"Fuse");
        trackRepository.insert(track);
        List<Track> lt = trackRepository.findAll();
        assertEquals(1,lt.size());
    }
    @Test
    public void testFindByArtist() {

        Artist artist = new Artist(8, "shank");
        Track track = new Track(19, "Kartik", "5", artist);
        trackRepository.insert(track);
        List<Track> result = trackRepository.findByArtist("shank");
        assertEquals(1, result.size());
        assertTrue(result.contains(track));
    }


}




