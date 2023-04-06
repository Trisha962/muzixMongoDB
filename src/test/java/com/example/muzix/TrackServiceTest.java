package com.example.muzix;

import com.example.muzix.domain.Artist;
import com.example.muzix.domain.Track;
import com.example.muzix.exception.MusicAlreadyExistException;
import com.example.muzix.repository.TrackRepository;
import com.example.muzix.service.TrackService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrackServiceTest {
    @Mock
    private TrackRepository trackRepository;
    @InjectMocks
    private TrackService trackService;
    private Track track;
    private Artist artist;

    @BeforeEach
    public void setUp(){

        track= new Track(10,"hii","5",artist);
        artist= new Artist(1,"Shankar");

    }
    @AfterEach
    public void remove(){
        track= null;
        artist= null;

    }
//    @Test
//    public void TestAddTrackSuccess() throws MusicAlreadyExistException {
//        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
//        when(trackRepository.insert(track)).thenReturn(track);
//      Track insertedTrack= trackService.addTrack(track);
//      assertEquals(track,insertedTrack);
//      verify(trackRepository,times(1)).findById(track.getTrackId());
//        verify(trackRepository,times(1)).insert(track);
//    }


}
