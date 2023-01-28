package code.elif.app.features.java16.streamApi;

import code.elif.app.model.Movie;
import code.elif.app.model.MovieUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MapMultiExample {

    private static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {
        String directorName = "Martin Scorsese";

        List<String> castList = findCastListWorkWithDirectorUsingMapMulti(directorName);
        System.out.println(castList);

        //    castList = findCastListWorkWithDirectorUsingFlatMap(directorName);
        //  System.out.println(castList);
    }

    private static List<String> findCastListWorkWithDirectorUsingMapMulti(String directorName) {

        return movies.stream().filter(movie -> movie.getDirector().contains(directorName))
                .<String>mapMulti(
                        (movie, consumer) -> {
                            List<String> castList = movie.getCast();
                            for (String cast : castList) {
                                consumer.accept(cast);
                            }
                        })
                .collect(Collectors.toList());
    }

    private static List<String> findCastListWorkWithDirectorUsingMapMultiRefactored(String directorName) {
        return movies.stream().filter(movie -> movie.getDirector().contains(directorName))
                .mapMulti(MapMultiExample::getCast)
                .toList();
    }

    private static void getCast(Movie movie, Consumer<String> consumer) {
        List<String> castList = movie.getCast();
        for (String cast : castList) {
            consumer.accept(cast);
        }
    }

    private static List<String> findCastListWorkWithDirectorUsingFlatMap(String directorName) {
        return movies.stream().filter(movie -> movie.getDirector().contains(directorName))
                .flatMap(movie -> movie.getCast().stream())
                .collect(Collectors.toList());
    }


}
