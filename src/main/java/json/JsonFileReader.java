package json;

import java.util.List;

public interface JsonFileReader<T> {
    public abstract List<T> readAll();
}
