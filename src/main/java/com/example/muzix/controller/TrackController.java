package com.example.muzix.controller;

import com.example.muzix.domain.Track;
import com.example.muzix.exception.ArtistNotFoundException;
import com.example.muzix.exception.MusicAlreadyExistException;
import com.example.muzix.exception.MusicNotFoundException;
import com.example.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TrackController {

    TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    //http://localhost:8089/api/v1/add-music
    @PostMapping("add-music")
    public ResponseEntity<?> add(@RequestBody Track track) throws MusicAlreadyExistException {
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.OK);
    }
    @GetMapping("/allmusic")
    public ResponseEntity<?>get(){
        return new ResponseEntity<>(trackService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("/music/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id) throws MusicNotFoundException {
        return new ResponseEntity<>(trackService.delete(id),HttpStatus.OK);
    }
    @GetMapping("/artist/{artist}")
    public ResponseEntity<?>getByArtist(@PathVariable String artist) throws ArtistNotFoundException {
        return new ResponseEntity<>(trackService.findByArtist(artist),HttpStatus.OK);
    }
    @GetMapping("/rating/{trackRating}")
    public ResponseEntity<?>getByRating(@PathVariable Integer trackRating){
        return new ResponseEntity<>(trackService.findByRating(trackRating),HttpStatus.OK);
    }
}
