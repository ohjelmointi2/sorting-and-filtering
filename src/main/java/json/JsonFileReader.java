package json;

import java.util.List;

public interface JsonFileReader<T> {
    public List<T> readAll();
}
