package com.example.muzix.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
//@Getter
//@Setter
public class Artist {
    private int artistId;
    private String artistName;
@Override
public boolean equals(Object obj){
    Artist artist= (Artist)obj;
    if(this.getArtistName().equals(artist.getArtistName()) &&(this.getArtistId()==artist.getArtistId())){
        return true;
    }
    else{
        return false;
    }

}
}
