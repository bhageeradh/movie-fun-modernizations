
package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.albumsapi.AlbumFixtures;
import org.superbiz.moviefun.albumsapi.AlbumInfo;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MovieFixtures;
import org.superbiz.moviefun.moviesapi.MovieInfo;
import org.superbiz.moviefun.moviesapi.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesClient;
    private final AlbumsClient albumClient;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesBean, AlbumsClient albumsBean, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesClient = moviesBean;
        this.albumClient = albumsBean;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {

        if (moviesClient.countAll() == 0) {
            for (MovieInfo movie : movieFixtures.load()) {
                moviesClient.addMovie(movie);
            }

        }


        for (AlbumInfo album : albumFixtures.load()) {
            albumClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumClient.getAlbums());

        return "setup";
    }
}

