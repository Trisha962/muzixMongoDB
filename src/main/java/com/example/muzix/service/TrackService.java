package com.example.muzix.service;

import com.example.muzix.domain.Track;
import com.example.muzix.exception.ArtistNotFoundException;
import com.example.muzix.exception.MusicAlreadyExistException;
import com.example.muzix.exception.MusicNotFoundException;
import com.example.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackService implements ITrackService{
    @Autowired
    TrackRepository trackRepository;
    @Override
    public Track addTrack(Track track) throws MusicAlreadyExistException {
        if (trackRepository.findById(track.getTrackId()).isEmpty()) {
            Track track1 = trackRepository.save(track);
            return track1;
        }
        throw new MusicAlreadyExistException();
    }

    @Override
    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    @Override
    public String delete(Integer trackId) throws MusicNotFoundException {
        if (trackRepository.findById(trackId).isEmpty()) {
            throw new MusicNotFoundException();
        }
        trackRepository.deleteById(trackId);
        return "Track deleted Successfully";
    }

    @Override
    public List<Track> findByArtist(String artistName) throws ArtistNotFoundException {
        return trackRepository.findByArtist(artistName);
    }

    @Override
    public List<Track> findByRating(Integer trackRating) {
        return trackRepository.findByRating(trackRating);
    }

}
