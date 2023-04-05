package com.example.muzix.service;

import com.example.muzix.domain.Track;
import com.example.muzix.exception.ArtistNotFoundException;
import com.example.muzix.exception.MusicAlreadyExistException;
import com.example.muzix.exception.MusicNotFoundException;

import java.util.List;

public interface ITrackService {
    public Track addTrack(Track track) throws MusicAlreadyExistException;
    public List<Track> getAll();
    public String delete(Integer trackId) throws MusicNotFoundException;
    public List<Track> findByArtist(String artistName) throws ArtistNotFoundException;
    public List<Track> findByRating(Integer trackRating);
}
